package com.the703.basic008;

import java.util.Arrays;

public class Arr2001 {
	public static void main(String[] args) {
		int [][] arr2  = {
				{1,2,3} ,  // 00 01 02
				{4,5,6} ,  // 10 11 12
		};
		
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr2));
		
		//ver-1 눈에 보이는대로
		System.out.print(arr2[0][0]+"\t");
		System.out.print(arr2[0][1]+"\t");
		System.out.print(arr2[0][2]+"\t");	System.out.println();
		
		System.out.print(arr2[1][0]+"\t");
		System.out.print(arr2[1][1]+"\t");
		System.out.print(arr2[1][2]+"\t");	System.out.println();
		
		//ver-2 칸정리
		for(int i = 0;i<=2;i++) {
			System.out.print(arr2[0][i]+"\t");
		}
		System.out.println();
		for(int i = 0;i<=2;i++) {
			System.out.print(arr2[1][i]+"\t");
		}
		System.out.println();
		//ver-3 층정리
		for(int i = 0;i<=1;i++) {
			for(int j = 0;j<=2;j++) {
				System.out.print(arr2[i][j]+"\t");
			}System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//ver-4 length 이용
		//배열명(아파트).length 층	/  배열명[(층)].length 층의 칸수
		for(int i = 0;i<arr2.length;i++) { //아파트의 층수
			for(int j = 0;j<arr2[i].length;j++) {  // 층의 칸수
				System.out.print(arr2[i][j]+"\t");
			}System.out.println();
		}
		
	}

}
