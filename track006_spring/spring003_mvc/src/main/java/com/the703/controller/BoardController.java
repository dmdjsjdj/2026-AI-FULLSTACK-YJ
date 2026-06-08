package com.the703.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.BoardDto;
import com.the703.service.BoardService;
import com.the703.util.PagingUtil;

@Controller
public class BoardController {
	@Autowired BoardService service;
	
	// ■1. 전체리스트
//	@RequestMapping("/board/list.do")
//    public String list(Model model) {
//		model.addAttribute("list", service.selectAll());
//        return "board/list"; 
//    }
	@RequestMapping("/board/list.do")
    public String list(Model model, @RequestParam(value = "pstartno", defaultValue ="1") int pstartno) {
		
		model.addAttribute("paging", new PagingUtil( service.selectCnt() , pstartno)); /* service전체갯수 */
		model.addAttribute("list", service.select10(pstartno));     /* list10 */
        return "board/list"; 
    }
	//  /view (폴더) /board(폴더)/list(파일명) + .jsp (확장자)
	//테스트 : http://localhost:8080/spring003_mvc/board/list.do
	
	// ■2. 글쓰기 폼경로
	@RequestMapping( value="/board/write.do" , method=RequestMethod.GET)
	public String write() {
	    return "board/write";
	}
	//테스트 : http://localhost:8080/spring003_mvc/board/write.do
	
	// ■2. 글쓰기 기능
	@RequestMapping( value="/board/write.do" , method=RequestMethod.POST)
	public String write_post(BoardDto dto, RedirectAttributes rttr,
						    @RequestParam("file") MultipartFile file
						    ) throws IllegalStateException, IOException {
		String result = "글쓰기 실패";
		
		if(!file.isEmpty()) {
			String uploadPath = "C:/file/";
			String bfile = file.getOriginalFilename();
			
			File   dest		  = new File( uploadPath + file.getOriginalFilename() );
			file.transferTo(dest); // 올리기
			
			
			dto.setBfile(bfile);
			
			System.out.println("- 업로드성공> " + dest.getAbsolutePath());
		} else {

		    dto.setBfile("me.png");
		}
		
		if(service.insert(dto) > 0) { result = "글쓰기 성공"; }
		rttr.addFlashAttribute("result", result);  // Flash - 1번만 동작
		return "redirect:/board/list.do";  // response.sendRedirect + alert (x)
	}
	
	// ■3. 글상세보기
	@RequestMapping("/board/detail.do")
	public String detail(int bno, Model model) {
		model.addAttribute("dto", service.detail(bno));
	    return "board/detail";
	}
	//테스트 : http://localhost:8080/spring003_mvc/board/detail.do
	
	// ■4. 글수정폼 경로
	@RequestMapping(value="/board/edit.do" , method=RequestMethod.GET)
	public String edit(int bno, Model model) {
		model.addAttribute("dto", service.detail(bno));
	    return "board/edit";
	}
	//테스트 : http://localhost:8080/spring003_mvc/board/edit.do
	
	// ■4. 글수정 기능
	@RequestMapping( value="/board/edit.do" , method=RequestMethod.POST)
	public String edit_post(BoardDto dto, RedirectAttributes rttr,
		    				@RequestParam("file") MultipartFile file, String oldFile
		    				) throws IllegalStateException, IOException {
		String result = "비밀번호 확인!";
		
		if(!file.isEmpty()) {
			String uploadPath = "C:/file/";
			String bfile = file.getOriginalFilename();
			
			File   dest		  = new File( uploadPath + file.getOriginalFilename() );
			file.transferTo(dest); // 올리기
			
			
			dto.setBfile(bfile);
			
			System.out.println("- 업로드성공> " + dest.getAbsolutePath());
		}else {
		    dto.setBfile(oldFile);
		}
		
		if(service.edit(dto) > 0) { result = "수정 성공"; }
		rttr.addFlashAttribute("result", result);  // Flash - 1번만 동작
		return "redirect:/board/detail.do?bno="+dto.getBno();  // response.sendRedirect + alert (x)
	}
	/*
	 * //■4. 글수정 기능
	 * 
	 * @RequestMapping( value= "/board/edit.do" , method = RequestMethod.POST)
	 * public String edit_post( BoardDto dto,
	 * 
	 * @RequestParam("file") MultipartFile file, RedirectAttributes rttr) { // 알림창
	 * String result = "비밀번호 확인!"; if( service.edit(dto , file) > 0 ) { result =
	 * "수정성공"; } rttr.addFlashAttribute("result", result);
	 * 
	 * return "redirect:/board/detail.do?bno=" + dto.getBno(); }
	 */
	
	// ■5. 글삭제폼 경로
	@RequestMapping( value="/board/delete.do" , method=RequestMethod.GET )
	public String delete(int bno, Model model) {
		model.addAttribute("dto", service.detail(bno));
		
	    return "board/delete";
	}
	//테스트 : http://localhost:8080/spring003_mvc/board/delete.do
	
	// ■5. 글삭제 기능
	@RequestMapping( value="/board/delete.do" , method=RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {
		String result = "삭제 실패";
		 if( service.delete(dto) > 0 ) {  result = "삭제성공";  }
	      rttr.addFlashAttribute("result", result);
	      
	      return  "redirect:/board/list.do";  
	}
}
