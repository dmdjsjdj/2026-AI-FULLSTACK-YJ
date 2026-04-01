package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx003 {

	public static void main(String[] args) {
		//1. 문자는 저장시 숫자저장/ 출력시 문자
		System.out.println("1. "+ 'A' + "\t" + (int)'A');  // 'A' 문자
		System.out.println("2. "+ 'a' + "\t" + (int)'a');  // "ABC" 문자열
		System.out.println("3. " + "ABC".charAt(0));  // "ABC" 문자열
		System.out.println("3. " + "ABC".charAt(1));  // A (0) B (1)
		
		// - 대문자 입력받아서 소문자로 변경 프로그램
		//변수
		char ch='\u0000' , lower='\u0000';
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.println("대문자 입력>> ");  ch = scanner.next().charAt(0);
		//처리
		//a(97) = A(65) + 32
		//char  = char + int
		// 2byte= 2byte 4byte
		lower = (char) (ch + 32) ; //문자는 숫자 저장이라 더하기엔 int 필요x, 
								   //2byte인 문자랑 4byte인 int를 더하면 int로 저장되서 숫자상태라 char로 캐스팅해줘야함
		//출력
		System.out.println(ch + "를 소문자로 " + lower);
	}

}

/*
연습문제3)
패키지명 : com.the703.basic004_ex
클래스명 : CastingEx003
- 대문자입력받아서 소문자로 변경프로그램을 작성하시오.
*/