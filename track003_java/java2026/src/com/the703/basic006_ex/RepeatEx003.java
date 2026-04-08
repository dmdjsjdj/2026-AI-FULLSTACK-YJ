package com.the703.basic006_ex;

public class RepeatEx003 {

	public static void main(String[] args) {
		//1~30범위에서 3의 배수이면서 2의 배수인 숫자와갯수를 구하는 프로그램
		//3,2의 배수면 출력  >> 찾기 다 끝나면 몇개인지 출력
		System.out.println("Q1-1. for  3의 배수이면서 2의 배수인 숫자 와 갯수");
		
		int num =0;
		for(int i=1; i<=30; i++) {
			if(i%3==0 && i%2==0) {
				num++;
				System.out.println(num+". 3의 배수이면서 2의 배수인 숫자 : "+i);
			}
		}  System.out.println("갯수 : "+num);
		
		System.out.println("\nQ1-2. while  3의 배수이면서 2의 배수인 숫자 와 갯수");
		int i2=1;
		int num1 =0;  //i=0; num=0;으로 초기화해서 사용도 가능
		while( i2<=30) {
			if(i2%3==0 && i2%2==0) {
				num1++;
				System.out.println(num1+". 3의 배수이면서 2의 배수인 숫자 : "+i2);
			} i2++;
		}  System.out.println("갯수 : "+num1);
		
		System.out.println("\nQ1-3. do while 3의 배수이면서 2의 배수인 숫자 와 갯수");
		int i3=1;
		int num2 =0; //i=0; num=0;으로 초기화해서 사용도 가능
		do {
			if(i3%3==0 && i3%2==0) {
				num2++;
				System.out.println(num2+". 3의 배수이면서 2의 배수인 숫자 : "+i3);
			} i3++;
		}  while( i3<=30);
		System.out.println("갯수 : "+num2);

	}

}
