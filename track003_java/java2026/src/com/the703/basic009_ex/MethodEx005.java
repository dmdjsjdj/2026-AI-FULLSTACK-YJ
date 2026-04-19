package com.the703.basic009_ex;

public class MethodEx005 {
	
	public static void hello(int num) {
		if(num<1) {return ;}
		System.out.println("Hello"+num);
		hello(--num);
	}

	public static void main(String[] args) {
		//재귀함수 이용-> Hello5번 출력
		// hello5~hello1
		
		hello(5);

	}
	
	
//	public static void hello(int num) {
//		if(num>5) {return ;}
//		System.out.println("Hello"+num);
//		hello(++num);
//	}
//
//	public static void main(String[] args) {
//		//재귀함수 이용-> Hello5번 출력
//		// hello5~hello1
//		
//		hello(1);
//
//	}

}
