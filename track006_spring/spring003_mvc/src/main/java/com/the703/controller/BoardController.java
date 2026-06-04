package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/board/list.do")
    public String list() {
        return "/board/list"; // /view (폴더) /board(폴더)/list(파일명) + .jsp (확장
    }
	//테스트 : http://localhost:8080/spring003_mvc/board/list.do
	@RequestMapping("/board/write.do")
	public String write() {
	    return "board/write";
	}
	//테스트 : http://localhost:8080/spring003_mvc/board/write.do
	@RequestMapping("/board/detail.do")
	public String detail() {
	    return "board/detail";
	}
	//테스트 : http://localhost:8080/spring003_mvc/board/detail.do
	@RequestMapping("/board/edit.do")
	public String edit() {
	    return "board/edit";
	}
	//테스트 : http://localhost:8080/spring003_mvc/board/edit.do
	@RequestMapping("/board/delete.do")
	public String delete() {
	    return "board/delete";
	}
	//테스트 : http://localhost:8080/spring003_mvc/board/delete.do
}
