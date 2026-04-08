package com.the703.basic006_ex;

public class RepeatEx002 {

	public static void main(String[] args) {
		//for , while , do while 3가지 버젼으로 
		//1~10까지 3의 배수의 합 : 18
		
//		힌트)
//		ver-1)  말로 풀어쓰기
//		1이  3의 배수라면  합을더해주변수에누적
//		2가  3의 배수라면  합을더해주변수에누적
//		3이  3의 배수라면  합을더해주변수에누적
//		
//		ver-2) 구조로 바꾸기- 제어 반복
//		if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
//		if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
//		if( 3이  3의 배수라면 ){ 합을더해주변수에누적 }	
//		ver-3) 코드
//		int num=0;
//		if(i%3==0) {num+=1;}
		
		System.out.println("Q1-1. for  1~10까지 3의 배수의 합");
		int num = 0; int cnt=0;
		for(int i=1;i<=10;i++) {
			if(i%3==0) {
				num = num + i;
				cnt++;
			}
			
		} System.out.println("1~10까지 3의 배수의 합 : " + num+"  갯수: "+cnt  );
		
		System.out.println("\nQ1-2. while  1~10까지 3의 배수의 합");
		int num1 = 0;  cnt=0;
		int i=1;
		while(i<=10) {
			if(i%3==0) {
				num1 = num1 + i;
				cnt++;
			}i++; 
		}
		System.out.println("1~10까지 3의 배수의 합 : " + num1+"  갯수: "+cnt );
		
		System.out.println("\nQ1-3. do while 1~10까지 3의 배수의 합");
		int num2 = 0;  cnt=0;
		int i2=1;
		do {
			if(i2%3==0) {
				num2 = num2 + i2;
				cnt++;
			}i2++; 
		}while(i2<=10);
		System.out.println("1~10까지 3의 배수의 합 : " + num2+"  갯수: "+cnt  );


	}

}
