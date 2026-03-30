package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx003 {

	public static void main(String[] args) {
		// GIGO
		// 변수
		int age = 0;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.println("태어난 년도를 입력하세요. >");
		age = sc.nextInt();
		//처리
		age = 2026 - age +1;
		//출력
		System.out.println("당신의 나이는 " + age + "입니다.");
		System.out.print("당신의 나이는 " + age + "입니다.\n");
		System.out.printf("당신의 나이는 %d입니다.\n", age);
		//만나이 계산
		age = age - 1;
		System.out.println("당신의 만 나이는 " + age + "입니다.");
		System.out.print("당신의 만 나이는 " + age + "입니다.\n");
		System.out.printf("당신의 만 나이는 %d입니다.\n", age);

	}

}

/*
연습문제3)
패키지명 : com.the703.basic003_ex
클래스명 : DataTypeEx003
출력내용 :  Scanner이용해서 태어난 년도를 입력받아 나이 계산하기
태어난 년도를 입력하세요. >
2000
당신의 나이는 25살 입니다.
*/