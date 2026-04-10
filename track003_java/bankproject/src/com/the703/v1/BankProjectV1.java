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
			if (menu == 9) {
				System.out.println("종료합니다.");
				break;
			}
			else if (menu==1) {
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
			}
		}
		

	}

}

/*
- 조건문 : if , switch
- 반복문 : for(시작;종료;변화) , while(조건) , do wile(한번은 무조건 실행, 맨끝에 조건
무한반복(종료9){
	0.메뉴판 입력
	🌟💰 welcome to bank 💰🌟
	1.➕계좌 추가  2.🔍계좌 조회 3.💵입금  4.💸 출금 
	5.🗑️삭제 6.🔧비번 수정 9.종료
	👉 번호를 선택하세요:
	
	1.  1.➕계좌 추가
	2. 2~5번
		2-1. 사용자가 맞는지 여부
		2-2. 조회면 조회가능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금, 계좌삭제라면 y,n 입력받아 삭제
	3. 9. 종료
	
	-----
while(menu!=9){
	0.메뉴판 입력
	🌟💰 welcome to bank 💰🌟
	1.➕계좌 추가  2.🔍계좌 조회 3.💵입금  4.💸 출금 
	5.🗑️삭제 6.🔧비번 수정 9.종료
	👉 번호를 선택하세요:
	if(menu==9){ 종료문구 }
	else if (menu==1) { 1.계좌 추가 }
	else{  2~5번
		2-1. 사용자가 맞는지 여부
		임시 아이디,비번받기>>
		저장되어있는 아이디비번이랑 같으면 아래내용 처리
		2-2. 조회면 조회가능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금, 계좌삭제라면 y,n 입력받아 삭제
		switch(menu) {
					case 2: 잔액조회 break;
					case 3: 입금금액받기 입금처리 	break;
					case 4: 출금금액받기 출금처리 break;
					case 5: 계좌 삭제( y / n ) 	break;
					case 6: System.out.print("변경할 비밀번호: ");
					break;
			

	
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