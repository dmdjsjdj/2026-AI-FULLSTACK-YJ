package com.the703.basic010;

public class Score{    // com.the703.basic010 패키지에 설정해주세요
	   private String name;
	   private int kor, eng, math , total;
	   private double aver;
	   private String p  , s  , rank;
	   public Score() { super(); }
	   public Score(String name, int kor, int eng, int math, int total, double aver, String p, String s, String rank) 
	   { super(); this.name = name; this.kor = kor; this.eng = eng; this.math = math; this.total = total; this.aver = aver; 
	   			  this.p = p; this.s = s; this.rank = rank; }
	   @Override
	   public String toString() {
		return ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\r\n"
				+ "이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹\r\n"
				+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\\r\\n"
				+ name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total
				+ "\t" + aver + "\t" + p + "\t" + s + "\t" + rank ;
	   }
	   public String getName() { return name; } public void setName(String name) { this.name = name; } 
	   public int getKor() { return kor; } public void setKor(int kor) { this.kor = kor; } 
	   public int getEng() { return eng; } public void setEng(int eng) { this.eng = eng; } 
	   public int getMath() { return math; } public void setMath(int math) { this.math = math; }
	   public static void info() {
		   System.out.println();
	   }
	   public String hap() {
		   return p= total<60?"불합격":total>=60?"합격":" ";
		   
	   }
	   public void show() {
		   
		   total = kor+eng+math;
		   aver  = total/3f;
	   } 
	}