package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		//변수
		int num1=-1, num2=-1;
		char ch = '\u0000'; 
		double result = 0;
		Scanner scanner = new Scanner(System.in);
		
		//입력
		System.out.print("정수 하나 입력 >> ");
		num1 = scanner.nextInt();
		System.out.print("정수 하나 입력 >> ");
		num2 = scanner.nextInt();
		System.out.print("연산자 하나 입력(+,-,*,/)>> ");
		ch = scanner.next().charAt(0);  // "a(0)b(1)c(2)"
		
		//처리 + 출력
		//		if(만약 + 라면){ 10+3=13}
		// else if(만약 - 라면){ 10-3=7}
		// else if(만약 * 라면){ 10*3=30}
		// else if(만약 / 라면){ 10/3=3.33}
		
		//ver-1
		if(ch == '+') {
			System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
		}
		else if(ch == '-') {
			System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
		}
		else if(ch == '*') {
			System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
		}
		else if(num2!=0 && ch=='/') {
			System.out.printf("%d / %d = %.2f\n", num1, num2, (double)num1/num2 );
		}
		
		//ver2,3 처리
		if (ch == '+') { 
			result = num1 + num2;
		}
		else if (ch == '-') { 
			result = num1 - num2;
		}
		else if (ch == '*') { 
			result = num1 * num2;
		}
		else { 
			result = (double)num1 / num2;
		}
		
		//ver-2 출력
		if (ch == '/') {
			System.out.printf("%d / %d = %.2f", num1, num2, result );
		}else {
			System.out.printf("%d %c %d = %d\n", num1, ch, num2, (int)result);  //%c char
			System.out.printf("%d %s %d = %d\n", num1, ch, num2, (int)result);  //%s String
		}
		
		//ver-3 출력
		//System.out.printf("%d / %d = %.2f", num1, num2, result);
		//System.out.printf("%d %c %d = %d\n", num1, ch, num2, (int)result);
		System.out.printf("%d %c %d = " + (ch == '/'? "%.2f":"%.0f"), num1, ch, num2, result );
		
		

	}

}

/*
연습문제7)  ※ 숙제
패키지명 : com.company.java004_ex
클래스명 :  IfEx007
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13
*/