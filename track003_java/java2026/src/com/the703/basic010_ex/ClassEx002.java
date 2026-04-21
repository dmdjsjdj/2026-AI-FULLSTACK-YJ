package com.the703.basic010_ex;

import java.util.Scanner;

class MyPrice001{
	  String name;  int price;
	  
	  // 멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
	  //1) 모든클래스는 생성자 - 컴파일러가 기본생성자를 자동생성  MyPrice001()
	  void input() {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("상품이름 입력 > ");
		  name=sc.next();
		  System.out.println("상품가격 입력 > ");
		  price=sc.nextInt();
	  }  
	  void show() {
		  System.out.println("상품정보입니다\r\n"
		  		+ "상품이름 : "+name+ " \n상품가격 : "+price);
	  }
}

public class ClassEx002 {
	public static void main(String[] args) {
		MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
	}
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------
[METHOD:정보]	MyPrice001.class(설계도) , 		ClassEx002.class#1
------------------------------------------------------------
[HEAP:동적]           					 |  [STACK:지역]
1번지 MyPrice001 (객체, object, instance)
 {name="입력",price=1, input(),show()}	  ←  p1[1번지]
 											main#2
------------------------------------------------------------
*/
//////////////////////////////////////////////////////
/*
연습문제2)  class
패키지명 : com.the703.basic010_ex
클래스명 :  ClassEx002
class MyPrice001{
  멤버변수 : String name;  int price;
  멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
}
public class ClassEx002{
   public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
   }
}
출력내용 : 
  상품이름 입력 >  apple
  상품가격 입력 >  1500

  상품정보입니다
  상품이름 : apple  / 상품가격 : 1500
*/