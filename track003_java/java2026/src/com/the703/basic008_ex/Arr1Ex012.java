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
		for(int i=1;i<=2020;i++) {  //년 계산
			
			for(int j = 1;j<=12;j++) {  //월 계산
				if(i==2020&&j==10) {
					for(int k=1;k<=13;k++){  //일 계산
						days=days+1;
					}break;
				}
<<<<<<< HEAD
				else if(j == 2 && ((i%4==0 && i%100!=0)||i%400==0)) {  //일 계산
					days += 29;
=======
				else if(j==2&&((i%4==0 && i%100!=0)||i%400==0)) {
						days=days+29;
>>>>>>> 5787e668d91aef39c269b6379e8beb65b9b264dc
				}
				else {
					for(int k=1;k<=mon[j];k++) {  //일 계산
						days=days+1;
					}
				}
				
			}
			
<<<<<<< HEAD
		}
=======
		} System.out.println(days); System.out.println(yun); 
		days = days + yun;
>>>>>>> 5787e668d91aef39c269b6379e8beb65b9b264dc
		System.out.println("* 서기1년 ~ 2020년 10월 13일까지의 총 일수: "+days+"일");
		
		System.out.println("* 2020년 10월 13일 "+yoil[days%7]+"요일");
		
<<<<<<< HEAD
		System.out.println("* 2020년 10월 13일 "+yoil[days%7]+"요일");
		
=======
>>>>>>> 5787e668d91aef39c269b6379e8beb65b9b264dc
		System.out.println("========= 10월 ==========");
		for(int i=0;i<yoil.length;i++) {
			System.out.print(yoil[i]+"\t");
		}
		System.out.println();
		
<<<<<<< HEAD
		//시작요일 공백
		int startDay = (days - 12) % 7;
		
		for(int i=0; i<startDay;i++) {
			System.out.print("*\t");
		}
		
		for(int i=1;i<=31;i++) {
			System.out.print(i+"\t");
			
			if((startDay+i)%7==0) {
				System.out.println();
			}
		}
		
		
=======
		int startday = (days-12)%7;
		
		for(int r=0;r<startday;r++) {
			System.out.print( "*\t" );
		}
		for(int i = 1;i<mon[10];i++) {
			System.out.print(i+"\t");
			if((startday+i)%7==0) {
				System.out.println();
			}
		}
>>>>>>> 5787e668d91aef39c269b6379e8beb65b9b264dc
	}

}
