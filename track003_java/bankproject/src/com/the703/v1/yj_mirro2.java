package com.the703.v1;

import java.util.Random;
import java.util.Scanner;

public class yj_mirro2 {

	public static void main(String[] args) {
		//미로탈출
		
		char mirro ='\u0000';
		char[] mir= new char[11];
		char[] load = {'a','d','s','w'};
		double random=Math.random();
		int step=0;
		
//		for(int i=0;i<6;i++) {
//			
//			int lo = (int)Math.round(random * (load.length-1));
//			
//			if(i>0 && load[i-1]==lotto[i]) {
//				i--;
//			}
//			else {
//				lotto[i]=a;
//			}
//		} 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n  미로찾기 \r\n");
		
		for( ; step<=10 ;) {
			System.out.println("남은 길: "+ (mir.length-step));
			System.out.println(step);
			System.out.print("길 선택 "+
								"(왼쪽:a , 오른쪽:d , 위:w , 아래:s) : ");
			
			mirro = sc.next().charAt(0);
			
			
			if (mirro=='a') { //1.왼쪽길 선택
				if(mir[step]=='a') {
					step+=1;
					
				}else {
					System.out.println("\n 잘못된 길입니다.");
					step = step;
				}continue;
			} 
			
			else if (mirro=='d') {  //2.오른쪽길 선택
				if(mir[step]=='d') {
					step+=1;
					
				}else {
					System.out.println("\n 잘못된 길입니다.");
					step = step;
				}continue;
			}
			
			else if (mirro=='w') {  //3.윗길 선택
				if(mir[step]=='w') {
					step+=1;
					
				}else {
					System.out.println("\n 잘못된 길입니다.");
					step = step;
				}continue;
			}
			else if (mirro=='s') {  //4.아랫길 선택
				if(mir[step]=='s') {
					step+=1;
					
				}else {
					System.out.println("\n 잘못된 길입니다.");
					step = step;
				}continue;
			}
		}System.out.println("도착!");

	}

}
//미로찾기
// ><<>>ㅜ>>^<^^ 도착