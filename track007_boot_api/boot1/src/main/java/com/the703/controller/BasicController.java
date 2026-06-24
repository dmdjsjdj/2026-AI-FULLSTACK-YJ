package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
	
	
	//@RequestMapping("/tmpt")
	@GetMapping("/tmpt")
	public String tmpt() { return "tmpt"; } // prefix(/templates) + tmpt + suffix(.html)
	

	@ResponseBody
	@GetMapping("/tmpt2")
	public String tmpt2() { return "tmpt2"; } 
}
