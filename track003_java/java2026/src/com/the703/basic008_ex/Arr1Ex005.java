package com.the703.basic008_ex;

public class Arr1Ex005 {

	public static void main(String[] args) {
		//배열에서 음수의 갯수 출력
		
		int[] su= {-3,5,-1,9,-7};
		int count=0;
		
		for(int i=0;i<su.length;i++) {
			if(su[i]<0) {
				count+=1;
			}
		}System.out.println(count);

	}

}
