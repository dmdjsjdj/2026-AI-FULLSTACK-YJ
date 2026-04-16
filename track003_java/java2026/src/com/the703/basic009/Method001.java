package com.the703.basic009;

public class Method001 {
	//#1. 마법상자(함수, 메서드, function) - 원하는 기능을 해주는 box
	//				결과물(리턴값)  마법상자이름(메서드명) 재료(파라미터)
	public static   void		          hello() {
		System.out.println("Hello");
	}
	public static void           	    line() {
		System.out.println("------");
	}
	///////////////////////////////////////////////
	public static void main(String[] args) {
		//#2. 마법상자 사용하기
		hello();
		line();
		hello();
		line();
		hello();
		line();
		hello();
		
	}
	///////////////////////////////////////////////

}
