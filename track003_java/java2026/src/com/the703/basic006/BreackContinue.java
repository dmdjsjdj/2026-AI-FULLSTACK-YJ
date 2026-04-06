package com.the703.basic006;

import java.util.Scanner;

public class BreackContinue {

	public static void main(String[] args) {
		//ver-0
//		{int a=1; System.out.println(a);} //영역
//		a=2;  //영역 밖이라 사용x
		
		//ver-1 for 반복
//		  반복   영역(여기부터       여기까지)
//		for(;;){System.out.println(1);}

		//ver-2 반복 빠져나오기  ( break / 
		for( int i=1 ; i<5 ; i++) {   //     for( 초기값  ; 조건 ; 증감 )
			if(i==3) {break;}	   //나가
			System.out.println(i);
		}
		
		////////////////////////////////////
		System.out.println();
		for( int i=1 ; i<5 ; i++) {   //     for( 초기값  ; 조건 ; 증감 )
			if(i==3) {continue;}   //스킵 (조건 충족시 밑에 과정 진행x하고 넘어감) -> 1 2 4
			System.out.println(i);
		}
		
		int a=-1;
		Scanner scanner = new Scanner(System.in);
		//ver-3
		for(;;) {
			System.out.print("1 입력 > ");
			a=scanner.nextInt();
			if(a==1) {
				break;
			}  //잘 입력하면 나가기
		}
	}

}
