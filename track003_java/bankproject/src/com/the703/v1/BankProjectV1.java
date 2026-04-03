package com.the703.v1;

import java.util.Scanner;

public class BankProjectV1 {

	public static void main(String[] args) {
		//변수
		int  menu=-1, balance=-1;
		int id=-1,pw=-1,id2=-1,pw2=-1;
		Scanner sc = new Scanner(System.in);
		// 입력
		for (;;) {
			System.out.print("🌟💰 welcome to bank 💰🌟\r\n"
							 + "\r\n"
							 + "1.➕계좌 추가\r\n" 
							 + "2.🔍계좌 조회\r\n" 
							 + "3.💵입금\r\n" 
							 + "4.💸 출금\r\n" 
							 + "5.🗑️삭제\r\n" 
							 + "9.종료\r\n"
							 + "\r\n"+"👉 번호를 선택하세요: ");
			menu = sc.nextInt();
			//처리
			//출력
			if (menu==1) {
				System.out.print("아이디: ");
				id=sc.nextInt();
				System.out.print("비밀번호: ");
				pw=sc.nextInt();
				System.out.print("잔액: ");
				balance = sc.nextInt();
			} 
			
			else if (menu==2) {
				System.out.print("아이디: ");
				id2 = sc.nextInt();
				System.out.print("비밀번호: ");
				pw2 = sc.nextInt();
				if( id == id2 && pw == pw2) {
					System.out.println("잔액: "+ balance + "원");
				} else {
					System.out.println("다시 확인해보세요");
				}
			} 
			
			else if (menu == 3) {
				System.out.println("입금기능입니다.\n");
			} else if (menu == 4) {
				System.out.println("출금기능입니다.\n");
			} else if (menu == 5) {
				System.out.println("삭제기능입니다.\n");
			} else if (menu == 9) {
				System.out.println("종료합니다.");
				break;
			}
		}
		

	}

}

/*
	Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
	1을 입력하면 추가기능입니다. 출력구문까지만
	2를 입력하면 조회기능입니다. 출력구문까지만
	3을 입력하면 입금기능입니다. 출력구문까지만
	4를 입력하면 출금기능입니다. 출력구문까지만
	5를 입력하면 삭제기능입니다. 출력구문까지만
	9를 입력하면 종료합니다.    출력구문까지만
	
	Q2. 무한반복으로 메뉴나오게, 9 나오면 종료
	■ 힌트
	for(;;) { 
	System.out.println("숫자1을 입력하세요.");
	int a = scanner.nextInt();
	if(a == 1) { break;}
	}
*/