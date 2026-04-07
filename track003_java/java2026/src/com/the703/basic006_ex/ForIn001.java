package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001 {
	
	public static void main(String[] args) {
		//변수
		int kor=-1, eng=-1, mat=-1, total=-1;
		double avg=-1;
		String std=" ", hap=" ", lev=" ", jang=" ";
		
		Scanner scanner = new Scanner(System.in);
		
		for( ;  ; ) {
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
				jang = (avg>=95 ? "장학생" : "해당없음");
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
