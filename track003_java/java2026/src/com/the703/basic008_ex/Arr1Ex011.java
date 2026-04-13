package com.the703.basic008_ex;

import java.util.Arrays;
import java.util.Random;

public class Arr1Ex011 {

	public static void main(String[] args) {
		// 1~45중에 겹치지않게 6개 발생하게 만드는 로또번호 프로그램
		
		int[] lotto = new int[6];
		Random random = new Random();
		int a = 0;
		
		for(int i=0;i<6;i++) {
			
			a = (int)random.nextInt(45)+1;
			
			if(i>0 && lotto[i-1]==lotto[i]) {
				i--;
			}
			else {
				lotto[i]=a;
			}
		} 
		System.out.println(Arrays.toString(lotto));

	}

}
