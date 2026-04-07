package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_1 {
	
	public static void main(String[] args) {
		//변수
		//자료형 : 기본형/참조형 (String)
		//기본형 - 정수:byte-shirt/char-int-long (1-2-4-8L)  / 실수:float-double (4f-8) / boolean 빼고 타입형변환 가능
		String std="", hap="불합격", lev="가", jang="";
		int kor=-1, eng=-1, mat=-1, total=-1;
		double avg=-1;
		
		Scanner scanner = new Scanner(System.in);

		//입력  0. 국어, 영어,수학(0~100만 입력받기) 무한반복
		//     문자열: next() / 정수형: nextInt() / 실수형: nextDouble() / 문자: next().charAt(0)
		System.out.print("\n학번 입력 > ");
		std = scanner.next();
		System.out.print("국어점수 입력 > ");
		kor = scanner.nextInt();
		System.out.print("수학점수 입력 > ");
		mat = scanner.nextInt();
		System.out.print("영어점수 입력 > ");
		eng = scanner.nextInt();
		
		total = kor+mat+eng;       //     1. 총점 구하기
		avg = (double)total/3;     //     2. 평균 구하기
		hap = avg<60 ? "불합격" : kor>=40 && mat>=40 && eng>=40 ? "합격" : "불합격";  //     3. 평균이 60이상 각과목 40미만 아니면 합격/ 아니면 불합격
		if(avg>=95) { jang="장학생"; }   //     4. 평균이 95점 이상이면 장학생
		
		switch((int)avg/10) {
		case 10: case 9: lev="수"; break;
		case 8: lev="우"; break;
		case 7: lev="미"; break;
		case 6: lev="양"; break;
		default: lev="가"; break;
		}      //     5. 평균 90이상 수 80이상 우 70이상 미 60이상 양 나머지 가
		
		//출력
		System.out.println("===================================================================== \r\n"
						 + "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\r\n"
						 + "===================================================================== \r\n");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n", std, kor, eng, mat, total, avg, hap, lev, jang);

		
	 }

}
