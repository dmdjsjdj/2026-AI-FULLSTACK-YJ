package com.the703.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.the703.dao.UserMapper;
import com.the703.dto.AuthUserDto;
 
public class CustomUserDetailsService   implements UserDetailsService{

	@Autowired  UserMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username)
	        throws UsernameNotFoundException {
		
		System.out.println("입력 이메일 : [" + username + "]");
		
	    AuthUserDto dto = mapper.readAuth(username);

	    if(dto == null) {
	        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
	    }

	    return new CustomUser(dto);
	}

}
