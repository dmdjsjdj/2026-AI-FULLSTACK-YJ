

### ■1. 복습문제  -  노트 준비
- 1. html/css/js 역할
  - 1) html :  구조
  - 2) css  :  꾸미기
  - 3) js   :  동작

- 2. 태그
 - <> </> : 브라우저에게 명령
 - div    : 영역
 - h      : 제목, 1~6
 - p      : 문단
 - pre    : 문단 - 줄바꿈 인식
 - img    : 이미지, src="경로" , alt="설명"
 - a      : 링크, href="경로" , title="설명"

- 3. java
  1. 자바의 자료형 분류 (기본형/참조형)
  2. 기본형  : 값
  2-1 논리형 : boolean - true/false
  2-2 정수형 : (byte-short-int★-long(L) / 1,2,3 / 1-2-4-8)
	2-3 실수형 : (float(f)-double★ /3.14 / 4-8)   %.2f

---

### ■2. Todo1: CSS기본
 - 5. css(1)
 1. 배경 : background
 2. 글자 : color
 3. 글자크기 : font-size
 4. 정렬 : text-align
 5. 밑줄 : text-decoration
 6. 글꼴 : font-family
 7. 굵게 : font-weight
 8. 가로 : width
 9. 바깥쪽여백 : margin
 10. 안쪽여백 : padding
 11. 선 : border
 12. 둥근모서리 : border-raidus
 13. 그림자효과 : box-shadow

---

### ■3. Todo2: java 자료형2/연산자/제어문?

자료형2

---

### ■4. 복습문제

- 1. css(1)
1. 배경 :  background-color
2. 글자 :  color
3. 글자크기 :  font-size
4. 정렬 :  text-align
5. 밑줄 :  text-decoration
6. 글꼴 :  font-family
7. 굵게 :  font-weight
8. 가로 :  width
9. 바깥쪽여백:  margin
10. 안쪽여백:  padding
11. 선 : border
12. 둥근모서리 : border-radius
13. 그림자효과 :  box-shadow

- 2. java
  1. 자바의 자료형 분류(  기본형 / 참조형  )
  2. 기본형 : 값
    2-1 논리형 : 예) boolean  - true/false (1byte)   
    2-2 정수형 :  byte - short - int - long (1-2-4-8L)
    2-3 실수형 :  float - double (4f-8)
    2-4 문자형 :  char
  3. 자동형변환은 (  boolean  )  빼고  (  
     byte < short / char < int < iong < float < double
    ) 기본형


- 3. java [실습]
패키지명 : com.company.java003_ex
클래스명 : CastingEx001
출력내용 :  Scanner이용해서 나누기 프로그램만들기 
   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
   
   10 / 3 = 3.33

주어진조건 : 
      //변수
      int num1, num2;
      double result;
      Scanner scanner = new Scanner(System.in);

      System.out.println("숫자입력1> );