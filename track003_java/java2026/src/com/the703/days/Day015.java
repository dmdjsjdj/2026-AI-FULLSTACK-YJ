package com.the703.days;

public class Day015 {

	public static void main(String[] args) {
//		1.  for, while , do while을 이용해서 문제를 풀으시오.
//	     3   2   1
		for(int i=3;i>=1;i--) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		int i=3;
		while(i>=1) {
			System.out.print(i+" ");
			i--;
		}
		System.out.println();
		
		 i=3;
		do {
			System.out.print(i+" ");
			i--;
		}while(i>=1);
		System.out.println();
//		2 이중 for 버전
//		다음과 같은 모양을 출력하는 프로그램을 작성하시오.
//		★★★
//		★★
//		★
		for(int j=3;j>=1;j--) {
			for(int k=1;k<=j;k++) {
				System.out.print("★");
			}System.out.println();
		}
		System.out.println();
//		3.  1차원배열      new 연산자 이용해서 배열만들기
//		    1. 배열명 : arr     
//		    2. 값 넣기 :   A B C        for+length 이용서 값 대입
//		    3. for + length 로 출력 
		
		char[] arr = new char[3];
		
		for(int i1=0;i1<arr.length;i1++) {
			for(char a=0;a<=i1;a++) {
				arr[i1]=(char)('A'+(a*1));
			}
		}
		for(int i1=0;i1<arr.length;i1++) {
			System.out.print(arr[i1]+" ");
		}
	}	

}
