package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;
import com.the703.util.UtilPaging;

@Controller
@RequestMapping("/board")  // 공통 prefix
public class Sboard2Controller {
	
	@Autowired private Sboard2Service service;	
	
	//1. 전체 리스트
	@GetMapping("/list") // #2)  /board/list
	public String list( Model model , @RequestParam(value="pageNo" , defaultValue = "1") int pageNo ) {
		model.addAttribute("paging", new UtilPaging(service.selectCnt(), pageNo));
		model.addAttribute("list" , service.list10(pageNo));
		return "board/list";
	} // prefix(/templates) + board/list + suffix(.html)
	
	//2. 글쓰기 폼		GET: /board/write
	//3. 글쓰기 기능	POST: /board/write
	@GetMapping("/write") public String write() { return "board/write"; }

	@PostMapping("/write")
	public String write_post(MultipartFile file, Sboard2Dto dto, RedirectAttributes rttr) {
		String result = "글쓰기 실패";
		if(service.insert(file, dto) > 0) { result = "글쓰기 성공"; }
		rttr.addFlashAttribute("success", result);
		return "redirect:/board/list";
	}

	// 4. 상세보기 GET: /board/detail
	@GetMapping("/detail")
	public String detail(Sboard2Dto dto, Model model) {
		Sboard2Dto sboard2dto = service.detail(dto);
		model.addAttribute("dto", sboard2dto);
		return "board/detail";
	}

	// 5. 수정 폼 GET: /board/edit
	// 6. 수정 기능 POST: /board/edit
	@GetMapping("/edit") public String edit(Sboard2Dto dto, Model model) {
		model.addAttribute("dto", service.updateForm(dto));
		return "board/edit"; 
	}
	@PostMapping("/edit")
	public String edit_post(MultipartFile file,Sboard2Dto dto,RedirectAttributes rttr) {
		String inputPass = dto.getBpass();
		Sboard2Dto sboard2dto = service.detail(dto);
		
		if(sboard2dto != null && sboard2dto.getBpass().equals(inputPass)) {	
			if(service.update(file, dto) > 0) { 
				rttr.addFlashAttribute("success", "수정 성공"); 
				return "redirect:/board/detail?id=" + dto.getId();
			}
		}else {
			rttr.addFlashAttribute("success", "비밀번호가 일치하지 않습니다.");
		}
			return "redirect:/board/edit?id=" + dto.getId();
	}

	// 7. 삭제 폼 GET: /board/delete
	// 8. 삭제 기능 POST: /board/delete
	@GetMapping("/delete")
	public String delete(Sboard2Dto dto, Model model) {
		Sboard2Dto sboard2dto = service.detail(dto);
		model.addAttribute("dto", sboard2dto);
		return "board/delete";
	}

	@PostMapping("/delete")
	public String delete_post(Sboard2Dto dto, RedirectAttributes rttr) {
		String inputPass = dto.getBpass();
		Sboard2Dto sboard2dto = service.detail(dto);
		
		if(sboard2dto != null && sboard2dto.getBpass().equals(inputPass)) {
			if(service.delete(dto) > 0) { 
				rttr.addFlashAttribute("success", "삭제 성공");
				return "redirect:/board/list";  
			} 		
		} else {
			rttr.addFlashAttribute("success", "비밀번호가 일치하지 않습니다.");
		}
		return "redirect:/board/delete?id=" + dto.getId();
	}

}

/*
1. controller (서비스 빼고 연동)
- view
- 경로

2. controller (서비스 연결)
*/