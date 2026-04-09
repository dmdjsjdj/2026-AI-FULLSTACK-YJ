package com.the703.basic007;

public class ForEtc003 {

	public static void main(String[] args) {
		// 알파벳을 역삼각형 역피라미드형으로 출력
		System.out.println();
		System.out.println("for버전");

		for(char ch='Z'; ch>='A';ch--) {
			for(char ch2='A';ch2<=ch;ch2++) {
				System.out.print(ch2);
			}System.out.println();
		}
		

		System.out.println();
		System.out.println("while버전");
		
		char ch='Z';
		while( ch>='A') {
			char ch2='A';
			while(ch2<=ch) {
				System.out.print(ch2);
				ch2++;
			}System.out.println();
			ch--;
		}
		
		System.out.println();
		System.out.println("do while버전");
		
		ch='Z';
		do {
			char ch2='A';
			do {
				System.out.print(ch2);
				ch2++;
			} while(ch2<=ch);
			 System.out.println();
			ch--;
		} while( ch>='A');

	}

}
