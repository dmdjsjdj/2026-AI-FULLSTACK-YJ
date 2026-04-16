package com.the703.basic009;

public class Method003 {
	
	//1. 함수구조 public static 리턴값(결과물) 메서드명(마법상자 이름) (미라미터: 제료) {할일}
	
	public static 			int hello(String name) {return 1;}    
//	public static 			void hello(String name) {   }    
	
	
	public static String sing() {return "용감한 자바전사";}
	
	public static String intro(String name,int level) {return name+"님의 레벨은"+level;}
	
	///////////////////////////////////////////
	public static void main(String[] args) {
		hello("aaa");
		System.out.println( hello( "bbb"));
		
		System.out.println("1. 당신의 이름은? "+ sing());
		System.out.println("2. 당신의 소개? " + intro("홍길동",9));
		//										~님의 레벨은 9
		System.out.println("2. 당신의 소개? " + intro(sing(),10));  //예상 결과
		
		System.out.println("3. 반타작의 저주 > " + spell(9));
		
		System.out.println("4. 운세 > " + luck()); //  > 100
		
		System.out.println("5. 주식 > " + s(32)); //  > x100

	}
    ///////////////////////////////////////////
  
	
	public static double spell(int level) {return level/2.0 ;}
	
	public static int luck() {return 100 ;}
	
	public static int s(int num) {return num*100 ;}

	
}
