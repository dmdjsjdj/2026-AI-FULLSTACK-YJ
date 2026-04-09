package com.the703.basic007;

public class For2Ex002 {

	public static void main(String[] args) {
//		ver-1 눈에 보이는대로
		System.out.print('@'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('@'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('@'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('@'); System.out.println();
		
//		ver-2 각칸정리 for정리  {영역}  {변수}  for(시작;종료;변화)
//		System.out.println();
//		for(int i=1; i<=4; i++){
//			char a = '#';
//			if(i==1) {
//				a = '@';
//			}
//			System.out.print(a);
//		}
		
		//System.out.println(i=1?'@':'#');
		
//		ver-3 각층정리 for정리

		System.out.println();
		for(int i=1; i<=4; i++){
			for(int j=1 ; j<=4 ; j++){
				System.out.print(i==j?'@':'#');
			}System.out.println();
		}
		
//		System.out.println();
//		for(int i=1; i<=4; i++){
//			char a = '\u0000';
//			for(int j=1 ; j<=4 ; j++){
//				if(i==j) { 
//					a = '@';
//				}
//				else if(i!=j) { a = '#';}
//				
//			}System.out.print(a);
//		}
	}

}
/* 
패키지명 : ccom.the703.basic007
클래스명 :  For2Ex002

@###
#@##
##@#
###@
*/