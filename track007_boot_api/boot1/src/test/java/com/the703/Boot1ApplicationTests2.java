package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.service.AppUserService;

@SpringBootTest
class Boot1ApplicationTests2 {
	@Autowired AppUserDao dao;
	@Autowired AppUserService service;
	
	

	// 사용자삭제 + 권한삭제
	@Disabled @Test  public void deleteService_User() {
		AppUserDto  user = new AppUserDto();
		user.setEmail("2@2");  user.setPassword("2");  user.setAppUserId(61);
		
		assertEquals(1, service.delete(user, true));   // 예상되는 결과, 코드
	}
	
	// 수정 (동적sql)
	@Disabled @Test  public void updateService_User() {
		AppUserDto  user = new AppUserDto();
		user.setEmail("2@2");  user.setPassword("2");  
		user.setUfile("12.png");  user.setMobile("0102222222");   user.setNickname("2");
		user.setProvider("local");  user.setProviderId("local_001");  user.setAppUserId(61);
		
		MockMultipartFile file = new MockMultipartFile("file", "test.text", "text/plain", "data".getBytes());
		
		assertEquals(1, service.update(file, user));   // 예상되는 결과, 코드
	}
	
	
	// 아이디중복
	@Disabled @Test  public void iddoubleService_User() {
		int mypage = service.iddouble("2@2", "local");
		
		assertEquals(1, mypage);
	}
	
	// 마이페이지
	@Disabled @Test  public void mypageService_User() {
		AppUserDto  mypage = service.selectEmail("2@2", "local");

		assertNotNull(mypage);
		assertEquals("2@2", mypage.getEmail());
	}
	
	// 로그인
	@Disabled @Test  public void loginService_User() {
		AppUserAuthDto login = service.readAuthByEmail("2@2", "local");
		
		assertNotNull(login);
		assertEquals("2@2", login.getEmail());
		assertTrue( login.getAuthList().stream().anyMatch(a-> "ROLE_MEMBER".equals(a.getAuth())) );
	}
	
	// 회원가입 - 유저등록, 권한등록
	@Test  public void insert_Service_User() {
		AppUserDto  user = new AppUserDto();
		user.setEmail("2@2");  user.setPassword("2");  user.setMbtiTypeId(1);
		user.setUfile("1.png");  user.setMobile("0101111111");   user.setNickname("2");
		user.setProvider("local");  user.setProviderId("local_001");
		
		MockMultipartFile file = new MockMultipartFile("file", "test.text", "text/plain", "data".getBytes());
		
		int result = service.insert(file, user);
		assertEquals(1, result);   // 예상되는 결과, 코드
	}

}

/*
	//6. 수정 (동적sql)
	
	
	//5. 사용자삭제 + 권한삭제
	@Disabled @Test  public void delete_User() {
		AppUserDto  user = new AppUserDto();
		user.setAppUserId(21);;
		assertEquals(1, dao.deleteAppUser(user));
		
		AuthDto auth = new AuthDto();
		auth.setEmail("1@1");  
		assertEquals(1, dao.deleteAuth(auth));   // 예상되는 결과, 코드
	}
	
	//4. 마이페이지
	@Disabled @Test  public void mypage_User() {
		AppUserDto  user = new AppUserDto();
		user.setEmail("1@1");
		assertEquals("1@1", dao.findByEmail(user).getEmail());
	}
	
	//3. 아이디중복
	@Disabled @Test  public void iddouble_User() {
		AppUserDto  user = new AppUserDto();
		user.setEmail("1@1");
		assertEquals(1, dao.iddoubleByEmail(user));
	}
	
	//2. 로그인
	@Disabled @Test  public void login_User() {
		AppUserDto  user = new AppUserDto();
		user.setEmail("1@1");
		assertNotNull(dao.readAuthByEmail(user));
	}
	
	//1. 회원가입 - 유저등록, 권한등록
	@Disabled @Test  public void insert_User() {
		AppUserDto  user = new AppUserDto();
		user.setEmail("1@1");  user.setPassword("1");  user.setMbtiTypeId(1);
		user.setUfile("1.png");  user.setMobile("01011111111");   user.setNickname("1");
		user.setProvider("local");  user.setProviderId("local_001");
		
		int result = dao.insertAppUser(user);
		assertEquals(1, result);   // 예상되는 결과, 코드
		//org.junit.jupiter.api.Assertions.assertEquals;
		
		AuthDto auth = new AuthDto();
		auth.setEmail("1@1");  auth.setAuth("ROLE_USER");
		int result_auth = dao.insertAuth(auth);
		assertEquals(1, result_auth);   // 예상되는 결과, 코드
	}
 */
