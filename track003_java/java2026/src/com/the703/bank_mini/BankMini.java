package com.the703.bank_mini;

import java.util.Scanner;

public class BankMini {

	public static void main(String[] args) {
		//wellcom! (주)syjbank
		//=====bank=====
		//아이디 id, 비번 pw, 나이 age, 잔액 ml 입금금액 im 출금금액 om 종료 
		//* 1.추가 /아이디 id, 비번 pw, 나이 age, 잔액 ml
		//2.조회 /아이디, 비번입력> 불일치-다시확인 >일치-계좌조회(아이디, 비번, 나이, 잔액
		//3.입금 /아이디, 비번 입금금액 입력>>입금완료(잔액
		//4.출금 /아이디, 비번 출금금액 입력>>출금완료(잔액
		//5.삭제 /아이디, 비번 삭제확인(y/n)
		//9.종료 >>종료기능입니다.
		//입력>>>
		
		int  num=0, age=0, ml=0, im=0, om=0;
		char id, pw;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("wellcom! (주)syjbank");
		System.out.println("=====bank=====");
		
		System.out.println("1.추가\n"+"2.조회\n"+"3.입금\n"+"4.출금\n"+"5.삭제\n"+"9.종료\n"+"입력>>> ");
		num = sc.nextInt();
		
		if (num==1) {
			System.out.println("아이디: ");
			id = sc.next().charAt(0);
			System.out.println("비밀번호: ");
			pw = sc.next().charAt(0);
			System.out.println("나이: ");
			age = sc.nextInt();
			System.out.println("비밀번호: ");
			ml = sc.nextInt();
		} 
		
		if (num==2) {
			System.out.println("bye");
		}

	}

}
