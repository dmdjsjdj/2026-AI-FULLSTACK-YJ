package com.the703.basic010_ex;

//1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
//2. 인스턴스메서드, 클래스메서드 구분하시오.
//3. 오류나는 이유는?
class Sawon3{ 
    int pay      =10000; //인스턴스변수 - new - heap area - 생성자 관련 - this   
 
    static int su=10;    				  //클래스변수 - static - method area - 공용 - 클래스명.변수
//    static int basicpay=pay;    //필요X  //클래스변수 - 인스턴스변수 - static은 인스턴스 변수(this) 불가
    static int basicpay2;       //필요X    //클래스변수 - static - method area - 공용 - 클래스명.변수
    
    public static void showSu() {   System.out.println(su);  }    //있을필요X      //클래스메서드
//     void showPay() {   System.out.println(this.pay);  } //  static 붙이고 this 사용해서 오류 +사용안하는중 //클래스메서드
    	//static은 인스턴스 변수(this) 불가
  
    public  void  showAll001() {   //인스턴스메서드  (static X)
       System.out.println(su);  
       System.out.println(this.pay);  // new 객체 만들어서 사용
    } 
    public static  void  showAll002() {   //클래스메서드 (static O)
//        showAll001();    			 //인스턴스메서드  (this 샤용불가)
//       System.out.println(this.pay);
    } 
} 
public class MemberVarEx001{
  public static void main(String[] args) {
   Sawon3   sola = new Sawon3();  
   sola.showAll001();
  }
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------
[METHOD:정보]	Sawon3.class(설계도) , 		MemberVarEx001.class#1
	Sawon3.su=10;	Sawon3.basicpay2;	Sawon3.basicpay;   Sawon3.showSu()	 Sawon3.showAll001()
------------------------------------------------------------
[HEAP:동적]            |  [STACK:지역]

1번지:{pay=10000,
	  showAll001()}	   ←  sola[1번지]		- 1) new  2) 생성자 3) 번지 - new해서 객체생성 후 사용 가능
 						  main#2
------------------------------------------------------------
*/
//////////////////////////////////////////////////////

/*
패키지명 : com.company.java010_ex
클래스명 :  MemberVarEx001
-- class Sawon3작성해주세요 
1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
2. 인스턴스메서드, 클래스메서드 구분하시오.
3. 오류나는 이유는?
class Sawon3{ 
    int pay      =10000;    
    static int su=10;     
    static int basicpay=pay;    
    static int basicpay2;    
    
    public static void showSu() {   System.out.println(su);  }          
    public static void showPay() {   System.out.println(this.pay);  }    
  
    public  void  showAll001() {   
       System.out.println(su);  
       System.out.println(this.pay);  
    } 
    public static  void  showAll002() {   
        showAll001();    
       System.out.println(this.pay);
    } 
} 
public class MemberVarEx001{
  public static void main(String[] args) {
   Sawon3   sola = new Sawon3();  
   sola.showAll001();
  }
}
*/