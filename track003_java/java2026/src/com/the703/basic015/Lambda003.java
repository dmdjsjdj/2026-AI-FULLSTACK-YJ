package com.the703.basic015;

class RefClass{       void method(String str) {  System.out.println(str);}  }
interface InterUsing{ void inter( RefClass c  , String str); }  

public class Lambda003 {
	public static void main(String[] args) {
		//#1. 익명클래스
		InterUsing a1 = new InterUsing() {
			@Override public void inter(RefClass c, String str) { c.method(str); }
		};
		a1.inter(new RefClass(), "Hello :)");  // 부품객체(RefClass)의 method를 사용
		
		//#2. 람다 ()->{}  [RefClass]의 [method]를 사용
//		InterUsing a2 = (RefClass c, String str)-> { c.method(str); };
		InterUsing a2 = ( 		  c,        str)->   c.method(str);  // 직접구현
		a2.inter(new RefClass(), "Hello :) :D");
		
		//#3. :: 표현식(참고)
		//class       RefClass{ void method(String str) {  System.out.println(str);}  }
		//interface InterUsing{ void inter( RefClass c  , String str ); 	          }  
		InterUsing a3 = RefClass::method;  // 자동연결 1) RefClass  2) method
		a3.inter(new RefClass(), "Hello :) :D XP");
		System.out.println();
		////////////////////////////////////////////////////////////////////////////////
		//interface  InterBasic{  int method(int a, int b);         }  
		InterBasic basic1 = (int a, int b)->{ return Math.max(a, b); }; // max static(바로사용가능)
		System.out.println(basic1.method(10, 3));  
		
		InterBasic basic2 = (	 a, 	b) ->		 Math.max(a, b);   // Math 부품, max 사용 static(바로사용가능)
		System.out.println(basic2.method(10, 3));     
		
		InterBasic basic3 = Math::max;   // Math 부품, max 사용 static(바로사용가능)
		System.out.println(basic3.method(10, 3)); 
		// Math::min
		InterBasic basic4 = (	 a, 	b) ->		 Math.min(a, b);   // Math 부품, min 사용 static(바로사용가능)
		System.out.println(basic4.method(10, 3)); 
		
		InterBasic basic5 = Math::min;   // Math 부품, min 사용 static(바로사용가능)
		System.out.println(basic5.method(10, 3)); 
		System.out.println();
		/////////////
		/// 
		//String::compareTo
		//interface  InterString{ int compare(String a, String b);  }  
		// String.compareTo
		InterString basic6 = (	 a, 	b)-> a.compareTo(b);
		//									int java.lang.String.compareTo( String anotherString )
		System.out.println(basic6.compare("apple", "banana"));  //-1
		// 문자열이 같으면 0, (음수) a<b  a가 b보다 앞에 옴, (양수) a>b  a가 b보다 뒤에 옴 
		
		// String 부품객체 ,  compareTo 기능
		InterString basic7 = String::compareTo;
		System.out.println(basic7.compare("banana","apple" )); System.out.println();
		
		//interface  InterParse{  int parse(String s);              } 
		InterParse basic8 = s -> Integer.parseInt(s);  //Integer 부품의 parseInt 사용
		System.out.println(basic8.parse("10")+3);  // 13   문자열을 숫자열로
		// 참조형으로 바꾸기
		InterParse basic9 = Integer::parseInt;
		System.out.println(basic9.parse("10")+3); System.out.println();
		
		//interface  InterAbs  {  int apply(int a);                 }  (a)->return 1
		InterAbs basic10 = a-> Math.abs(a);  // Math 부품의 abs 사용
		System.out.println( basic10.apply(-10)); // abs: 절대값으로 변경하는 기능박스
		// 참조형으로 바꾸기
		InterAbs basic11 = Math::abs;
		System.out.println( basic11.apply(-10)); System.out.println();
		
		//interface  InterPrint{  void print(String s);             }  
		InterPrint basic12 = s-> System.out.println(s);  // System.out 부품의 println 사용
		basic12.print("Hello Lambda");
		// 참조형으로 바꾸기
		InterPrint basic13 = System.out::println;
		basic13.print("Hello Lambda");
		System.out.println();
		
		//interface  Ex1{  int getLength(String s);  }   
		Ex1 ex1 = s-> s.length();
		System.out.println(ex1.getLength("hello"));   // 결과5
		// 참조형으로 바꾸기
		Ex1 ex11 = String::length;
		System.out.println(ex11.getLength("hello"));
		System.out.println();
		
		//interface  Ex2{  void print(String s);     }  
		Ex2 ex2 = s-> System.out.println(s);
		ex2.print("lambda:)");
		// 참조형으로 바꾸기
		Ex2 ex22 = System.out::println;
		ex22.print("lambda:)");
		
	}
}

interface  InterBasic{  int method(int a, int b);         }  
interface  InterString{ int compare(String a, String b);  }  
interface  InterParse{  int parse(String s);              }  
interface  InterAbs  {  int apply(int a);                 }  
interface  InterPrint{  void print(String s);             }  

interface  Ex1{  int getLength(String s);  }   
interface  Ex2{  void print(String s);     }  





