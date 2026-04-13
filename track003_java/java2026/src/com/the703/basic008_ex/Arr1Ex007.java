package com.the703.basic008_ex;

public class Arr1Ex007 {

	public static void main(String[] args) {
		//su[4]의 등수를 구하시오
		
		int[] su= {-3,-5,-1,-9,-7};
		int rank=1;
		
		for(int i=0;i<su.length-1;i++) {
			if(su[4]<su[i]) {
				rank = rank+1;
			}
		}System.out.println(rank+"등");
	}

}
