package com.the703.basic006_ex;

public class ForEx005 {

	public static void main(String[] args) {
//		출력내용 :   for 이용
//		소문자 a~z까지 모음의 갯수를 출력하시오. 
		int num = 0;
		for(char ch='a'; ch<='z'; ch++) {
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				num = num+1;
			}
		} System.out.println(num + "개");
		
	}

}
//a 97 e 101 i 105 o 111 u 117