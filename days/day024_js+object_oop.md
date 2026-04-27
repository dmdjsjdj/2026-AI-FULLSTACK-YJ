

### ■1.  복습문제

class A11 {
    int a; // (1)

    A11() { }

    A11(int a) { this.a = a; } // (2)

    //(3) void show()
    void show() { 
        this.a = 11; 
        System.out.println(this.a); 
    }

    //(4) static void classMethod()
    static void classMethod() { this.a = 12; }

    //(5) int showZ()
    int showZ() { 
        int a; 
        return a; 
    }
}

public class RepeatQ123 {
    public static void main(String []args) { 
        A11 a1 = new A11(); 
        (b) 
    }
} // end class

Q1. 위의 문제에서 (1),(2),(3),(4),(5)를 [ 클래스변수, 인스턴스변수, 지역변수, 클래스메서드, 인스턴스메서드 ]에서 고르시오.

Q2. 클래스 A11에서 오류나는 곳을 수정하고 그 이유를 적으시오.

Q3. (b)번 위치에서

메모리 빌려오고, 객체 생성하는 역할 : (          )
String은 null, int는 0으로 초기화하는 역할 : (     )
new A11()한 주소를 갖고 있는 것은 : (      )

Q4. 기본생성자를 반드시 선언해야하는 경우를 적으시오.

Q5. 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오)
a. 메서드의 이름이 같아야 한다.
b. 매개변수의 개수나 타입이 달라야 한다.
c. 리턴타입이 달라야 한다.
d. 매개변수의 이름이 달라야 한다.


Q6. 다형성이란? 

Q7. 다음코드에서 다음에 해당하는 부분을 작성하시오.

//7-1. 상속도
//7-2. 각 클래스에서 사용할수 있는 멤버변수, 멤버함수

package com.the703.basic012_ex;

class Parent7  extends Object{
      int x = 100;
      public Parent7() { super(); }
      void method() { System.out.println("Parent Method"); }
} 
class Child7 extends Parent7 {
   int x = 200;
   public Child7() { super(); }
   @Override  void method() { System.out.println("Child Method"); }
}

public class PolyEx002 {
   public static void main(String[] args) {
         Parent7 p = new Child7();     //부모  = 자식 (업캐스팅)
         // 7-3.    Parent7 p   보장하는 범위  
         // 7-4.    인스턴스화 했을때 사용가능한 범위 : new Child7()   
         Child7 c = new Child7();  

         System.out.println("p.x = " + p.x);  // 7-5 출력되는 내용  
         p.method();  //7-6 출력되는 내용    
         
         System.out.println("c.x = " + c.x);   // 7-7  출력되는 내용 
         c.method();   //7-8. 출력되는 내용     
   }
}

---

### ■2.  Todo1: java  method



---

### ■3.  Todo2: java  method


---

### ■4.  복습문제

■OOP
class A11 {
    int a; // (1) 인스턴스변수 - heap area - new - this

    A11() { }

    A11(int a) { this.a     = a; } // (2) 생성자
                인스턴스변수  = 지역변수
    void show()  //(3) 인스턴스메서드 - heap area - new 생성자 - this 각각
    void show() { 
        this.a = 11; 
        System.out.println(this.a); 
    }

    static void classMethod() //(4) 클래스메서드 - method area - new X - 공용
    static void classMethod() { this.a = 12; } // static은 this.a 인스턴스변수 사용불가 

    int showZ() //(5) 인스턴스메서드 
    int showZ() { 
        int a;  // 지역변수 - 수동으로 초기화 int a=0;
        return a; 
    }
}

public class RepeatQ123 {
    public static void main(String []args) { 
        A11 a1 = new A11(); 
        (b) 
    }
} // end class

Q1. 위의 문제에서 (1),(2),(3),(4),(5)를 [ 클래스변수, 인스턴스변수, 지역변수, 클래스메서드, 인스턴스메서드 ]에서 고르시오.

Q2. 클래스 A11에서 오류나는 곳을 수정하고 그 이유를 적으시오.
static void classMethod() { this.a = 12; } / static을 사용하면 this 사용 불가능
int showZ() { 
        int a;  // int a=0; 지역변수 - 수동으로 초기화 
        return a; 
}

Q3. (b)번 위치에서

메모리 빌려오고, 객체 생성하는 역할 : (  new  )
String은 null, int는 0으로 초기화하는 역할 : ( A11() )
new A11()한 주소를 갖고 있는 것은 : ( (참조변수) a1  )

Q4. 기본생성자를 반드시 선언해야하는 경우를 적으시오.
다른 생성자 작성시 , 상속시
Q5. 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오) 
        메서드 이름이 같고 파라미터 타입과 갯수  / c,d
a. 메서드의 이름이 같아야 한다. -> 오버로딩 조건
b. 매개변수의 개수나 타입이 달라야 한다. -> 오버로딩 조건
c. 리턴타입이 달라야 한다.  -> 오버로딩 조건X
d. 매개변수의 이름이 달라야 한다.  -> 오버로딩 조건X A(int brain), A(int money)

Q6. 다형성이란? 
하나의 타입으로 여러 타입의 객체를 관리
              여러 형태를 사용할 수 있는 성질

Q7. 다음코드에서 다음에 해당하는 부분을 작성하시오.

//7-1. 상속도
//7-2. 각 클래스에서 사용할수 있는 멤버변수, 멤버함수
/*
Object
  ↑
Parent7 {x=100 , method()}  Parent
  ↑
Child7  {x=200 , method()}  Child
*/

package com.the703.basic012_ex;

class Parent7  extends Object{
      int x = 100;
      public Parent7() { super(); }
      void method() { System.out.println("Parent Method"); }
} 
class Child7 extends Parent7 {
   int x = 200;
   public Child7() { super(); }
   @Override  void method() { System.out.println("Child Method"); }
}
public class PolyEx002 {
   public static void main(String[] args) {
         Parent7 p = new Child7();     //부모  = 자식 (업캐스팅)
         // 7-3.    Parent7 p   보장하는 범위  
         // 7-4.    인스턴스화 했을때 사용가능한 범위 : new Child7()   
         Child7 c = new Child7();  

         System.out.println("p.x = " + p.x);  // 7-5 출력되는 내용  
         p.method();  //7-6 출력되는 내용    
         
         System.out.println("c.x = " + c.x);   // 7-7  출력되는 내용 
         c.method();   //7-8. 출력되는 내용     
   }
}

