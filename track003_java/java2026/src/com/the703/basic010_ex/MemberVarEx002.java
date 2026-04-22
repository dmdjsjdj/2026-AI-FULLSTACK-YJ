package com.the703.basic010_ex;

//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기

class Student {
    String name = "홍길동";       // 인스턴스 변수  new  heap area 생성자 관련  this
     int kor = 90;              // 인스턴스 변수  new  heap area 생성자 관련  this
     int eng = 85;              // 인스턴스 변수  new  heap area 생성자 관련  this
    static int studentCount = 0;    //클래스변수 static method area 공용 클래스명.변수

//    static int total = kor + eng;   //클래스변수 인스턴스변수 (static은 인스턴스 사용불가 - 오류남

    static int maxScore = 100;     //클래스변수  static method area 공용 클래스명.변수

    public Student() {  //인스턴스메서드  (static X)
        studentCount++;             
    }

    public int getTotalScore() {  //인스턴스메서드  (static X)
        return kor + eng;        
    }

    public static void showStudentCount() {  //클래스메서드 (static O)
        System.out.println("전체 학생 수: " + studentCount);  
    }

   public  void showName() {  //인스턴스메서드  (static X)
         System.out.println(name);  
   }

    public void showInfo() {  //인스턴스메서드  (static X)
        System.out.println("이름: " + name);            
        System.out.println("총점: " + getTotalScore());    
    }
}

public class MemberVarEx002 {
    public static void main(String[] args) {
        Student s1 = new Student();     
        Student s2 = new Student();     

        s1.showInfo();                  
        Student.showStudentCount();    
    }
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------
[METHOD:정보]	Student.class(설계도) , 		MemberVarEx002.class#1
	Student.studentCount = 0;  Student.maxScore = 100;  Student.showStudentCount()
------------------------------------------------------------
[HEAP:동적]           											  		  |  [STACK:지역]
1번지 {name = "홍길동",kor = 90, eng = 85, Student(),showName(),showInfo()}	  ←  s1[1번지]
												 					 		 main#2
------------------------------------------------------------
*/
//////////////////////////////////////////////////////
/*
패키지명 : com.company.java010_ex
클래스명 : MemberVarEx002

-- class Student 작성해주세요

- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
- 문제 3. 오류가 발생하는 이유를 설명하시오.
- 문제 4. runtime data area 위치영역 그림그리기

class Student {
    String name = "홍길동";        
    int kor = 90;                  
    int eng = 85;                 
    static int studentCount = 0;    

    static int total = kor + eng;   

    static int maxScore = 100;     

    public Student() {
        studentCount++;             
    }

    public int getTotalScore() {
        return kor + eng;        
    }

    public static void showStudentCount() {
        System.out.println("전체 학생 수: " + studentCount);  
    }

   public static void showName() {
         System.out.println(name);  
   }

    public void showInfo() {
        System.out.println("이름: " + name);            
        System.out.println("총점: " + getTotalScore());    
    }
}

public class MemberVarEx002 {
    public static void main(String[] args) {
        Student s1 = new Student();     
        Student s2 = new Student();     

        s1.showInfo();                  
        Student.showStudentCount();    
    }
}
 */

