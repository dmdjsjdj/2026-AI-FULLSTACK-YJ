package com.the703.basic008_ex;

public class Arr1Ex003 {

	public static void main(String[] args) {
		//new를 이용해 문자열 배열 ch 52개 만들기
		// 대문자 A~Z, a~z까지 52개의 데이터를 for을 이용하여 ch배열에 데이터를 대입하시오
		//for문을 이용하여 무음의 갯수를 구하시오
		
		
		char[] ch = new char[52];
		int count=0;
		
		for(char ch1='A';ch1<='z';ch1++) {
			int i=0;
			if(ch1>='A'&& ch1<='Z') {
				ch[i]=ch1;
			}
			else if(ch1>='a'&& ch1<='z') {
				
				ch[i]=ch1;
			}
			else {
				continue;
			}
			i++;
			
			for(int a=0;a<ch.length;a++) {
				if(ch[a]=='a'|| ch[a]=='e'|| ch[a]=='i'|| ch[a]=='o'|| ch[a]=='u'
						|| ch[a]=='A'|| ch[a]=='E'|| ch[a]=='I'|| ch[a]=='O'|| ch[a]=='U') {
					count+=1;
				}
			}
		}System.out.println("모음의 갯수: " + count);

	}

}
