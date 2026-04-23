package com.the703.basic010;

//import java.awt.Color;

//1. final 변경하지마
//1) 클래스는 부품객체
//2) 클래스(상속:X)는 상태(멤버변수:상수)와 행위(멤버함수)
/*final	class  재상속하지마-상속 */
class FinalEx extends Object {
	static final String child="5-5";  // 클래스 변수 - method area - new X - this X
	String name;  //인스턴스 변수 - heap area - new o - 생성자() - this
	/* final */ void show() { System.out.println(child+"\t"+name); }// 인스턴스 메서드
}
class FinalExSon extends FinalEx {
	@Override  void show() { System.out.println("나한테 맞게 수정"); }
}
//class Test extends Color {}

public class Class006_Final {
	public static void main(String[] args) {
//		FinalEx.child = "5-12";
//		The final field FinalEx.child cannot be assigned
	}
}
/***
//1. final (하지마)

1) 클래스   (상속 X / 재사용 X / extends 사용못함)
2) 멤버변수  ( 상수O / 값변경 X)
3) 멤보함수  (부모기능 상속 X, @Override 못함)
***/