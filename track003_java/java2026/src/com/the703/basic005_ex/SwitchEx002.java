package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx002 {

	public static void main(String[] args) {
		// 
		int a = -1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자한개 입력 >> ");
		a = scanner.nextInt();

		a = a/3;  //몫으로 구분 / 3~5 - 몫1  
				  //		 / 6~8 - 몫2
				  //		 / 9~11 - 몫3
				  //		 / 12,1,2 - 몫4/0
		
		switch(a) {
		case 1  : System.out.println("봄"); break; 
		case 2  : System.out.println("여름");  break;
		case 3  : System.out.println("가을");  break;
		case 4  :
		case 0  : System.out.println("겨울"); break;
		default : System.out.println("1 ~ 12 중에 숫자를 입력하세요"); break;
		}
//		switch(a) {
//		case 3 : case 4 : case 5 : System.out.println("봄"); break;
//		case 6: case 7: case 8: System.out.println("여름");  break;
//		case 9: case 10: case 11 : System.out.println("가을");  break;
//		case 12: case 1: case 2: System.out.println("겨울"); break;
//		default : System.out.println("잘못된 입력입니다"); break;
//		}
	}

}
/*
연습문제2)  
패키지명 : com.company.java004_ex
클래스명 :  SwitchEx002
출력내용 :   switch 이용
     숫자한개 입력받아
     3,4,5이면 봄
     6,7,8이면 여름
     9,10,11이면 가을
     12,1,2이면 겨울
*/
