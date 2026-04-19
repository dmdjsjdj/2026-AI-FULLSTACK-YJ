package com.the703.basic009_ex;

public class MethodEx009 {
	
	public static int fibonacci(int a) {
		if(a==1||a==2) {
			return 1;
		}
		else {
			return fibonacci(a-2)+fibonacci(a-1);
		}
		
//		다른버전
//		if(a<=1) { return a; }
//		return fibonacci(a-2)+fibonacci(a-1);

	}

	public static void main(String[] args) {
		// 재귀로 피보나치 수열 구하기
		//(0)  1 (0+1) 1 (1+1) 2 (1+2) 3  시작이 1, 1이고 앞에 두 수를 더한 값
		//     
		for(int i=1;i<5;i++)
			System.out.print(fibonacci(i)+" ");

	}

}
