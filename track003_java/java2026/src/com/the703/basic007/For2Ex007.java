package com.the703.basic007;

public class For2Ex007 {

	public static void main(String[] args) {
//		ver-1 눈에 보이는대로
		System.out.print('4'); System.out.print('4'); System.out.print('4'); System.out.print('4'); System.out.println();
		System.out.print('3'); System.out.print('3'); System.out.print('3'); System.out.println();
		System.out.print('2'); System.out.print('2'); System.out.println();
		System.out.print('1'); System.out.println();
		
		
//		ver-2 각칸정리 for정리  {영역}  {변수}  for(시작;종료;변화)
		System.out.println();
		for(int i=1;i<=4;i++) {
			System.out.print(4);
		}   System.out.println();
		for(int i=1;i<=3;i++) {
			System.out.print(3);
		}   System.out.println();
		for(int i=1;i<=2;i++) {
			System.out.print(2);
		}   System.out.println();
		for(int i=1;i<=1;i++) {
			System.out.print(1);
		}   System.out.println();
		
		
		System.out.println();
//		ver-3 각층정리 for정리
		for(int j=4;j>=1;j--){
			for(int i=1;i<=j;i++) 
			{
				System.out.print(j);
			}   System.out.println();
		}


	}

}
/*
패키지명 : ccom.the703.basic007
클래스명 :  For2Ex007   (이중for 이용)

4444
333
22
1
*/