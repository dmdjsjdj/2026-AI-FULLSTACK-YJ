package com.the703.basic007;

public class For2Ex001 {

	public static void main(String[] args) {
//		####
//		####
//		####
//		####
//		ver-1 눈에 보이는대로
		
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		
//		ver-2 각칸정리 for정리  {영역}  {변수}  for(시작;종료;변화)
		System.out.println();
		for(int i =1;i<=4;i++){
			System.out.print('#');
		}System.out.println();
	// x4
		
//		ver-3 각층정리 for정리 
		System.out.println();
		for(int j =1;j<=4;j++){
			for(int i =1;i<=4;i++){
				System.out.print('#');
			}System.out.println();
		}

	}

}

/*
패키지명 : ccom.the703.basic007
클래스명 :  For2Ex001  (이중for 사용)

####
####
####
####
*/