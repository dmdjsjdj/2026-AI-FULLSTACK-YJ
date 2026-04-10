package com.the703.days;

import java.util.Scanner;

public class Day012 {

	public static void main(String[] args) {

		//1.
		int a =-1;
		Scanner scanner =new Scanner(System.in);
		
		System.out.print("점수를 입력하시오: ");
		a=scanner.nextInt();
		
		if(a>=90) {
			System.out.println("A 학점");
		}
		else if(a>=80) {
			System.out.println("B 학점");
		}
		else if(a>=70) {
			System.out.println("C 학점");
		}
		else {
			System.out.println("F 학점");
		}
		System.out.println("\n");
		
		
		//2.
		switch(a/10) {
		case 9: System.out.println("A 학점"); break;
		case 8: System.out.println("B 학점"); break;
		case 7: System.out.println("C 학점"); break;
		default : System.out.println("F 학점"); break;
		}
		System.out.println("\n");
		
		//3.
		for(int i=1;i<=3;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		int i=1;
		while(i<=3) {
			System.out.print(i+" ");
			i++;
		}
		System.out.println();
		
		i=1;
		do {
			System.out.print(i+" ");
			i++;
		}while(i<=3);
		System.out.println("\n");
		
		for(int i2=1;i2<=4;i2++) {
			for(int j=1;j<=4;j++) {
				System.out.print("★");
			}System.out.println();
		}
	}

}
