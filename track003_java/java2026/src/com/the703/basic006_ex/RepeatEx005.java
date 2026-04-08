package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005 {

	public static void main(String[] args) {
		// 입력받은 문자 회문 판별
		//토마토 / 기러기
		//apple(x)
		
		String sum = " ";
		int a = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열을 입력하시오 : ");
		sum = scanner.next();

		int count = sum.length();

		System.out.println(count+","+a);
		
		for(int i=0; i <= count/2;i++,count--) {
			if(sum.charAt(i) == sum.charAt(count-1)) {
				a++;
				System.out.println(i+","+a);
			}
			
		}
		System.out.println(count+","+a);
		if(a==(count%2==0?count:count<2?count+1:count-1)) {
			System.out.println("회문입니다");
		} else { System.out.println("회문이 아닙니다"); }
		
//			if(sum.charAt(i) == sum.charAt(count-1)) {
//							System.out.println("회문입니다");
//						} else { System.out.println("회문이 아닙니다"); }
	}

}
