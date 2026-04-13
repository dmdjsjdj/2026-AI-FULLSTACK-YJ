package com.the703.basic008_ex;

public class Arr1Ex012 {

	public static void main(String[] args) {
		//1. 서기 1년 1월 1일부터 2020년 10월 13일 까지의 총 일수 구하기
		//2. 2020년 10월 13일의 요일 구하기
		//3. 2020년 10월의 달력 출력
		
		int[] mon = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] yoil = {"일", "월", "화", "수", "목", "금", "토"};
		int days = 0;
		int yun = 0;
		
		//1. 서기 1년 1월 1일부터 2020년 10월 13일 까지의 총 일수 구하기
		for(int i=1;i<5;i++) {
			
			for(int j = 1;j<=12;j++) {
				System.out.println("i--"+i);
				System.out.println(j);
					for(int k=1;k<=mon[j];k++) {
						days=days+1;
						System.out.println(mon[j]);
					}
				
			}
			if(i!=0&&i%4==0) {
				yun++;
			}
			
		}days = days + yun;
		System.out.println("* 서기1년 ~ 2020년 10월 13일까지의 총 일수: "+days+"일");
		
		
	}

}
