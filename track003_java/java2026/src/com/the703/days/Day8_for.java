package com.the703.days;

import java.util.Scanner;

public class Day8_for {

	public static void main(String[] args) {
		
//		q1-1 int형 변수 x가 60이상일때 조건식  
//		if(int x >= 60)
//		q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식   
//		if(ch == 'a' || ch == 'A')  
//		q1-3 char형 변수 ch가 숫자('0'~'9')일때   조건식      
//		if(ch >= 0 && ch <= 9)
//		q1-4 char형 변수 ch가 영문자(대문자) 일때    조건식 
//		if(ch>='A' && ch<='Z')
		
		//변수
		int kor=-1, eng=-1, mat=-1, total=-1;
		double avg=-1;
		String std=" ", hap=" ", lev=" ", jang=" ";
		
		Scanner scanner = new Scanner(System.in);
		
		for( ; kor<101 || eng<101 || mat<101 ; ) {
				//입력
				System.out.print("\n학번 입력 > ");
				std = scanner.next();
				System.out.print("국어점수 입력 > ");
				kor = scanner.nextInt();
				System.out.print("수학점수 입력 > ");
				mat = scanner.nextInt();
				System.out.print("영어점수 입력 > ");
				eng = scanner.nextInt();
				
			if(kor<0 || eng<0 || mat<0 || kor>100 || eng>100 || mat>100) {	
				System.out.println("\n잘못된 숫자입력입니다");
			}else {
				
				//처리
				total = kor+mat+eng;
				avg = (double)total/3;
				
				hap = (avg<60 ? "불합격" : kor>=40 && mat>=40 && eng>=40 ? "합격" : "불합격");
				jang = (avg>=90 ? "장학생" : "해당없음");
				lev = (avg>=90 ? "수" : avg>=80 ? "우" :avg>=70 ? "미" :avg>=60 ? "양" : "가");
			
				//출력
				System.out.println("===================================================================== \r\n"
								 + "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\r\n"
								 + "===================================================================== \r\n");
				System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n", std, kor, eng, mat, total, avg, hap, lev, jang);
			}
		}

	}

}

/*
   패키지명 : com.the703.days
   클래스명 :  Day008
   출력내용 :  성적처리 프로그램입니다.
   1. 총점 구하기
   2. 평균 구하기
   3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
   4. 평균이 95점이상이면 장학생
   5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

   학번 입력 > std111
   국어점수 입력 > 100
   수학점수 입력 > 100
   영어점수 입력 > 99
   ======================================================== 
   학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
   ======================================================== 
   std111   100   100   99   299   99.67   합격   수   장학생
*/