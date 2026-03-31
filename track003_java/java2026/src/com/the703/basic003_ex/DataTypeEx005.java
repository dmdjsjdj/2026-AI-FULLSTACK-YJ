package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx005 {

	public static void main(String[] args) {
		// GIGO
		//1. 자바의 자료형 분류 (기본형 / 참조형 )
		//2. 기본형 : 값
		//2-1 논리형 : boolean - true/false
		//2-2 정수형 : (byte-short-int★-long(L) / 1,2,3 / 1-2-4-8)
		//2-3 실수형 : (float(f)-double★ /3.14 / 4-8)   %.2f
		// 변수
		int kor = -1, eng = -1, math = -1, tot = -1;  //고정
		double awa = 0;
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.println("국어점수를 입력하시오. ");
		kor = sc.nextInt();
		System.out.println("영어점수를 입력하시오. ");
		eng = sc.nextInt();
		System.out.println("수학점수를 입력하시오. ");
		math = sc.nextInt();
		
		//처리 A=B
		tot = kor + eng + math; // 정수/실수  10/3
		awa = tot/3.0; // /3.0도 가능
		
		//출력
		System.out.println("총점 : " + tot + "\n 평균 : " + awa );
		System.out.print  ("총점 : " + tot + "\n 평균 : " + awa + "\n" );
		System.out.printf ("총점 : %d \n 평균 : %.2f", tot, awa );
		

	}

}

/*
 연습문제5)
패키지명 : com.the703.basic003_ex
클래스명 : DataTypeEx005
출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
   국어점수를 입력하시오.  _입력받기    100 
   영어점수를 입력하시오.  _입력받기    100 
   수학점수를 입력하시오.  _입력받기    99

   총점 :  299
   평균 :  99.67
*/
