

### ■1.  복습문제  노트+코드작성

■ 1. html + css
```
    1. 레이아웃잡는방법은? (  float  ,  position  ,   display   )
    2. box를 왼쪽, 오른쪽에 붙이는 방법은?  float: left;    float: right;
    3. 다음박스를 왼쪽 오른쪽에 배치하려고 한다. 들어가야하는 코드는?
    <style>
      .left{ float:left; }     .right{ float:right }    .clear{ clear: both; }
    </style>
    <div class="box">
      <div class="left">LEFT</div>
      <div class="right">RIGHT</div>
      <div class="clear">안따라갈려고</div>
    </div>

    4. 다음li를 왼쪽으로 붙이려고한다. 코드는?
    <style>
      ul{overfloow: hidden;}    li{float:left;}
    </style>
    <ul>
      <li>ONE </li><li>TWO</li><li>THREE</li>
    </ul>

    5. 내가 원하는 위치에 top, right, bottom, left 속성을 줘서 원하는 위치에 배치하는 방법은?
     - 부모박스에  ( position:relative; )코드를 사용해   기준점을 잡고
     - 자식콘텐츠로  ( position: absolute; )를 사용해 배치한다.

    6.  스크롤할 때 상단에 계속 붙어 있도록 만드는 방법은?  
    position: sticky; top:0;
```    

■ 2. java
```
1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut
2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut

    char ch='\u0000';
    Scanner scanner =new Scanner(System.in);

    System.out.println("a,b,c 중에 입력 > ");  
    ch = scanner.next().charAt(0);
    
3. for, while, do while 버젼으로  문제를 풀으시오!  
     1  2  3  4  5
```

---

### ■2.  내일 복습문제  
■ 1. html + css (  java는 오후에  eclipse 로  진행합니다    )
```
■ 복습문제  - 빈칸채우기   
    1. 레이아웃을 구성하는 대표적인 방식은 무엇인가?    (  float  ,  position  ,  display    )
    2. 박스를 화면의 왼쪽과 오른쪽에 각각 붙여서 배치하려면 어떤 방법을 사용해야 하는가?
      ① position: absolute
      >> ② float  
      ③ display: inline-block
      ④ margin: auto

    3. 다음li를 왼쪽으로 붙이려고한다. 코드는?
    <style>
      ul { overflow: hidden; }
      li { float: left; }
    </style>
    <ul>
      <li>ONE</li><li>TWO</li><li>THREE</li>
    </ul>

    >> ① li { float: left; }       
    ② li { display: block; }
    ③ li { position: absolute; }
    ④ li { text-align: left; }


    4. 원하는 위치에 요소를 배치하기 위해 top, right, bottom, left 속성을 활용하려고 한다.
    부모 박스에는 어떤 속성을 주어 기준을 설정하는가?
    >> ① position: relative
    ② position: fixed
    ③ display: flex
    ④ margin: auto

    자식 요소에는 어떤 속성을 사용하여 위치를 지정하는가?
    >> ① position: absolute
    ② position: sticky
    ③ float
    ④ inline-block

   5.  브라우저에 고정되도록 만드는 방법은?   position: fixed;
   6.  a태그의 링크를 확대하려고 한다. 사용해야하는 방법은?
   a { display: block; }
   7.  li태그들을 가로방향으로 배치하려고 한다.  width를 줘야하는데 사용해야하는 방법은?
   justify-content: center;
   8.  header 안에서 로고와 내비게이션을 양쪽 끝에 배치하고, 콘텐츠 간 간격을 일정하게 유지하려면 어떤 레이아웃 방식을 사용해야 하는가?
   justify-content: space-between;

```    

■ 2. java
```


1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
   정수를 하나 입력받아 다음 조건에 따라 성적을 출력하는 프로그램을 작성하시오.
    90점 이상 → "A 학점"
    80점 이상 → "B 학점"
    70점 이상 → "C 학점"
    그 외 → "F 학점"

2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
   위의 문제를 switch 로
  
    int avg=0;
    Scanner scanner = new Scanner(System.in);
    System.out.print("평균입력 > ");  avg = scanner.nextInt();
    
3. for, while, do while 버젼으로  문제를 풀으시오!  
    1 2 3

4. 이중 for를 이용해서 다음문제를 풀으시오.
  ★★★★
  ★★★★
  ★★★★
  ★★★★
    
  
```