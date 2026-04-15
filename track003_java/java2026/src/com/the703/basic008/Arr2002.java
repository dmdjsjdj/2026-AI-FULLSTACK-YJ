package com.the703.basic008;

public class Arr2002 {
	public static void main(String[] args) {
		//1. 값을 알고 있는 경우
		int [][] arr2  = {
				{1,2,3} ,  // 00 01 02
				{4,5,6} ,  // 10 11 12
		};
		
		//2. 값을 모르는 경우
		int [][] arr21 = new int[2][3];  
		int a=10;
		// new 메모리 빌려오기  int(자료형)  2층 3칸
//									     +10				 +10
//		arr21[0][0] = 10;	arr21[0][2] = 20;	arr21[0][3] = 30;
//		arr21[1][0] = 40;	arr21[1][1] = 50;	arr21[1][2] = 60; //for로 줄이기
		
//		ver-2 칸정리
		for(int i = 0;i<=2;i++) {
			arr21[0][i]=a;
			a+=10;
		}
		System.out.println();
		for(int i = 0;i<=2;i++) {
			arr21[1][i]=a;
			a+=10;
		}
		System.out.println();
		
		
		a=10;
		for(int i=0;i<arr21.length;i++) {  //배열명(아파트).length 층	
			for(int j=0;j<arr21[i].length;j++) {  //  배열명[(층)].length 층의 칸수
				
				arr21[i][j]=a;
				a+=10;
			}
		}
		
		for(int i=0;i<arr21.length;i++) {
			for(int j=0;j<arr21[i].length;j++) {
				System.out.print( arr21[i][j]+"\t");
			}System.out.println();
		}
		
	}
}
