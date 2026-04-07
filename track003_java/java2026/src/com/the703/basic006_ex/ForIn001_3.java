package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_3 {
	
	public static void main(String[] args) {
		//변수
		//자료형 : 기본형/참조형 (String)
		//기본형 - 정수:byte-shirt/char-int-long (1-2-4-8L)  / 실수:float-double (4f-8) / boolean 빼고 타입형변환 가능
		String std="", hap="불합격", lev="가", jang="";
		int kor=-1, eng=-1, mat=-1, total=-1;  /* ■1) 0~100사이가 아닌 값*/
		double avg=-1;
		
		Scanner scanner = new Scanner(System.in);

		//입력
		System.out.print("\n학번 입력 > ");
		std = scanner.next();
		
		for(;;) {
			
			if( kor<0 || kor>100 ) {   // ■2) kor = -1
				System.out.print("국어점수 입력 > "); 
				kor = scanner.nextInt();  //3)
				continue;
			}
			if(mat<0 || mat>100) {
				System.out.print("수학점수 입력 > ");
				mat = scanner.nextInt();
				continue;
			}
			if(eng<0 || eng>100) {
				System.out.print("영어점수 입력 > ");
				eng = scanner.nextInt();
				continue;
			} break;   // kor eng mat 입력을 잘한경우
		}
		
		/*   변수 int a 초기값에 -1과 0의 차이
		 * for(;;){
		 * 		if(국어점수 범위가 아니라면){  //-1  (0~100 사이가 아니므로 처리가능)
		 * 			1.	국어점수입력 > (0~100만 입력받기)
		 * 			2.  건너뛰기  continue;
		 * 		if(영어점수 범위가 아니라면){
		 * 			1.	영어점수입력 > 
		 * 			2.  건너뛰기
		 * 		}
		 * 		if(수학점수 범위가 아니라면){
		 * 			1.	수학점수입력 > 
		 * 			2.  건너뛰기
		 * 		}
		 *      //break; 나오기
		 * }
		 * */
						
			//처리
			total = kor + mat + eng;
			avg = (double)total/3;
			
			hap = (avg<60 ? "불합격" : kor>=40 && mat>=40 && eng>=40 ? "합격" : "불합격");
			jang = (avg>=95 ? "장학생" : "해당없음");
			lev = (avg>=90 ? "수" : avg>=80 ? "우" :avg>=70 ? "미" :avg>=60 ? "양" : "가");
		

		hap = (avg<60 ? "불합격" : kor>=40 && mat>=40 && eng>=40 ? "합격" : "불합격");
		jang = (avg>=95 ? "장학생" : "해당없음");
		lev = (avg>=90 ? "수" : avg>=80 ? "우" :avg>=70 ? "미" :avg>=60 ? "양" : "가");
	
		//출력
		System.out.println("===================================================================== \r\n"
						 + "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\r\n"
						 + "===================================================================== \r\n");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n", std, kor, eng, mat, total, avg, hap, lev, jang);

		
	 }

}
