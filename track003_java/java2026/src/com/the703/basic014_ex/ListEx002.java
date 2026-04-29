package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx002 {
	public static void main(String[] args) {
		List<String> numbers = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int a=0;
		String result=" ";
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		
		for(;;) {
			System.out.print("1,2,3중에 입력 (0은 종료) > ");
			a=sc.nextInt();
			if(a==0) {System.out.println("종료"); break;}
			result = a==1?(String) numbers.get(0):a==2?(String) numbers.get(1):a==3?(String) numbers.get(2):"잘못된 숫자입력";
			System.out.println(result);
		}
	}
}
/*
연습문제2)  Collection  Framework
패키지명 : com.company.java014_ex
클래스명 : ListEx002
1.  numbers ArrayList 만들기
2.  one, two, three 데이터 추가
3.  사용자에게 1,2,3 입력받기
4.  1을 입력받으면 one 출력
    2를입력받으면 two 출력
    3을입력받으면 three 출력
*/