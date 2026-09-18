package com.thejoa703.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.thejoa703.oauth2.CustomOAuth2User;

//import com.thejoa703.oauth2.CustomOAuth2User;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 보안게이트
/**
 * JWT 인증필터
 * - Authorization 헤더에서  Bearer 토큰추출
 * - JwtProvider로  Claims 파싱
 * - CustomOAuth2User  기반 Principal 생성 후 SecurityContext 에 저장
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // JWT 토큰 발급/검증
    private final JwtProvider jwtProvider;
    // 생성자 
    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }
    // ###  /uploads/  로 시작하는 요청은 JWT 필터 타지 않게 통과
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.startsWith("/uploads/")  || path.startsWith("/api/statistics/");
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
    	
        String header = request.getHeader("Authorization");
  
        if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try { 
                System.out.println("====== [Filter] 추출된 토큰: " + token);
                
                Claims claims = jwtProvider.parse(token).getBody();  
                Long userId = Long.parseLong(claims.getSubject());
                String role = claims.get("role", String.class);
                 
                System.out.println("====== [Filter] 파싱 성공 -> userId: " + userId + ", role: " + role);
                
                CustomOAuth2User userPrincipal = new CustomOAuth2User(userId, role);

                UsernamePasswordAuthenticationToken auth =
                       new UsernamePasswordAuthenticationToken(
                               userPrincipal, null, userPrincipal.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println("====== [Filter] SecurityContext에 인증 정보 저장 완료! ======");
 
            } catch (io.jsonwebtoken.ExpiredJwtException e) { 
                // ⚠️ 1. 토큰 만료 에러 집중 방어
                System.out.println("====== [Filter] JWT 토큰 만료 감지: " + e.getMessage());
                SecurityContextHolder.clearContext();
                
                // ⚠️ 2. 플러터(Dio)가 인식할 수 있도록 401 Unauthorized 상태 코드 설정
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); 
                response.setContentType("application/json;charset=UTF-8");
                
                // ⚠️ 3. 에러 메시지 본문 작성 및 전달
                response.getWriter().write("{\"error\": \"TOKEN_EXPIRED\", \"message\": \"JWT expired\"}");
                
                // ⚠️ 4. 중요: 다음 필터로 진행하지 않고 여기서 응답을 끝내고 리턴합니다.
                return;

            } catch (Exception e) { 
                // 토큰 파싱 중 발생한 기타 에러 (유효하지 않은 토큰, 서명 위조 등)
                System.out.println("====== [Filter] JWT 인증 실패 에러 원인: " + e.getMessage());
                e.printStackTrace(); 
                
                SecurityContextHolder.clearContext();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"error\": \"INVALID_TOKEN\", \"message\": \"" + e.getMessage() + "\"}");
                return;
            }
        } else { 
            System.out.println("  [Filter] Authorization 헤더가 누락되었거나 Bearer 형식이 아닙니다.");
        }

        // 정상적으로 토큰이 파싱되었거나, 아예 헤더가 없는 경우(익명 페이지 접근 등)에만 다음 필터로 진행
        chain.doFilter(request, response);
    }
}
