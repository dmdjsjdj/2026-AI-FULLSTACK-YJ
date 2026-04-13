package com.the703.basic008_ex;

public class Arr1Ex004 {

	public static void main(String[] args) {
		//배열 사용해서 대소문자를 서로 바꿔서 출력
		
		char [] ch = { 'B' , 'a' , 'n' , 'a', 'n' , 'a' };
		
		for(int i=0;i<ch.length;i++) {
			int a= ch[i];
			if(ch[i]>='A'&&ch[i]<='Z') {
				a = a + 32;
				
				ch[i]=(char)a;
			}
			else if(ch[i]>='a'&&ch[i]<='z') {
				a = a - 32;
				ch[i]=(char)a;
			}
		}System.out.print(ch);
		

	}

}
