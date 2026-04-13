package com.the703.basic008_ex;

import java.util.Arrays;

public class Arr1Ex010 {

	public static void main(String[] args) {
		//datas배열에는 실적건수마다 회원의 아이디가 적혀있다 
		//회원번호 1~4까지의 각 실적의 숫자를 세어서 갯수만큼 star배열에 갯수를 담고,
		//해당 숫자만큼의 *을 출력
		
		int[] datas = {1,3,1,1,4,4,3,1,4,1,2};
		int[] stars = new int[4];
		
		//  datas[0]  →   1    →   starts[1-1]++ →   starts[datas[0]-1]++ →   starts[0]++
		//  datas[1]  →   3    →   starts[3-1]++ →   starts[datas[1]-1]++    →   starts[2]++
		//  datas[2]  →   1    →   starts[1-1]++ →   starts[0]++  
		//  datas[3]  →   1    →   starts[1-1]++ →   starts[0]++  
		//  datas[4]  →   4    →   starts[4-1]++ →   starts[3]++  
		
		
		
		for(int i=0;i<datas.length;i++) {			
			stars[datas[i]-1]+=1;

//			if(datas[i]==1) {
//				a+=1;
//			}
//			else if(datas[i]==2) {
//				b+=1;
//			}
//			else if(datas[i]==3) {
//				c+=1;
//			}
//			else if(datas[i]==4) {
//				d+=1;
//			}
			
		}
		System.out.println(Arrays.toString(stars));
			
		for(int j=0;j<stars.length;j++) {
			for(int k=0;k<stars[j];k++) {
				System.out.print('*');
			}System.out.println();
		}

	}

}
