### ■1.  복습문제

> 복습문제
 다음의 결과가나오게 조회하시오.
-- emp 테이블에서
-- 추가수당(comm) 이 없고
-- 상급자(mgr)은 존재하며
-- 직책(JOB) 'MANAGER', 'CLERK' 중에서
-- 사원이름(ename)의 두번째 글자가 L이아닌
-- 사원데이터를  조회하시오

---

### ■2. Todo1: MYSQL




---

### ■3. Todo2: JSP


---

### ■4.  복습문제


복습문제1) 
1. 다음과 같이 테이블을 작성하는 코드를 적으시오.
create table userinfo (
    no int not null primary key auto_increment,
    name varchar(100) not null,
    age int not null
);
-- mysql> desc userinfo;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)

2. 마지막에 5, five, 50을  insert하는 코드를 작성하시오.
insert userinfo values (5, 'five', 50);
3. no가 5인 데이터의 5, five, 55로  수정하는 코드를 작성하시오. 
update   userinfo set age=55 where no=5;
4. no가 5인 데이터를 삭제하는 코드를 작성하시오. 
delete from userinfo where no=5;
5. 다음과 같이 나이를 오름차순으로 정렬하는 코드를 작성하시오.
select * from userinfo order by age asc;

-- mysql> select * from userinfo_re1;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+--------+-----+

복습문제2)  
1.  jdbc 연동을 하려고한다.   드라이버로딩시 사용되는 코드는? 
Class.forName()

2.  DriverManager를 이용해서 url, root, pass를 이용해서 Connection을 만들려고할때 사용되는 코드는?
Connection conn = DriverManager.getConnection("url","root","pass");

3.  PreparedStatement를 이용해서 sql을 실행하려고할때  insert, update, delete 에서 사용되는 코드는?
PreparedStatement pstmt = conn.prepareStatement("");
pstmt.executeUpdate();

4.  PreparedStatement를 이용해서 sql을 실행하려고할때  select   에서 사용되는 코드는?
PreparedStatement pstmt =null;	ResultSet rset = null;
pstmt = conn.prepareStatement("select * from 테이블");
rset = pstmt.executeQuery();

5.  jdbc의 주의사항은? 항상  (  close()   )를 해야한다.
