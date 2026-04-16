package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx004 {
	
	public static int process_total(int a, int b, int c) {
		int total= a+b+c;
		return total;
	}
	public static float process_avg(int a) {
		float avg=(float) (a/3.0);
		return avg;
	}

	public static void main(String[] args) {
			/////////////////////(1)  변수
			String name  = ""; 
			int kor, eng, math, total ;
			float avg = 0.0f; 
			String pass = "";
			String jang = "";
			String star= "";  
			Scanner scanner = new Scanner(System.in);
			
			/////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
			System.out.print("이름을 입력하시오 : ");
			name=scanner.next();
			System.out.print("국어점수를 입력하시오 : ");
			kor=scanner.nextInt();
			System.out.print("영어점수를 입력하시오 : ");
			eng=scanner.nextInt();
			System.out.print("수학점수를 입력하시오 : ");
			math=scanner.nextInt();
			
			/////////////////////(3) 처리 : 
			total = process_total(kor , eng, math);    // 1. 총점처리
			
			avg = process_avg(total);    //2.  평균처리
			
			////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
			pass = process_pass(avg , kor, eng, math);  
			
			//////// 4. 평균이 95점이상이면 장학생
			jang = process_scholar(  avg  ); 
			
			//////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
			star = process_star(avg);  
			
			
			/////////////////////(4) 출력
			System.out.println(process_show(name, kor, eng, math, total, avg, pass, jang, star));
			
			

	}
	
		public static String process_pass(float a,int b, int c, int d) {
			String pass = "";
			if(d<40||b<40||c<40) {
				pass="불합격";
			}
			else if(a>=60&&b>=40&&c>=40&&d>=40) {
				pass="합격";
			}
			return pass;
		}
		
		public static String process_scholar(float a) {
			String jang = "";
			if(a>=95) {
				jang="장학생";
			}
			return jang;
		}
		public static String process_star(float avg) {
			String star= "";
			for(int i=0;i<(int)(avg/10);i++) {
				star+="★";
			}
			return star;
		}
		
		public static String process_show(String name,int kor,int eng,int math,int total,float avg,
				String pass,String jang, String star ) {
			return "이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹\n"
				+"--------------------------------------------------------------------------------------------\n"
			    + name+"\t"+ kor+"\t"+ eng+"\t"+  math+"\t"+  total+"\t"+  String.format("%.1f",avg)+"\t"+  pass+"\t"+  jang+"\t"+  star
			    +"\n--------------------------------------------------------------------------------------------\n";
		}
		
//"%s\t%d\t%d\t%d\t%d\t%.f"
}

/*
연습문제4)  method
패키지명 : com.the703.basic009_ex
클래스명 :  MethodEx004

public class MethodEx004{ 
   public static void main(String[] args) {
   /////////////////////(1)  변수
      String name  = ""; 
      int kor, eng, math, total ;
      float avg = 0.0f; 
      String pass = "";
      String jang = "";
      String star= "";  
      Scanner scanner = new Scanner(System.in);
      
      /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
   
      /////////////////////(3) 처리 : 
      total = process_total(kor , eng, math);    // 1. 총점처리
      
      avg = process_avg(total);    //2.  평균처리
      
      ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
      pass = process_pass(avg , kor, eng, math);  
      
      //////// 4. 평균이 95점이상이면 장학생
      jang = process_scholar(  avg  ); 
      
      //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
      star = process_star(avg);  
      
      
      /////////////////////(4) 출력
      process_show(name, kor, eng, math, total, avg, pass, jang, star);
    
      
   }// end main
 
   
}// end class

 
      ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
      이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
      --------------------------------------------------------------------------------------------
      아이언맨   100   100   100   300    100.0    합격      장학생   **********
      --------------------------------------------------------------------------------------------

*/