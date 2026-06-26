package com.the703.dto;

import lombok.Data;

@Data
public class AppUserDto {
	private Integer appUserId;
	private String email;
	private String password;
	private Integer mbtiTypeId;
	private String createAt;
	private String ufile;
	private String moblie;
	private String nickname;
	private String provider;
	private String providerId;
}

/*
--SQL> desc appuser;
--Name                                      Null?    Type
------------------------------------------- -------- ----------------------------
--APP_USER_ID                               NOT NULL NUMBER(5)
--EMAIL                                     NOT NULL VARCHAR2(100)
--PASSWORD                                           VARCHAR2(100)
--MBTI_TYPE_ID                                       NUMBER(3)
--CREATED_AT                                         DATE
--UFILE                                              VARCHAR2(255)
--MOBILE                                             VARCHAR2(50)
--NICKNAME                                           VARCHAR2(50)
--PROVIDER                                  NOT NULL VARCHAR2(50)
--PROVIDER_ID                                        VARCHAR2(100)
--
*/