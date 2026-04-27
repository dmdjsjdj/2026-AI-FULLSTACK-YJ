package com.the703.basic012;

/*
//1. 클래스는 부품객체
//2. 상속은 재활용 
	Object				
	  ↑
	TestA4 (int a, toString)	
	  ↑
	TestB4 (int b, toString)				
 */
class TestA4 extends Object { 
	int a=10;
	@Override public String toString() { return "TestA4 [a=" + a + "]"; }
	
} // end class
class TestB4 extends TestA4 { 
	int b=20;
	@Override public String toString() { return "TestB4 [b=" + b + "]"; }
	
} // end class
public class Poly004 {
	public static void main(String[] args) {
		TestA4 ta 				= new TestA4();
		//1. {a=10, toString}   = 1번지  {a=10, toString}
		
		TestB4 tb 						   = new TestB4();
		//2. {b=20, @toString}-{a=10,--}   = 2번지 {b=20, @toString}-{a=10,--}
		/*****
		tb = (TestB4) ta;
		// {b=20, @toString}-{a=10,--}  = 1번지 {a=10, toString}
		System.out.println(tb);
		System.out.println(tb.b);
		System.out.println(tb.a);
		*/
		ta = new TestB4(); //해결방안: ta에 자식생성자를 호출한 적이 있어야 한다.
		// 보장 {a=10, toString}   = 3번지  {b=20, @toString}-{a=10,--} 
		tb = (TestB4) ta; //타입캐스팅 필수
		// {b=20, @toString}-{a=10,--}  = 3번지  {b=20, @toString}-{a=10,--} 
		System.out.println(tb);
		System.out.println(tb.b);
		System.out.println(tb.a);
	}
}
/*
 Exception in thread "main" java.lang.ClassCastException: 
 class com.the703.basic012.TestA3 cannot be cast to class com.the703.basic012.TestB3 
 (com.the703.basic012.TestA3 and com.the703.basic012.TestB3 are in unnamed module of loader 'app')
 at com.the703.basic012.Poly003.main(Poly003.java:28)
 */

/*
1. 다형성
- 많은 형상을 띄는 성품
- 여러타입의 객체를 하나의 타입으로 관리

2. 부모는 자식을 담을 수 있다. (업 캐스팅)
---------------------------------------
<<class>> Animal [이름, 나이 / 먹기, 자기, 배변]
			↑
<<class>> Cat	 [동물등록증 / 꾹꾹이 하기]
---------------------------------------

Animal ani = new Cat();

1) Animal ani	{ 이름, 나이 / 먹기, 자기, 배변 }
2) 			Cat() → Animal()					 → Object()
{동물등록증 / 꾹꾹이 하기} + {이름, 나이 / 먹기, 자기, 배변}

3. 자식은 부모를 담을 수 있다. (다운캐스팅)
---------------------------------------
<<class>> Animal [이름, 나이 / 먹기, 자기, 배변]
			↓
<<class>> Cat	 [동물등록증 / 꾹꾹이 하기]
---------------------------------------
Cat cat = new Animal();
1) Cat cat;
{동물등록증 / 꾹꾹이 하기} + {이름, 나이 / 먹기, 자기, 배변}

2) new Animal()
{이름, 나이 / 먹기, 자기, 배변}

3) 만족 못 시키는 범위가 생김
{동물등록증 / 꾹꾹이 하기}

4. 쓰는이유?
- 부모타입으로 자식 개체들을 관리가능

Animal [] anis = { new Cat(), new Cat(), new Person(), new Person() };
 
*/