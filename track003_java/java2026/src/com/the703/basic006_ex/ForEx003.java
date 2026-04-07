package com.the703.basic006_ex;

public class ForEx003 {

	public static void main(String[] args) {
		//출력내용 :   for 이용
		//1~10까지의 합을 구하시오.
		//0) num = 0
		//1) num = 0 + 1
		//2) num = 1 + 2
		//3) num = 3 + 3
		//...
		int num = 0;
		for(int i=1;i<=10;i++) {
			
			num = num + i;
			System.out.print( (i==1 ?" ":" + ") + num);
		}
		System.out.println(" = "+num);
	}

}
