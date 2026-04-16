package com.the703.basic009_ex;

public class MethodEx008 {
	
	public static int fact(int a) {
		if(a<=1) return 1;
		
		return a*fact(a-1);
	}

	public static void main(String[] args) {
		// 재귀로 4의 팩토리얼  구하기
		
		int result=fact(4);
		System.out.println(result);

	}

}
