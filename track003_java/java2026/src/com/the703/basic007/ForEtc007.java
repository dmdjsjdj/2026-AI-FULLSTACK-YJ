package com.the703.basic007;

public class ForEtc007 {

	public static void main(String[] args) {
		//다중 for을 이용해서 구구단을 가로 3단으로 출력
		//  2단  3단  4단
		//  5단  6단  7단
		//  8단  9단
		
		for(int j=0;j<=6;j+=3) {
			for(int i=1;i<=3;i++) {
				for(int z=2;z<=4;z++) {
				  System.out.print((z+j)+"x"+i+"="+ (i*(z+j))+(i*(z+j)>=10?" ":"  "));
				}System.out.println();
			}System.out.println();
		}
		
//		System.out.println(j+"x"+1+"="+ (1*j)+"  ");
//		System.out.println(j+"x"+2+"="+ (2*j)+"  ");
//		System.out.println(j+"x"+3+"="+ (3*j)+"  ");
//		
//		System.out.println((j+3)+"x"+1+"="+ (1*(j+3))+"  ");
//		System.out.println((j+3)+"x"+2+"="+ (2*(j+3))+"  ");
//		System.out.println((j+3)+"x"+3+"="+ (3*(j+3))+"  ");
	}

}
