package com.the703.basic007;

public class ForEtc007_1 {

	public static void main(String[] args) {
		//다중 for을 이용해서 구구단을 가로 3단으로 출력
		//  2단  3단  4단
		//  5단  6단  7단
		//  8단  9단
		
		for(int j=2;j<=9;j+=3) {    //단 숫자 증가
				for(int z=1;z<9;z++) {  // 2->3->4 증가
					
					System.out.printf("%d x %d = %d  %d x %d = %d  %d x %d = %d", j,z,j*z, j+1,z,(j+1)*z, j+2<=9?j+2:null,j+2<=9?z:null,j+2<=9?(j+2)*z:null);
					System.out.println();
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
//		(j+z)	 (i)	  (i*(j+z)) 		(j+z+1)	 (i)	  (i*(j+z))		(j+z+2)	 (i)	  (i*(j+z))
//		(j+z+3)	 (i)	  (i*(j+z))
	}

}
