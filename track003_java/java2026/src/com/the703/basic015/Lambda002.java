package com.the703.basic015;

////////////////////////////////////////////////////////////
interface InterA2{  void   hi(); }
interface InterB2{  void   hi(String name); }
interface InterC2{  String hi(); }
interface InterD2{  String   hi(int num , String name); }   
////////////////////////////////////////////////////////////

public class Lambda002 {
	public static void main(String[] args) {
		//interface InterA2{  void   hi(); }
		System.out.println("\n\n[STEP1] 매개변수x, 리턴값x");
		//1-1. 익명객체
		InterA2 a1 = new InterA2() {
			public void hi() { System.out.println("hi"); }
		};  a1.hi();
		//1-2. 람다식	 ()->{}
		InterA2 a2 = ()->{ System.out.println("hi hi"); }  ;  a2.hi();
		InterA2 a3 = ()->  System.out.println("hi hi hi"); ;  a3.hi(); // 처리할일이 한줄 - {}생략
		
		//interface InterB2{  void   hi(String name); }
		System.out.println("\n\n[STEP1] 매개변수o, 리턴값x");
		//2-1. 익명객체      hi!  sally
		InterB2 b1 = new InterB2() {
			@Override public void hi(String name) { System.out.println("hi! "+name); }
		}; b1.hi("sally");
		//2-2. 람다식	 ()->{}
		InterB2 b2 = (String name)->{ System.out.println("hi! "+name); };  b2.hi("apple");
		
		InterB2 b3 = (		 name)->{ System.out.println("hi! "+name); };  b3.hi("alpha");
		
		InterB2 b4 = 		 name ->  System.out.println("hi! "+name);  ;  b4.hi("beta");
		
		//interface InterC2{  String hi(); }
		System.out.println("\n\n[STEP1] 매개변수x, 리턴값o");
		//3-1. 익명객체    Good :Day
		InterC2 c1 = new InterC2() {
			@Override public String hi() { return "Good :Day"; }
		};  System.out.println(c1.hi());
		//3-2. 람다식	 ()->{}
		InterC2 c2 = ()->{ return "Good :Day2"; };  System.out.println(c2.hi());
		InterC2 c3 = ()->  "Good :Day3";  			System.out.println(c3.hi());
		
		//interface InterD2{  String   hi(int num , String name); }  
		System.out.println("\n\n[STEP1] 매개변수o, 리턴값o");
		//4-1. 익명객체    hi sally ★ 
		InterD2 d1 = new InterD2() {
			@Override public String hi(int num, String name) {  
				String star=" ";
				for(int i=0;i<num;i++) { star+="★"; }
				return "hi "+ name + star; 
			}
		};  
		System.out.println(d1.hi( 1, "sally" )); // hi sally ★ 
		System.out.println(d1.hi( 2, "sally" )); // hi sally ★★ 
		
		//4-2. 람다식	 ()->{}
		//interface InterD2{  String   hi(int num , String name); }  
		InterD2 d2 = ( num, name )->{
			String star=" ";
			for(int i=0;i<num;i++) { star+="★"; }
			return "hi "+ name + star; 
		};  
		System.out.println(d2.hi( 3, "apple" )); // hi sally ★★★
		System.out.println(d2.hi( 4, "beta " ));  // hi sally ★★★★ 
		
		InterD2 d3 = ( num, name )->{ return "hi "+ name + " " + "★".repeat(num); };
		System.out.println(d3.hi( 5, "apple" )); // hi sally ★★★★★
		
		InterD2 d4 = ( num, name )->"hi "+ name + " " + "★".repeat(num);
		System.out.println(d4.hi( 6, "beta " ));  // hi sally ★★★★★★

	}
}



