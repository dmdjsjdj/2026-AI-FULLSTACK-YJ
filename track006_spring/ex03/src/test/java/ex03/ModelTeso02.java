package ex03;

import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)   //spring 구동
//@ContextConfiguration(locations = "classpath:config/*-context.xml")  // 위치설정
@ContextConfiguration( 
	locations = {"classpath:config/root-context.xml", "classpath:config/security-context.xml"})
public class ModelTeso02 {
	@Autowired UserMapper user;
	@Autowired UserService service;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	// import org.springframework.security.crypto.password.PasswordEncoder;
	
	/* security */
	@Test public void test4() {
		AuthDto dto2 = new AuthDto();   dto2.setEmail("a@a");
		System.out.println(user.readAuth(dto2));
	}
	
	@Ignore @Test public void test3() {
		/* 로그인시 인가 */
		AuthDto dto2 = new AuthDto();   dto2.setEmail("a@a");
		System.out.println(user.readAuth(dto2));
		
		/* 권한2개 줬으면 주석달고 위에 해당유저정보 가져오기 */
		/* 권한2개 - 회원, ADMIN */
//		AuthDto dto1 = new AuthDto();  dto1.setEmail("a@a");  dto1.setAuth("ROLE_MEMBER");
////		AuthDto dto1 = new AuthDto();  dto1.setEmail("a@a");  dto1.setAuth("ROLE_ADMIN");
//		System.out.println(user.insertAuth(dto1));
		
		/* 회원가입시 암호화성공-> 주석달고 위에 권한실행 */
		/* 회원가입 (암호화) pwencoder.encode("a") */
//		UserDto dto = new UserDto();
//		dto.setNickname("a");         dto.setBpass(pwencoder.encode("a"));
//		dto.setEmail("a@a");  dto.setMobile("0101122112"); 
//		System.out.println(service.insert(dto));
	}
	
	@Ignore @Test public void test2() {
			
		/* 회원가입  + 권한등록 */
		UserDto dto2 = new UserDto();
		dto2.setNickname("first");         dto2.setBpass("1122");
		dto2.setEmail("first@gmail.com");  dto2.setMobile("0101122112"); 
		System.out.println(service.insert(dto2));
	}
	
	@Ignore @Test public void test1() throws UnknownHostException {
		//이메일 중복 : findByEmail
		String foundByEmail = user.findByEmail("asdfgh@gmail.com");
		if(foundByEmail != null) {
			System.out.println(" 존재하는 이메일(중복)입니다. ");
		} else {
			System.out.println(" 사용 가능한 이메일입니다. ");
		}
		//마이페이지 : findByUno
		System.out.println("회원번호 " + user.findByUno(14));
		
		//로그인 : findLogin
		UserDto dto2 = new UserDto();
		dto2.setBpass("1111");   dto2.setEmail("asdfgh@gmail.com"); 
		System.out.println("로그인 > " + user.findLogin(dto2));
		
		//회원가입 : insert  - UserDto : nickname , bpass, email , mobile, bip
//		UserDto dto = new UserDto();
//		dto.setNickname("asdfgh"); 		 	dto.setBpass("1111");
//		dto.setEmail("asdfgh@gmail.com"); 	dto.setMobile("0101234567");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		System.out.println("회원가입 > " + user.insert(dto));
	}
}
