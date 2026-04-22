package com.the703.basic010_ex;

class Area1 {
	//멤버변수 : 
	//Area1.pi			(클래스변수 - static)
	static double pi=3.14159;
	//Area1.rect(10, 5) (클래스메서드 - static)
	public static double rect(int i, int j) {
		return i*j;
	}
	public static double triangle(int i, int j) {
		return (i*j)/2.0;
	}
	
}

public class StaticEx001 {
	public static void main(String[] args) {
		System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
	    System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
	    System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
	}
}
/*
연습문제1)  static
패키지명 : com.the703.basic010_ex
클래스명 :  StaticEx001
-- class Area1 작성해주세요   ※ pi값은 3.14159
public class StaticEx001{
  public static void main(String[] args) {  
   System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
   System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
  }
} 

출력내용 : 
원의 면적    : 314.159
사각형의 면적 : 50.0
삼각형의 면적 : 25.0
*/