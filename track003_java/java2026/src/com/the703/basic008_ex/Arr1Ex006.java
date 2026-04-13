package com.the703.basic008_ex;

public class Arr1Ex006 {

	public static void main(String[] args) {
		//배열중 양수중에서 홀수의 합을 구하시오
		
		int[] su= {-3,5,-1,9,-7,2,-11};
		int num=0;
		
		for(int i=0;i<su.length;i++) {
			if(su[i]>=0 && su[i]%2!=0) {
				num=num+su[i];
			}
		}System.out.println(num);

	}

}
