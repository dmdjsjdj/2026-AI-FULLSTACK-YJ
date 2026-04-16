package com.the703.basic009_ex;

public class MethodEx007 {
	
	public static int plus(int n) {
		if(n<=1) return 1;
		
		return n + plus(n-1);
	}

	public static void main(String[] args) {
		//재귀이용 1~5합계 누적
		int n=5;
		System.out.print("1부터"+n+"까지의 합계: "+ plus(n));

	}

}
