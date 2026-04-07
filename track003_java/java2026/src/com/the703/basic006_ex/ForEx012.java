package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx012 {

	public static void main(String[] args) {
		//두 수 입력받음
		//2,5로 입력받으면 2+3+4+5=14 출력, 5,2로 입력받으면 5+4+3+2=14 출력
		
		int a=-1,b=-1, num=0;
		int c=-1;
		String d = "";
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 입력 : ");
		a=scanner.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		b=scanner.nextInt();

		
//		for(; ;) {
//			if(a<b) {
//				for(int i= a; i<=b; i++) {
//					num = num+i;
//					System.out.print((i==a?"":"+")+i);
//				} break;
//			}
//			else if(a>b) {
//				for(int i1= a; i1>=b; i1--) {
//					num = num+i1;
//					System.out.print((i1==a?"":"+")+i1);
//				} break;
//			}
//		}
		
		c = a<b ? 1:-1;	
						//2,5
		for(; ;) {      //5-5 * 1  
			for(int i = a; (i-b)*c <= 0 ; i+=c) {
				num = num+i;
				System.out.print((i==a?"":"+")+i);
			} break;
		}
		
		System.out.println("="+num);
	}

}
