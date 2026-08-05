package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.service.PostService;
import com.thejoa703.service.UserService;

@SpringBootTest
@Transactional
class Boot2ApplicationTests_2_Service {

    @Autowired  private UserService userService;
    @Autowired  private PostService postService;

    private Long createTestUser(String email, String nickname) {
        UserRequestDto signupDto = new UserRequestDto();
        signupDto.setEmail(email);
        signupDto.setPassword("password123");
        signupDto.setNickname(nickname);
        signupDto.setProvider("local");

        MockMultipartFile profileImage = new MockMultipartFile(
                "profileImage",
                "test.png",
                "image/png",
                "test image content".getBytes()
        );

        UserResponseDto res = userService.createUser(signupDto, profileImage);
        return res.getId();
    }

    // UserService
    // ---------------------------------------------------------------------
    @Test
    @Order(1)
    @DisplayName("■ UserService-CRUD")
    void testUserService() {
    	Long userId = createTestUser("test1@email.com", "test1");

        // 회원가입
        LoginRequest login = new LoginRequest();
        login.setEmail("test1@email.com");
        login.setPassword("pass123");
        login.setProvider("local");

        // 이메일 닉네임 중복
        assertThat(userService.existsByEmail("test1@email.com")).isTrue();
        assertThat(userService.existsByNickname("test1")).isTrue();

        //마이페이지
        UserResponseDto user = userService.getUser(userId);
        assertThat(user.getNickname()).isEqualTo("test1");
        
        //유저닉네임 수정
        UserResponseDto updated = userService.updateNickname(userId, "newNick");  
        assertThat(updated.getNickname()) .isEqualTo("newNick");
        
        // 유저삭제
        userService.deleteById(userId); 
//        assertThrows( IllegalArgumentException.class, () -> userService.findById(userId) );
    }
}