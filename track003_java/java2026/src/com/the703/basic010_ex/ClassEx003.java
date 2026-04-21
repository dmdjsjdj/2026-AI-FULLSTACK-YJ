package com.the703.basic010_ex;

class Coffee{
	  String name;  int  price, num;
	  public Coffee(String string, int i, int j) {
		name=string;
		price=j;
		num=i;
	  }
	  
	  public Coffee() {
		super();
		this.name = "아메리카노";
		this.price = 2000;
		this.num = 1;
	}

	  void show(){
		  System.out.println("=====커피\r\n"
		  		+ "커피명 : "+name+"\r\n"
		  		+ "커피잔수 : "+num+"\r\n"
		  		+ "커피가격 : "+price*num);
	  }   //커피정보출력
	}

public class ClassEx003 {
	public static void main(String[] args) {
		Coffee a1 = new Coffee("까페라떼" ,2 , 4000); a1.show(); // 1) new 객체생성 2) 초기화 "까페라떼"  3) 주소
		Coffee a2 = new Coffee();   a2.show();        
	}
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------
[METHOD:정보]	Coffee.class(설계도) , 		ClassEx003.class#1
------------------------------------------------------------
[HEAP:동적]           							 |  [STACK:지역]
2번지:{name="아메리카노",num=1, price=2000,show()}	  ←  a2[2번지]
1번지:{name="까페라떼",num=2, price=4000,show()}	  ←  a1[1번지]
													 main#2
------------------------------------------------------------
*/
//////////////////////////////////////////////////////
/*
연습문제1)  class
패키지명 : com.the703.basic010_ex
클래스명 :  ClassEx003
-- 생성자 작성하시오.
class Coffee{
  멤버변수 : String name;  int  price, num;
  멤버함수 : void show(){}   //커피정보출력
}
public class Class003 {
   public static void main(String[] args) {
   Coffee a1 = new Coffee("까페라떼" ,2 , 4000);  a1.show();
   Coffeea2 = new Coffee();                     a2.show();
  }
}
출력내용 :
=====커피
커피명 : 까페라떼
커피잔수 : 2 
커피가격 : 8000
=====커피
커피명 : 아메리카노
커피잔수 : 1
커피가격 : 2000
*/