package com.the703.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.the703.service.UserService;

@Controller
public class SerchController {
	
	@Autowired  UserService service;
	
	
	@ResponseBody
	@RequestMapping(value="/users/emailCheck",
	        method=RequestMethod.GET)
	public Map<String, Boolean> emailCheck(
	        @RequestParam("email") String email){

	    Map<String, Boolean> result = new HashMap<>();

	    result.put("exists",
	            service.findByEmail(email) != null);

	    return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/users/nicknameCheck",
	        method=RequestMethod.GET)
	public Map<String, Boolean> nicknameCheck(
	        @RequestParam("nickname") String nickname){

	    Map<String, Boolean> result = new HashMap<>();

	    result.put("exists",
	            service.findByNickname(nickname) != null);

	    return result;
	}
	
}
