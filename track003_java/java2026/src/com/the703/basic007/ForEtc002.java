package com.the703.basic007;

public class ForEtc002 {

	public static void main(String[] args) {
		// 알파벳을 삼각형 피라미드형으로 출력
		//A
		//AB
		//---
		//ABCDEFG-----
		System.out.println();
		System.out.println("for버전");
		
		for(char ch='A'; ch<='Z';ch++) {
			for(char ch2='A';ch2<=ch;ch2++) {
				System.out.print(ch2);
			}System.out.println();
		}
		

		System.out.println();
		System.out.println("while버전");
		
		char ch='A';
		while( ch<='Z') {
			char ch2='A';
			while(ch2<=ch) {
				System.out.print(ch2);
				ch2++;
			} System.out.println();
			ch++;
		}
		
		System.out.println();
		System.out.println("do while버전");
		
		ch='A';
		do {
			char ch2='A';
			do {
				System.out.print(ch2);
				ch2++;
			} while(ch2<=ch);
			System.out.println();
			ch++;
		}while( ch<='Z');

	}

}
