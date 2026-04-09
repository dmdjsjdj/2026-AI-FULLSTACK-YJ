package com.the703.basic007;

public class ForEtc004 {
	public static void main(String[] args) {
		// 십의 단위로 누적합 출력
		// 1~10합=55 / 11~20합=155 -----
//		int num=0;
//		for(int i=1;i<=10;i++) {
//			System.out.print((i==1?" ":"+")+i);
//			num=num+i;
//		}System.out.print("="+num);
//		
//		System.out.println();
//
//		num=0;
//		for(int i=11;i<=20;i++) {
//			System.out.print((i==11?" ":"+")+i);
//			num=num+i;
//		}System.out.print("="+num);
//		
//		-----------------------------
		System.out.println();
		System.out.println("for버전");
		
		int hap=0;
		for(int i=0;i<=9;i++) {
			for(int j=(i*10)+1;j<=(i*10)+10;j++) {
				System.out.print((j==(i*10)+1?" ":"+")+j);
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
			int j=(i*10)+1;
			while(j<=(i*10)+10) {
				System.out.print((j==(i*10)+1?" ":"+")+j);
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
			int j=(i*10)+1;
			do {
				System.out.print((j==(i*10)+1?" ":"+")+j);
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
