package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx002 {

	public static void main(String[] args) {
//		사용자에게 단을 입력받아 해당하는 
//		단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오.
		int a = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("원하는 단을 입력하시오 >> ");
		a=scanner.nextInt();
		
		System.out.println(a+"단");
		
		//출력문으로 먼저 다 작성후 중복되는 부분 확인 
		//System.out.println(2x1=2);
		//System.out.println(2x2=4);
		// ...
		//System.out.println(ax1=a*1);
		//System.out.println(ax2=a*2);
		for(int i=1;i<=9;i++) {
			System.out.println(a +"x" + i +"=" + (a*i));
		}

	}

}
