package com.thejoa703.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Tag(name="User Api", description="회원인증 및 관리 관련 API (Session & Swagger 지원)")   // swqgger
@RestController                              // @Controller + @ResponseBody   (객체형식)
@RequestMapping("/api/users")                   // @RequestMapping("/api/users")
@RequiredArgsConstructor
//@CrossOrigin(origins="*")                     // 공용으로 접근 가능 (기존방법)
public class UserController {
   
   private final UserService userService;
   
   // 사용자 등록 (회원가입)
   // ResponseEntity - Http 응답 - 상태코드(201) 전달
   // ResponseEntity<UserResponseDto> - 회원가입 결과: UserResponseDto, 상태 코드: 201 Created
   @Operation(summary="회원가입", description="새로운 사용자를 등록합니다.")
   @PostMapping(value = "/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   public ResponseEntity<UserResponseDto> createUser(
                        @ModelAttribute UserRequestDto request,      // multipart/form-data
                        @Parameter(description = "프로필 이미지 파일")   // swagger
                        @RequestPart(name="ufile", required=false) MultipartFile ufile ) {

//      return ResponseEntity.status(HttpStatus.CREATED).body(response);   // HttpStatus.CREATED 201
      return ResponseEntity.ok( userService.createUser(request, ufile) );
   }

   // 이메일 중복확인
   @Operation(summary="이메일 중복확인", description="사용 중인 이메일인지 중복 여부를 확인합니다.")
   @GetMapping("/check-email")
   public ResponseEntity<Boolean> checkEmail(   @Parameter(description = "확인할 이메일")
                                    @RequestParam("email") String email ) {
      return ResponseEntity.ok( userService.existsByEmail(email) );
   }
   
   // 닉네임 중복확인
   @Operation(summary="닉네임 중복확인", description="사용 중인 닉네임인지 중복 여부를 확인합니다.")
   @GetMapping("/check-nickname")
   public ResponseEntity<Boolean> checkNickname(   @Parameter(description = "확인할 닉네임")
                                       @RequestParam("nickname") String nickname ) {
      return ResponseEntity.ok( userService.existsByNickname(nickname) );
   }
   
   // 로그인
   @Operation(summary="로그인", description="이메일과 비밀번호로 로그인하여 세션을 생성합니다.")
   @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<UserResponseDto> login(   @RequestBody LoginRequest request,
                                       HttpSession session ) { // import jakarta.servlet.http.HttpSession;
//      Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
//      if( userId == null ) {
//         return ResponseEntity.status(401).build();   // 권한없음
//      }
      
//      return ResponseEntity.ok( userService.getUser(userId) );
      UserResponseDto user = userService.login(request);
      session.setAttribute("LOGIN_USER_ID", user.getId());   // 세션셋팅
      
      return ResponseEntity.ok( user );
   }
   
   // 로그아웃
   @Operation(summary="로그아웃", description="로그아웃")
   @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Void> logout(HttpSession session){
	   session.invalidate();
	   return ResponseEntity.noContent().build();
   }
   
   // 마이페이지
   // 사용자 단건조회         - /api/users/1   해당id번호=1
   @Operation(summary="사용자 단건조회", description="사용자 아이디(id)로 특정회원 정보를 조회합니다.")
   @GetMapping("/{id}")
   public ResponseEntity<UserResponseDto> getUser(HttpSession session) {

      Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
      if( userId == null ) {  return  ResponseEntity.status(401).build();  }   // 권한없음.
      return  ResponseEntity.ok(  userService.getUser(userId));  
//      return ResponseEntity.status(HttpStatus.OK).body(response);      // HttpStatus.OK 
   }
   
   // Update: 닉네임변경
   @Operation(summary = "닉네임 변경", description="특정 사용자의 닉네임을 변경합니다.")
   @PatchMapping("/{userId}/nickname")  // Patch
   public ResponseEntity<UserResponseDto> updateNickname(
          @Parameter(description = "사용자 ID")   @PathVariable("userId") Long userId,  
          @Parameter(description = "변경할 닉네임") @RequestParam("nickname") String nickname   
   ) {
       return ResponseEntity.ok(userService.updateNickname(userId, nickname));
   }
   
   // Update: 프로필이미지변경
   @Operation(summary = "프로필 이미지 업로드/교체", description="특정 사용자의 프로필이미지를 변경합니다.")
   @PatchMapping(value = "/{userId}/profile-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   public ResponseEntity<UserResponseDto> updateProfileImage(
           @PathVariable("userId") Long userId,
           @RequestParam("ufile") MultipartFile ufile
   ) {
       return ResponseEntity.ok(userService.updateProfileImage(userId, ufile));
   }
   
   // Delete: 회원탈퇴
   @Operation(summary = "사용자 삭제(soft delete)", description="특정 사용자의 유저정보를 삭제합니다.")
   @DeleteMapping
   public ResponseEntity<Void> deleteByEmail(@RequestParam("userId") Long userId) {
       userService.deleteById(userId);
       return ResponseEntity.noContent().build();
   }
}

// http://localhost:8484/swagger-ui/index.html

//1. User Api    - 사용자 관련 API
//- POST     /api/users         회원가입
//- GET      /api/users/{id}    사용자 단건조회
//- GET         이메일중복검사
//- GET         닉네임중복검사
//- GET         전체 사용자 수
//- PUT         닉네임변경
//- PUT         프로필이미지변경
//- DELETE      회원탈퇴