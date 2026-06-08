package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingUtil {
	
	   private  int  listtotal;     //#1) 전체글 176
	   private  int  onepagelist;   //#2) 한페이지에 보여줄 게시물의 수 10
	   private  int  pagetotal;     //#3) 총 페이지수  176/10 = 18 
	   private  int  bottomlist;    //#4) 하단에 페이지 나누기 - 이전 11 12 13 ,,, 19 20
	   private  int  pstartno;      //#5) 페이지 시작번호 - 스타트 번호
	   
	   private  int current;        //#6) 현재 페이지번호  15
	   private  int start;          //#7) 시작  11
	   private  int end;            //#8) 마지막 20
	   
	   public PagingUtil(int listtotal, int pstartno) {  // 전체 페이지수, 시작하는 번호 1 2 3 4 5 6  ,,,
	      super();
	      this.listtotal = listtotal;  // 전체 페이지수
	      this.onepagelist = 10;	   // 한페이지에 보여줄 게시물의 수
	      this.pagetotal = listtotal <= 0 ? 1 :
	    	  			   (int)Math.ceil(listtotal/ (double)onepagelist);  // 176/10 = 17 18로..
	      this.bottomlist = 10;
	      this.pstartno = (pstartno-1)*onepagelist;    // (1) 1  0번째부터, 10개   (2) 2   10번째부터, 10개
	      this.current	= pstartno;   //  <이전  11 12 13 14 15(현재) 16 17 18 19 20 다음>
	      this.start	= ((this.current-1)/this.bottomlist)*this.bottomlist +1; //15라면 11로 만들기  20이라면 11로 만들기
	    		  // 15 -> 11  앞자리를 1로  ((15-1)/10)*10 + 1 = 11
	    		  // 20 -> 11  앞자리를 1로  ((20-1)/10)*10 + 1 = 11
	      this.end		=   this.start + this.bottomlist -1;  //15에서 20으로  20에서 20으로
	    		  // 15 -> 20  11+10-1 = 20
	    		  // 20 -> 20  11+10-10 = 20
	      if(this.end > this.pagetotal) { this.end = this.pagetotal; }  // 전체페이지 갯수가 176 -> 마지막은 20이 아니라 18
	   }   
}
