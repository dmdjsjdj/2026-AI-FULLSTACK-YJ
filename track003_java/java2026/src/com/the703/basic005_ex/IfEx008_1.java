package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx008_1 {

	public static void main(String[] args) {
		//변수  학번         합불합       장학여부       레벨
		String std = " ", pass = " ", good = " ", lev = " " ;
		int kor = -1, mat = -1, eng = -1, total = -1;
		double avg = -1; 
		Scanner scanner = new Scanner(System.in);
		
		//입력
		System.out.print("학번 입력(stdnnn) > ");
		std = scanner.next();
		System.out.print("국어점수 입력 > ");
		kor = scanner.nextInt();
		System.out.print("수학점수 입력 > ");
		mat = scanner.nextInt();
		System.out.print("영어점수 입력 > ");
		eng = scanner.nextInt();
		
		//처리
		total = kor + mat + eng;  //1. 총점 구하기
		avg = total/3.0;		  //2. 평균 구하기

		//3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
		pass = avg < 60 ? "불합격" : kor >= 40 && mat >= 40 && eng >= 40 ?  "합격" : "불합격";
								// kor <  40 || mat <  40 || eng <  40 ?  "불합격" : "합격"
		
		//4. 평균이 95점이상이면 장학생
		good = avg>=95 ? "장학생" : "해당없음";
		
		//5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
		lev =   avg >= 90 ? lev = "수" 
			  : avg >= 80 ? lev = "우" 
			  : avg >= 70 ? lev = "미" 
			  : avg >= 60 ? lev = "양" : "가";
		
		//출력
		System.out.println("========================================================\n" 
						+  "학번     국어   영어   수학   총점   평균   합격여부   레벨   장학생\n"
						+  "======================================================== ");
		System.out.printf("%s  %d    %d   %d    %d  %.2f   %s     %s   %s", std, kor, eng, mat, total, avg, pass, lev, good );	
	}

}

/*
연습문제8)  
패키지명 : com.the703.basic005_ex
클래스명 :  IfEx007
출력내용 :  성적처리 프로그램입니다.

1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 
아니라면 가 

학번 입력 > std111
국어점수 입력 > 100
수학점수 입력 > 100
영어점수 입력 > 99
============================================= 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
============================================= 
std111   100   100   99   299   99.67   합격   수   장학생
 */