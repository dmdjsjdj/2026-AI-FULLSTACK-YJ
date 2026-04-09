package com.the703.basic007;

public class ForEtc001 {

	public static void main(String[] args) {
		//두개의 주사위를 던졌을때 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램
		//ex) 1+5=6  /  2+4=6 / 3+3=6 / 4+2=6 / 5+1=6
		//for while do while 세가지버전으로
		
//		ver-1 눈에 보이는대로
//		int i=1;
//		int j=5;
		
		
//		ver-2 각칸정리 for정리  {영역}  {변수}  for(시작;종료;변화)
		

//		ver-3 각층정리 for정리
		System.out.println();
		System.out.println("for버전");
		for(int i=1;i<=6;i++) {
			for(int j=6;j>=1;j--) {
				if((i+j)==6) {
					System.out.println(i+"+"+j+"="+(i+j));
				}
			}
		}
		
		System.out.println();
		System.out.println("while버전");
		
		int i=1;
		while(i<=6) {
			int j=6;
			while(j>=1) {
				if((i+j)==6) {
					System.out.println(i+"+"+j+"="+(i+j));
				}j--;
			} i++;
		}
		
		System.out.println();
		System.out.println("do while버전");
		
		i=1;
		do {
			int j=6;
			do {
				if((i+j)==6) {
					System.out.println(i+"+"+j+"="+(i+j));
				}j--;
			} while(j>=1);
			i++;
		}while(i<=6);

	}

}
