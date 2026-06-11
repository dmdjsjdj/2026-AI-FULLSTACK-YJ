package com.the703.dto;

import java.util.List;
import lombok.Data;

@Data
public class AuthUserDto {
	public String email;
	public String bpass;
	public List<AuthDto> authList;
}
