package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx012 {

	public static void main(String[] args) {
		//두 수 입력받음
		//2,5로 입력받든 5,2로 입력받든 2->5 순서로 2+3+4+5=14 출력
		
		int a=-1,b=-1, num=0;
		//int c=-1,d=-1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 입력 : ");
		a=scanner.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		b=scanner.nextInt();
		
//		c = a<b ? a:b;
//		d = a<b ? b:a;
		
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
		
		for(; ;) {
			if(a<b) {
				for(int i= a; i<=b; i++) {
					num = num+i;
					System.out.print((i==a?"":"+")+i);
				} break;
			}
			else if(a>b) {
				for(int i1= a; i1>=b; i1--) {
					num = num+i1;
					System.out.print((i1==a?"":"+")+i1);
				} break;
			}
		}
		
		System.out.println("="+num);
	}

}
