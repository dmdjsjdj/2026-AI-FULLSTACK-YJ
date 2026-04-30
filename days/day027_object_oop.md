

### ■1.  복습문제

<!-- eclipse에서 -->
## 📝 문제: OOP 개념(1)

다음 코드를 보고 질문에 답하시오.
Q1. OOP란 무엇인가?
Q2. OOP의 핵심 개념은 무엇인가?
Q3. 상속도를 그리시오.
Q4. 각 객체에서 사용할 수 있는 멤버변수와 메서드를 적으시오.
Q5. Parent p = new Child(); 실행 시 객체 생성, 초기화, 참조값을 설명하시오.
Q6. Parent 클래스의 멤버변수/메서드의 종류와 메모리 구조를 설명하시오.
Q7. 출력 결과를 쓰시오.
- p.x의 값은?  
- p.method() 실행 시 어떤 메서드가 호출되는가?  
- c.x의 값은?  
- c.method() 실행 시 어떤 메서드가 호출되는가?

Q8. @Override 키워드의 의미와 코드에서 오버라이딩된 부분을 설명하시오.
Q9. Child c = new Child(); 호출 시 생성자 호출 순서와 객체 생성 순서를 설명하시오.


 
class Parent {
    int x = 100;
    void method() { System.out.println("Parent method"); }
}

class Child extends Parent {
    int x = 200;
    void method() { System.out.println("Child method"); }
}

public class Repeat001_oop {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }
}

---

part1. 제어문-절차지향
part2. OOP  -객체지향 특징 (클래스)
   2-1. 클래스 사용  ( 클래스 vs 객체 )
   2-2. 클래스 설정  ( static, final, public ■캡슐화 )
   2-3. 클래스 ■상속 ( 재활용 )
   2-4. ■다형성 ( 부모타입으로 자식타입들 관리 )
   2-5. ■추상화 ( 공통적인 속성 뽑기 )
part3. OOP  -활용
   1. 콜렉션프레임워크
   2. lambda + stream
   3. io
   4. network (Thead)    


---

### ■2.  Todo1: java  method



---

### ■3.  Todo2: java  method


---

### ■4.  복습문제

