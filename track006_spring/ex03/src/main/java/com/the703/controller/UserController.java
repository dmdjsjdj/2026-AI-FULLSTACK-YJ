package com.the703.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.UserDto;
import com.the703.service.UserService;

@Controller
public class UserController {
	@Autowired UserService service;
	
	// 1. 회원가입 폼 경로 (GET)
		@RequestMapping(value = "/users/join.do", method = RequestMethod.GET)
		public String insertForm() {
			return "users/join"; // -> /WEB-INF/views/users/join.jsp로 이동
		}
		
		// 2. 회원가입 기능 처리 (POST)
		@RequestMapping(value = "/users/join.do", method = RequestMethod.POST)
		public String insertAction(UserDto dto, RedirectAttributes rttr) {
			// UserServiceImpl에서 IP(bip) 설정을 자동으로 처리해 줍니다.
			int result = service.insert(dto);
			
			if(result > 0) {
				rttr.addFlashAttribute("msg", "회원가입이 완료되었습니다. 로그인해 주세요.");
			} else {
				rttr.addFlashAttribute("msg", "회원가입에 실패했습니다.");
				return "redirect:/users/join.do"; // 실패 시 가입 폼으로 리다이렉트
			}
			
			// 요구사항: 처리 후 로그인 폼으로 이동 (리다이렉트)
			return "redirect:/users/login.do";
		}
		
		// 3. 로그인 폼 경로 (GET)
		@RequestMapping(value = "/users/login.do", method = RequestMethod.GET)
		public String loginForm() {
			return "users/login"; // -> /WEB-INF/views/users/login.jsp로 이동
		}
		
		// 4. 로그인 기능 처리 (POST)
		@RequestMapping(value = "/users/login.do", method = RequestMethod.POST)
		public String loginAction(UserDto dto, HttpSession session, RedirectAttributes rttr) {
			// service.findLogin(dto)의 리턴 타입이 int이므로 일치하는 회원 수(1) 또는 성공 여부(1)로 판단합니다.
			int loginResult = service.findLogin(dto);
			
			if(loginResult > 0) {
				// 로그인 성공 시 세션에 이메일 정보 저장 (상단 nav 바의 ${sessionScope.email} 조건과 연동)
				session.setAttribute("email", dto.getEmail());
				return "redirect:/board/list.do"; // 로그인 성공 후 메인 페이지 또는 원하는 경로로 이동
			} else {
				// 로그인 실패 시
				rttr.addFlashAttribute("errorMsg", "이메일 또는 비밀번호가 일치하지 않습니다.");
				return "redirect:/users/login.do"; // 실패 시 로그인 폼으로 리다이렉트
			}
		}
		// 5. 마이페이지 화면 요청 (GET)
		@RequestMapping(value = "/users/mypage.do", method = RequestMethod.GET)
		public String mypage(HttpSession session, org.springframework.ui.Model model, RedirectAttributes rttr) {
			// 로그인할 때 세션에 저장해 둔 이메일 정보를 가져옵니다.
			String email = (String) session.getAttribute("email");
			
			// 만약 로그인 세션이 만료되었거나 비로그인 상태라면 로그인 페이지로 튕겨냅니다.
			if (email == null) {
				rttr.addFlashAttribute("errorMsg", "로그인이 필요한 서비스입니다.");
				return "redirect:/users/login.do";
			}
			
			// 현재는 임시로 테스트하기 위해 회원 번호(uno)를 1번으로 고정하여 조회합니다.
			// (추후 로그인 시 세션에 email과 함께 uno를 같이 저장해 두면 더 안전하게 연동할 수 있습니다.)
			int testUno = 1; 
			UserDto userDto = service.findByUno(testUno);
			
			// 가져온 회원 정보를 'user'라는 이름으로 JSP 화면에 전달합니다.
			model.addAttribute("user", userDto);
			
			return "users/mypage"; // -> /WEB-INF/views/users/mypage.jsp로 이동
		}
}
