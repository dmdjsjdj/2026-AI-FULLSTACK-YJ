package com.the703.basic008_ex;

public class Arr1Ex008 {

	public static void main(String[] args) {
		// 배열의 최대값, 최소값을 구하시오
		
		int[] su= {-3,-5,-1,-9,-7};
		int max=-99999, min=99999;
		
		
		// -3이 max 보다 크다면 max에 su[0]담기 
		//-3이 min보다 작다면 min에 su[0]담기
		
		
		
		for(int i=0;i<su.length-1;i++) {
			if(su[i]<min) {
				min=su[i];
			}
			if(su[i]>max) {
				max=su[i];
			}
		}System.out.printf("최대값: %d, 최소값: %d",max,min);

	}
}
