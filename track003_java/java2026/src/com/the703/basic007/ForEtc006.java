package com.the703.basic007;

public class ForEtc006 {

	public static void main(String[] args) {
		// 이중 for 이중 while 이중 do wile 세가지 버전으로 구구단 2~4단 출력

		System.out.println("for 버전");
		for(int i=2;i<=4;i++) {
			System.out.println(i+"단");
			for(int j=1;j<=9;j++) {
				System.out.println(i+"x"+j+"="+ (i*j));
			}System.out.println();
		}
		
		System.out.println("while 버전");
		int i=2;
		while(i<=4) {
			System.out.println(i+"단");
			int j=1;
			while(j<=9) {
				System.out.println(i+"x"+j+"="+ (i*j));
				j++;
			}
			System.out.println();
			i++;
		}
		
		System.out.println("do while 버전");
		i=2;
		do {
			System.out.println(i+"단");
			int j=1;
			do {
				System.out.println(i+"x"+j+"="+ (i*j));
				j++;
			}while(j<=9);
			System.out.println();
			i++;
		}while(i<=4);
	}

}
