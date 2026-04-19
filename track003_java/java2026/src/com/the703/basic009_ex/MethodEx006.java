package com.the703.basic009_ex;

public class MethodEx006 {
	
	public static void test(int num) {
		if(num<1) {return ;}
		System.out.print(num+"\t");
		test(--num);
	}

	public static void main(String[] args) {
		//재귀함수 이용 10 카운트
		test(10);
	}

}
