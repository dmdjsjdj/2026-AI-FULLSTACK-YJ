package com.the703.basic008_ex;

public class ArrayEx005 {

	public static void main(String[] args) {
		
		char [] ch = { 'B' , 'a' , 'n' , 'a', 'n' , 'a' };
		int cut1=0;
		int cut2=0;
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>='A'&&ch[i]<='Z') {
				cut1+=1;
			}
			else if(ch[i]>='a'&&ch[i]<='z') {
				cut2+=1;
			}
		}
		System.out.println("대문자 갯수: "+cut1+"개"+"\n소문자 갯수: "+cut2+"개");

	}

}
//연습문제5)  array
//패키지명 : com.the703.basic008_ex
//클래스명 :  ArrayEx005
//    1. 배열명 : ch
//    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
//    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트