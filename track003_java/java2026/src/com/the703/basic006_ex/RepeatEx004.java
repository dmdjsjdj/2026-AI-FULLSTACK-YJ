package com.the703.basic006_ex;

public class RepeatEx004 {

	public static void main(String[] args) {
		//A~Z까지 출력  *단 5번째마다 줄바꿈
		int num = 0;
		for(char ch='A';ch<='Z';ch++) {
			
			System.out.print(ch);
			num++;
			if(num%5==0) {
				System.out.println("");
			}
		}

	}

}
