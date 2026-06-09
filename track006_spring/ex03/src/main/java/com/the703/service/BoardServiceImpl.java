package com.the703.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired  BoardMapper  dao;  // db관련

	@Override public List<BoardDto> selectAll() { return dao.selectAll(); }  
	
	@Override public int insert(BoardDto dto) { 
		/*
		 * if(!file.isEmpty()) { String uploadPath = "C:/file/"; String bfile =
		 * file.getOriginalFilename(); File dest = new File( uploadPath +
		 * file.getOriginalFilename() );
		 * 
		 * try { file.transferTo(dest); } catch (IOException e) { e.printStackTrace(); }
		 * // 올리기
		 * 
		 * 
		 * dto.setBfile(bfile);
		 * 
		 * System.out.println("- 업로드성공> " + dest.getAbsolutePath()); }
		 */
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); } 
		catch (UnknownHostException e) { e.printStackTrace(); }
		return dao.insert(dto);
	}
	
	@Override public BoardDto detail(int bno) { 
		// 조회수 올리기  ##
		dao.updateHit(bno);
		return dao.select(bno); 
	}  
	
	@Override
	public BoardDto editView(int bno) {
		return dao.select(bno);
	}
	
	@Override
	public int edit(BoardDto dto) {	
		/*  int result =-1;  //비번 안맞음
		 	
		 	BoardDto find = dao.select(dto.getBno());
		 	if(find.getBpass().equals(dto.getBpass()))	{result=dao.update(dto);} 
		 	
		 	return result;
		 */
		return dao.update(dto);
	}// 비번맞으면 수정 
	
	/*
	 * @Override public int edit(BoardDto dto , MultipartFile file) { int result =
	 * -1; // 비번 안맞음
	 * 
	 * BoardDto find = dao.select( dto.getBno() ); // 해당유저찾기
	 * if(find.getBpass().equals( dto.getBpass() )) { // 글번호의 비번과 사용자가 입력한 비번이 같은지
	 * 확인
	 * 
	 * String fileName = dto.getBfile(); // #1. 기본파일명으로 들어간거 넣어놓고
	 * 
	 * if( !file.isEmpty()) { fileName = file.getOriginalFilename(); String
	 * uploadPath = "C:/file/"; File demp = new File( uploadPath + fileName );
	 * s
	 * try { file.transferTo(demp); } //#2. 파일올리기 catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * } dto.setBfile(fileName); // #3. 파일명셋팅 result = dao.update(dto); } return
	 * result; }// 비번맞으면 수정
	 */
	@Override
	public int delete(BoardDto dto) {
		/*    int result = -1; //비번 안맞음
		      BoardDto find = dao.select( dto.getBno() );  // 해당 유저찾기
      		  if(find.getBpass().equals( dto.getBpass() )) {  // 글번호의 비번과 사용자가 입력한 비번이 같은지 확인
      		  		result = dao.delete(dto.getBno());  
      		  }
		       return result;
		 */
		return dao.delete(dto);
	}// 비번맞으면 삭제

	/* paging */
	/* paging */
	@Override
	public List<BoardDto> select10(int pstartno) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", (pstartno-1)*10);  //// (1) 1 0번째부터  (2) 2 10번째부터
		map.put("end", 10);
		return dao.select10(map);
	}
	@Override public int selectCnt() { return dao.selectCnt(); }

}
