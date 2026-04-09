package com.the703.basic007;

public class ForEtc005 {

	public static void main(String[] args) {
		// 십의단위 누적합의 합 출력
		// 1~10합=55 / 1~10합+11~20합=210 ----- 1~100의 합=5050
		System.out.println();
		System.out.println("for버전");
		
		int hap=0;
		for(int i=0;i<=9;i++) {
			for(int j=1;j<=(i*10)+10;j++) {
				System.out.print((j==1?" ":"+")+j);
				hap=hap+j;
			}System.out.print("="+hap);
			hap=0;
			System.out.println();
		}


		System.out.println();
		System.out.println("while버전");
		
		hap=0;
		int i=0;
		while(i<=9) {
			int j=1;
			while(j<=(i*10)+10) {
				System.out.print((j==1?" ":"+")+j);
				hap=hap+j;
				j++;
			}System.out.print("="+hap);
			hap=0;
			System.out.println();
			i++;
		}
		
		System.out.println();
		System.out.println("do while버전");
		
		hap=0;
		i=0;
		do {
			int j=1;
			do {
				System.out.print((j==1?" ":"+")+j);
				hap=hap+j;
				j++;
			}while(j<=(i*10)+10);
			System.out.print("="+hap);
			hap=0;
			System.out.println();
			i++;
		}while(i<=9);

	}

}
