package com.the703.basic008_ex;

public class Array2Ex004 {

	public static void main(String[] args) {
		int[][] datas = {   {  10, 10, 10 ,10},             
                			{  20, 20, 20 ,20},     
                			{  30, 30, 30 ,30},     
		};  // 3층 4칸                               
						//		00 01 02 03 04
						//		10 11 12 13 14
						//		20 21 22 23 24
						//		30 31 32 33 34
		                             
		int[][] result = new int[datas.length+1][datas[0].length+1]; 
		
		int total=0; 
		int width=0; int height=0;
		
		for(int i=0;i<datas.length;i++) {
			width=0;
			for(int j=0; j<datas[i].length;j++) {
				
				result[i][j]=datas[i][j];
				total = total+datas[i][j];
				width=width+datas[i][j];
				height=0;
				for(int k=0;k<datas.length;k++) {
						height=height+datas[k][j];
					}result[datas.length][j]=height;
					
		//   result[i][datas[0].length]+=result[i][j];  가로 누적
		//   result[datas.length][j]+=result[i][j];  세로 누적
				
			}
			result[i][datas[0].length]=width;

		} result[datas.length][datas[0].length]=total;
			
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				System.out.print(result[i][j]+"\t");
			}System.out.println();
		}

	}

}

/*
연습문제4)  array
패키지명 : ccom.the703.basic008_ex
클래스명 :  Array2Ex004
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. 다음의 주어진조건을 이용하여 총점 구하시오.

int[][] datas = {  {  10, 10, 10 ,10},             
                  {  20, 20, 20 ,20},     
                  {  30, 30, 30 ,30},     
};  // 3층 4칸                                  
                               
int[][] result = new int[datas.length+1][datas[0].length+1];    

#1. result 에 datas데이터 복사하기
#2. 가로방향누적데이터
#3. 세로방향데이터누적
#4. 총합

출력내용:
10   10   10   10   40   
20   20   20   20   80   
30   30   30   30   120   
60   60   60   60   240   
*/