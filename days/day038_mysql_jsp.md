### ■1.  복습문제

■ 진행1. CRUD (SELECT 복습문제)

Q1. 다음과 같이 테이블을 작성하시오  ( 있다면 pass)
mysql> desc userinfo_select;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.01 sec)



Q2. userinfo 테이블을 다음과 같이 수정하시오.
mysql> desc userinfo_select;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | YES  |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.01 sec)





Q3. 다음과 같이 데이터가 있다
 AFTER와 같이 데이터를 추가하시오.
>> BEFORE)
mysql> select * from userinfo_select;
+----+--------+-----+
| no | name   | age |
+----+--------+-----+
|  1 | first  |  NULL|
|  2 | second |  22 |
|  3 | third  |  33 |
+----+--------+-----+
6 rows in set (0.01 sec)

>> AFTER)
mysql> select * from userinfo_select;
+----+--------+-----+
| no | name   | age |
+----+--------+-----+
|  1 | first  |  NULL |
|  2 | second |  22 |
|  3 | third  |  33 |
|  4 | fourth |  44 |
+----+--------+-----+
6 rows in set (0.01 sec)

Q4. 이름이 fourth 이고 age가 44인데이터의 no를 10으로 수정하시오.

Q5. no가 10인데이터를 삭제하시오.

Q6. 나이가 많은순으로 2명을 검색하시오.

Q7. 나이가 NULL이 아니고
    no가 2또는 3중에서
    이름의 두번째 글자가 e가아닌 데이터를 조회하시오


Q8.  emp 테이블에서 GROUP BY절만  사용하여
-- 각부서의 직책별 사원수, 가장높은 급여, 급여합, 평균급여를  다음과 같이  사원데이터를  조회하시오.

>> 결과
+--------+-----------+--------+----------+--------+-----------+
| deptno | job       | 사원수   | 최고급여   | 급여합   | 평균급여   |
+--------+-----------+--------+----------+--------+-----------+
|     10 | CLERK     |      1 |     1300 |   1300 | 1300.0000 |
|     10 | MANAGER   |      1 |     2450 |   2450 | 2450.0000 |
|     10 | PRESIDENT |      1 |     5000 |   5000 | 5000.0000 |
|     20 | ANALYST   |      2 |     3000 |   6000 | 3000.0000 |
|     20 | CLERK     |      2 |     1100 |   1900 |  950.0000 |
|     20 | MANAGER   |      1 |     2975 |   2975 | 2975.0000 |
|     30 | CLERK     |      1 |      950 |    950 |  950.0000 |
|     30 | MANAGER   |      1 |     2850 |   2850 | 2850.0000 |
|     30 | SALESMAN  |      4 |     1600 |   5600 | 1400.0000 |
+--------+-----------+--------+----------+--------+-----------+
9 rows in set (0.00 sec)


>> 주어진조건
mysql> desc emp;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| empno    | int         | NO   | PRI | NULL    | auto_increment |
| ename    | varchar(20) | YES  |     | NULL    |                |
| job      | varchar(20) | YES  |     | NULL    |                |
| mgr      | int         | YES  |     | NULL    |                |
| hiredate | date        | YES  |     | NULL    |                |
| sal      | int         | YES  |     | NULL    |                |
| comm     | int         | YES  |     | NULL    |                |
| deptno   | int         | NO   |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
8 rows in set (0.00 sec)

---

### ■2. Todo1: MYSQL




---

### ■3. Todo2: JSP


---

### ■4.  복습문제

복습문제 
Q1) 다음 form 태그를 완성하시오.
1. 처리해줄경로              :  result.jsp
2. 주소표시창줄 노출여부 o
3. 쿼리스트링으로 해서 넘길때 이름  userage
>> [ 문제 답 ]
     <form action="[result.jsp]" method="[get]" onsubmit="return check()">
      <div class="my-2">
         <label for="userage">나이입력</label> 
         <input type="text" class="form-control" placeholder="" 
                id="userage" name="[userage]" />
         <button type="submit" class="btn btn-success mt-3 d-block">성인여부</button>
      </div>
    </form>

Q2. 다음과 같이 처리
1. 위의폼      jsp013_implicit.jsp (나이입력받는폼)
2. 처리         result.jsp  처리
                             19세 미만이라면 -   c.jsp    (경로가 바뀜) 
                             19세 이상이라면 -   보여주는 주소표시창줄은   result.jsp   /  보이는화면은   a.jsp      
<%
//1.  나이 넘어오는데이터 확인  (getParameter)
[int age = Integer.parseInt(request.getParament("userage"));]
//2.  만약 19세 미만이라면 c.jsp 파일 넘기기 (sendRedirect)
[if(age<19){ response.sendRedirect("c.jsp"); }]
//    아니라면           a.jsp (경로 안보이게 숨기기 - dispatch 이용)
[else if { request.getRequestDispatch("a.jsp").forward(request, response);}]
%>
