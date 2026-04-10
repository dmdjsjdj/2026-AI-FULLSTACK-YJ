package com.the703.v1;

import java.util.Scanner;

public class Bank_yj3 {

	public static void main(String[] args) {
		//wellcom! (주)syjbank
		//=====bank=====
		//아이디 id, 비번 pw, 잔액 balance 입금금액 im 출금금액 om 종료 
		//* 1.추가 /아이디 id, 비번 pw, 잔액 balance
		//2.조회 /아이디, 비번입력> 불일치-다시확인 >일치-계좌조회: 잔액
		//3.입금 /아이디, 비번 입금금액 입력>>입금완료(잔액
		//4.출금 /아이디, 비번 출금금액 입력>>출금완료(잔액
		//5.삭제 /아이디, 비번 삭제확인(y/n)
		//9.종료 >>종료기능입니다.
		//입력>>>
		
		////////////WHILE + SWITCH 들어가 있게/////////////////
		
		int  menu=-1, balance=-1, inputm=-1, outputm=-1; 
		char deletid= '\u0000';
		String id = " ", pw = " ", id2 = " ", pw2 = " ";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n 🌟💰 welcome to bank 💰🌟\r\n");
		
		while( menu!=9 ) {
			System.out.print("\n -- bank menu --\r\n"
					 + "\r\n"
					 + "1.➕계좌 추가\r\n" 
					 + "2.🔍계좌 조회\r\n" 
					 + "3.💵입금\r\n" 
					 + "4.💸 출금\r\n" 
					 + "5.🗑️삭제\r\n" 
					 + "6.🔧비번 수정\r\n" 
					 + "9.종료\r\n"
					 + "\r\n"+"👉 번호를 선택하세요: ");
			menu = sc.nextInt();
			

			if(menu==9) {  //9.종료 >> 종료합니다.
					System.out.println("종료합니다.");
				} 
			else if (menu==1) { //1.추가 - 아이디 id, 비번 pw, 잔액 balance
				System.out.print("아이디: ");
				id = sc.next();
				System.out.print("비밀번호: ");
				pw = sc.next();
				while(balance>=0) {
					System.out.print("잔액: ");
					balance = sc.nextInt();
				}
			} 
			
			else if (menu>=2 && menu<=6) {  
				System.out.print("아이디: ");
				id2 = sc.next();
				System.out.print("비밀번호: ");
				pw2 = sc.next();
				
				//  if( id.equals(id2) || pw.equals(pw2)) { continue; }
				if( id.equals(id2) && pw.equals(pw2)) {
					
					
					switch(menu) {
					case 2: System.out.println("잔액: "+ balance + "원"); break;
						    
					
					case 3: System.out.print("입금금액: "); 
							inputm = sc.nextInt();
							
							if(inputm>=0) {
								balance = balance + inputm;
								System.out.println("잔액: "+ balance + "원");
							}
							else { 
									System.out.println("음수는 입력할 수 없습니다"); 
							} break;
							
					case 4: System.out.print("출금금액: "); 
							outputm = sc.nextInt();
							
							if(outputm>=0 && balance-outputm>=0) {
								balance = balance - outputm;
								System.out.println("잔액: "+ balance + "원");
							}
							else { 
									System.out.println("잔액이 부족합니다.  현재 잔액"+balance); 
							} break;
							
					case 5: System.out.print("계좌를 삭제하시겠습니까?: ( y / n ) "); 
							deletid = sc.next().charAt(0);
							
							if(deletid == 'y') {
								System.out.println("계좌가 삭제되었습니다.");
								id = " ";
								pw = " ";
							} else if(deletid == 'n') {
								System.out.println("계좌 삭제를 취소하셨습니다.");
							   } break;
					
					case 6: System.out.print("변경할 비밀번호: ");
							pw2 = sc.next();
							
							pw = pw2;
							
					break;
					
					default: System.out.println("잘못된 숫자입력입니다."); break;
					};	 
				
				}else {
					System.out.println("\n 잘못된 입력입니다.");
				}
			
				
			}
			else {
					System.out.println("\n 잘못된 입력입니다.");
				}
		}

	}

}