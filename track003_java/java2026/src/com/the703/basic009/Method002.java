package com.the703.basic009;

public class Method002 {
	// 1. 리턴값   메서드명(파라미터:재료★)
	//				   hello("lia");
	public static void hello(String name) {  //String name = "lia"
		System.out.println("Hello~"+name);
	}
	
	public static void icecream(int num) {
		System.out.println("아이스크림 "+num+"개");
	}
	

	/////////////////////////////////////////////
	public static void main(String[] args) {
			hello("lia");
			hello("sieon");
			
			icecream(1);
			icecream(2);
			
			info("lia"   , 10);		// lia 최종점수 10점
			info("sieon" , 9);		//sieon 최종점수 10점
			// public static 결과물 마법상자이름(재료) { }
			
	}
	/////////////////////////////////////////////

	public static void info(String name,int num) {
		System.out.println(name+" 최종점수 "+num+"점");
	}
	
}
