

### ■1. 복습문제

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

---

### ■2. Todo1: CSS기본

- 6. block vs line
Q) a 태그에 margin 적용 x, text-align 적용 x , width x

The display: inline property prevents width from having an effext.
Try setting display ti something other than inline.

display:block   박스( 냄비 )                  - width o, 줄바꿈 o
        예) div, p, pre

display:inline  박스 안에 내용물(국물, 무, 갈치) - width x(△), 줄바꿈 x
        예) img, a, span, strong


- 7. css(2)  내부적용 / id vs class
css 적용방법
1) 인라인 스타일   - 태그안에 직접 적용 

```html
<p style="color:red">color</p>
```

2) 내부 스타일 시트 - head 안에 style을 사용해 작성

```html
<style> p{ color:red; } </style>
```
 
3) 외부 스타일 코드


---

### ■3. Todo2: java 자료형2
1. 형변환
2. 자료형 - char

---

### ■4. 복습문제

> 정리문제 (1)
1. 배경을 파란색으로 설정하는 속성은?            background-color: blue
2. 글자색상을 빨간색으로 지정하는 속성은?         color:red
3. 글자 크기를 20px로 지정하는 속성은?          font-size:20px
4. 글자를 가운데 정렬하는 속성은?               font-align: center
5. 글자에 밑줄을 추가하는 속성은?               text-decoration: underline
6. 글꼴을 Arial로 지정하는 속성은?              font-family:'Arial'
7. 글자를 굵게 표시하는 속성은?                 text-weight 
8. 요소의 가로 길이를 300px로 지정하는 속성은?   width:300px
9. 요소의 바깥쪽 여백을 10px로 지정하는 속성은?  margin:10px
10. 요소의 안쪽 여백을 15px로 지정하는 속성은?   padding:15px
11. 요소에 1px 실선 테두리를 추가하는 속성은?    border:1px solid 색상
12. 모서리를 둥글게 10px로 만드는 속성은?       border-radius:10px
13. 그림자 효과를 추가하는 속성은?              box-shadow
14. 천천히 움직이는 장면전환효과를 주는 속성은?   transition: all 2s;

> 정리문제 (2)
15.  가로 사이즈 지정가능한것은 block o  /    inline x(△)
16.  a태그에 margin-top 줄수   x
17.  css 적용방법 3가지 
(    인라인   /   내부   /   외부   )
( 태그에 직접  /  내부적용방법(head 안에 style태그 작성) / 외부적용방법(별도의 .css파일 작성)  )
18.  css 적용 내부적용방법은 ( head  ) 태그안에 ( style ) 태그 적용해서 사용

> 정리문제 (3)
1.  연산자의 우선순위를 적으시오.
 먼저   값               비교                조건         대입
 ()     ++ -- + - * / %   < > <= >= == !=    && || ?:    =
2.  다음오류 해결
short sh1 = 1 , sh2=2;
short result = int (sh1 + sh2);

3. 필수조건
int x = 3, char ch = '\u0000';

q1-1 int형 변수 x가 3보다 크고 10보다 작을때 true인 조건식 
System.out.println( x > 3 && x < 10 );

q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식  
System.out.println( ch == 'a' || ch == 'A' );

q1-3 char형 변수 ch가 숫자('0'~'9')일때   true인 조건식     
System.out.println( ch >= 0 && ch <= 9 );

q1-4 char형 변수 ch가 영문자(대문자 또는 소문자) 일때   true인 조건식
System.out.println( ch >= 'A' && ch >= 'Z' || ch >= 'a' && ch >= 'z' );
