package com.the703.basic007;

public class ForEtc007_1 {

	public static void main(String[] args) {
		//다중 for을 이용해서 구구단을 가로 3단으로 출력
		//  2단  3단  4단
		//  5단  6단  7단
		//  8단  9단
		
		for(int j=2;j<=9;j+=3) {    //단 숫자 증가
			for(int i=1;i<=3;i++) { //곱하는 숫자
				for(int z=0;z<3;z++) {  // 2->3->4 증가
					int t = j+z;
					if(t<=9) {
						System.out.print(t+"x"+i+"="+ (i*t)+(i*t>=10?" ":"  "));
					}
				}System.out.println();
			}System.out.println();
		}
//							(j+z)	 (i)	  (i*(j+z))
//		System.out.println(j+z+"x"+1+"="+ (1*j)+"  ");
//		System.out.println(j+z+"x"+2+"="+ (2*j)+"  ");
//		System.out.println(j+z+"x"+3+"="+ (3*j)+"  ");
//		
//		System.out.println(j+z+"x"+1+"="+ (1*(j+3))+"  ");
//		System.out.println(j+z+"x"+2+"="+ (2*(j+3))+"  ");
//		System.out.println(j+z+"x"+3+"="+ (3*(j+3))+"  ");
	}

}
