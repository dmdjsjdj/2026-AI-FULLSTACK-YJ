package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_2 {

	public static void main(String[] args) {
		//변수
				int num1=-1, num2=-1;
				char ch = '\u0000'; 
				String result = " ";
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
				
				//처리
				if (ch == '+') { 
					result += (num1 + num2);
				}
				else if (ch == '-') { 
					result += (num1 - num2);
				}
				else if (ch == '*') { 
					result += (num1 * num2);
				}
				else if (ch == '/') { 
					result += String.format("%.2f", num1/(double)num2);
				}
				//출력
				System.out.printf(" " + num1 + ch + num2 + "=" + result );
	}

}
