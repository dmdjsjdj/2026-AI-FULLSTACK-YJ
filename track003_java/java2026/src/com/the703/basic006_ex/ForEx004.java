package com.the703.basic006_ex;

public class ForEx004 {

	public static void main(String[] args) {
		//출력내용 :   for 이용
		//1~10까지 3의 배수 갯수를 출력 
		for(int i=1;i<=10;i++) {
			if(i%3==0) {
				System.out.print( (i==3 ?"3의 배수 : ":", ") + i );
			}
		}

	}

}
