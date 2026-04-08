package com.the703.basic006_ex;

public class RepeatEx001 {

	public static void main(String[] args) {
		// {반복}  {변수}  for(시작;종료;변화)
		
//		1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
		System.out.println("Q1-1. for  1 2 3 4 5");
		for(int i=1;i<=5;i++) {
			System.out.print(i+" ");
		}
		
		System.out.println("\nQ1-2. while  1 2 3 4 5");
		int i=1;
		while(i<=5) {
			System.out.print(i+" ");
			i++;
		}
		
		System.out.println("\nQ1-3. do while  1 2 3 4 5");
		int i1=1;
		do {
			System.out.print(i1+" ");
			i1++;
		}while(i1<=5);
		
//		2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
		System.out.println("\nQ2-1. for  5 4 3 2 1");
		for(int i11=5;i11>=1;i11--) {
			System.out.print(i11+" ");
		}
		
		System.out.println("\nQ2-2. while  5 4 3 2 1");
		int i11=5;
		while(i11>=1) {
			System.out.print(i11+" ");
			i11--;
		}
		
		System.out.println("\nQ2-3. do while  5 4 3 2 1");
		int i2=5;
		do {
			System.out.print(i2+" ");
			i2--;
		}while(i2>=1);
//		3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3
		System.out.println("\n31-1. for  JAVA1   JAVA2  JAVA3");
		for(int a=1;a<=3;a++) {
			System.out.print("JAVA"+a+"\t");
		}
		
		System.out.println("\nQ3-2. while  JAVA1   JAVA2  JAVA3");
		int a=1;
		while(a<=3) {
			System.out.print("JAVA"+a+"\t");
			a++;
		}
		
		System.out.println("\nQ3-3. do while  JAVA1   JAVA2  JAVA3");
		int a1=1;
		do {
			System.out.print("JAVA"+a1+"\t");
			a1++;
		}while(a1<=3);

	}

}
