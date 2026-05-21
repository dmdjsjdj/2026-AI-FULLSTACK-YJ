-- 1. CRUD (SELECT 복습문제)
-- 2. CRUD (SELECT Function-Number)
-- 3. CRUD (SELECT Function-Number 연습문제)
-- 4. CRUD (SELECT Function-String)
-- 5. CRUD (SELECT Function-String 연습문제)
-- ________________________________________________________________
-- ________________________________________________________________


-- ■ 진행1. CRUD (SELECT 복습문제)
use mbasic;
-- Q1. 다음과 같이 테이블을 작성하시오  ( 있다면 pass)
-- mysql> desc userinfo_select;
desc userinfo;
select * from userinfo;
create table userinfo_select select * from userinfo; -- where 1=2 추가하면 구조만 복사해서 가져옴
select * from userinfo where 1=2;  -- 1=2 해당값 x, 구조만 출력됨
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.01 sec)

-- Q2. userinfo 테이블을 다음과 같이 수정하시오.
-- mysql> desc userinfo_select;
							-- add, drop, change/modify/rename
alter table userinfo_select modify no int not null primary key auto_increment;
desc userinfo_select;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | YES  |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.01 sec)


-- Q3. 다음과 같이 데이터가 있다
--  AFTER와 같이 데이터를 추가하시오.
-- >> BEFORE)
-- mysql> select * from userinfo_select;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  NULL|
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- +----+--------+-----+
-- 6 rows in set (0.01 sec)
select * from userinfo_select;
SET SQL_SAFE_UPDATES=0;  -- 여러줄 안전삭제 옵션 끄기
delete from userinfo_select where no>=4;

-- >> AFTER)
-- mysql> select * from userinfo_select;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  NULL |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+--------+-----+
-- 6 rows in set (0.01 sec)
update userinfo_select set age=null where no=1;
insert into userinfo_select values (4,'fourth',44);

select * from userinfo_select;
-- Q4. 이름이 fourth 이고 age가 44인데이터의 no를 10으로 수정하시오.
update userinfo_select set no=10 where age=44;
-- Q5. no가 10인데이터를 삭제하시오.
delete from userinfo_select where no=10;
-- Q6. 나이가 많은순으로 2명을 검색하시오.
select *
from userinfo_select
order by age desc
limit 2;
-- Q7. 나이가 NULL이 아니고
--     no가 2또는 3중에서
--     이름의 두번째 글자가 e가아닌 데이터를 조회하시오
select *
from userinfo_select
where age is not null and (no =2 or no=3) and name not like '_e%';

-- Q8.  emp 테이블에서 GROUP BY절만  사용하여
-- -- 각부서의 직책별 사원수, 가장높은 급여, 급여합, 평균급여를  다음과 같이  사원데이터를  조회하시오.
desc emp;
select deptno, job, count(*) `사원수`, max(sal), sum(sal), avg(sal)
from emp
group by  deptno, job
order by  deptno, job asc;

-- >> 결과
-- +--------+-----------+--------+----------+--------+-----------+
-- | deptno | job       | 사원수   | 최고급여   | 급여합   | 평균급여   |
-- +--------+-----------+--------+----------+--------+-----------+
-- |     10 | CLERK     |      1 |     1300 |   1300 | 1300.0000 |
-- |     10 | MANAGER   |      1 |     2450 |   2450 | 2450.0000 |
-- |     10 | PRESIDENT |      1 |     5000 |   5000 | 5000.0000 |
-- |     20 | ANALYST   |      2 |     3000 |   6000 | 3000.0000 |
-- |     20 | CLERK     |      2 |     1100 |   1900 |  950.0000 |
-- |     20 | MANAGER   |      1 |     2975 |   2975 | 2975.0000 |
-- |     30 | CLERK     |      1 |      950 |    950 |  950.0000 |
-- |     30 | MANAGER   |      1 |     2850 |   2850 | 2850.0000 |
-- |     30 | SALESMAN  |      4 |     1600 |   5600 | 1400.0000 |
-- +--------+-----------+--------+----------+--------+-----------+
-- 9 rows in set (0.00 sec)


-- >> 주어진조건
-- mysql> desc emp;
-- +----------+-------------+------+-----+---------+----------------+
-- | Field    | Type        | Null | Key | Default | Extra          |
-- +----------+-------------+------+-----+---------+----------------+
-- | empno    | int         | NO   | PRI | NULL    | auto_increment |
-- | ename    | varchar(20) | YES  |     | NULL    |                |
-- | job      | varchar(20) | YES  |     | NULL    |                |
-- | mgr      | int         | YES  |     | NULL    |                |
-- | hiredate | date        | YES  |     | NULL    |                |
-- | sal      | int         | YES  |     | NULL    |                |
-- | comm     | int         | YES  |     | NULL    |                |
-- | deptno   | int         | NO   |     | NULL    |                |
-- +----------+-------------+------+-----+---------+----------------+
-- 8 rows in set (0.00 sec)



-- ■ 진행2. CRUD (SELECT Function-Number)
-- >> 데이터베이스언어
-- DDL  : create, alter , drop
-- DML : insert, select # , update, delete
-- DCL  : grant, revoke


-- ==========================
-- #1. Number
-- 1.   ceil     올림
-- 2.   floor   내림
-- 3.   round 반올림
-- 4.   mod(숫자 , 나눌 수)   나머지 연산자

-- = BASIC 
-- +-----------+------------+------------+-----------+
-- | ceil(1.1) | floor(1.9) | round(1.5) | mod(10,3) |
-- +-----------+------------+------------+-----------+
-- |         2 |          1 |          2 |         1 |
-- +-----------+------------+------------+-----------+
-- 1 row in set (0.01 sec)

-- mysql>




-- ■ 진행3. CRUD (SELECT Function-Number 연습문제)

-- EX1    123.4578을 ROUND를 이용하여 다음과 같이 출력하시오.
-- +----------+--------+--------+--------+--------+
-- | 123.4578 | ROUND1 | ROUND2 | ROUND3 | ROUND4 |
-- +----------+--------+--------+--------+--------+
-- | 123.4578 |    123 |    120 |  123.5 | 123.46 |
-- +----------+--------+--------+--------+--------+
-- 1 row in set (0.00 sec)


-- EX2  다음과 같이 출력하시오.
-- +----------+------+-------+
-- | 123.4578 | CEIL | FLOOR |
-- +----------+------+-------+
-- | 123.4578 |  124 |   123 |
-- +----------+------+-------+
-- 1 row in set (0.00 sec)



-- ■ 진행4. CRUD (SELECT Function-String)
-- #2. String
-- length
-- upper / lower

-- instr( 문자열, 찾을 문자열 ) - 위치
-- substr( 문자열, 시작, 갯수 )  - 문자열일부분 추출
-- left( 문자열, 갯수)
-- right( 문자열, 갯수)

-- concat ( 문자열, 문자열 ) - 문자열연결

-- trim()  - ltrim, rtrim  공백제거
-- replace (문자열, 찾아서, 바꾸기)
-- repeat (문자열, 몇번)

-- lpad(문자열, 전체자리수, 특정문자)
-- rpad(문자열, 전체자리수, 특정문자)


-- = BASIC
-- mysql> -- 1. length(문자열) 
-- +---------------+
-- | length('abc') |
-- +---------------+
-- |             3 |
-- +---------------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 2. upper/lower 
-- +---------+------+------+
-- | DEFAULT | s1   | s2   |
-- +---------+------+------+
-- | ABC     | ABC  | abc  |
-- +---------+------+------+
-- 1 row in set (0.01 sec)

-- mysql>
-- mysql>
-- mysql> -- 3. 찾기1 - 위치  instr  
-- +----------+-----------+-----------+
-- | b의 위치 | ab의 위치 | ac의 위치 |
-- +----------+-----------+-----------+
-- |        2 |         1 |         0 |
-- +----------+-----------+-----------+
-- 1 row in set (0.00 sec)


-- mysql> -- 4.   찾기 2 - 문자열 left, right, substr 
-- +------+------+------+------+
-- | l1   | l2   | r1   | r2   |
-- +------+------+------+------+
-- | a    | ab   | c    | bc   |
-- +------+------+------+------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 5. 찾기 3  - substr 
-- +------+------+------+
-- | s1   | s2   | s3   |
-- +------+------+------+
-- | bc   | bcd  | abc  |
-- +------+------+------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql>
-- mysql> -- 6. 문자열 연결   - concat 
-- +--------------------------+
-- | concat('choco' , 'milk') |
-- +--------------------------+
-- | chocomilk                |
-- +--------------------------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 7. 공백빼기 - trim 
-- +-----------------+
-- | trim(' a b c ') |
-- +-----------------+
-- | a b c           |
-- +-----------------+
-- 1 row in set (0.00 sec)

-- mysql> 
-- +---------+----------+----------+
-- | t1      | t2       | t3       |
-- +---------+----------+----------+
-- | #a b c# | #a b c # | # a b c# |
-- +---------+----------+----------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 8. 찾아서 바꾸기 - replace 
-- +--------------------------------------+
-- | replace('hello sally' , 'sally','a') |
-- +--------------------------------------+
-- | hello a                              |
-- +--------------------------------------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 9. 반복 repeat 
-- +---------------+
-- | repeat('*',5) |
-- +---------------+
-- | *****         |
-- +---------------+
-- 1 row in set (0.00 sec)

-- mysql> -- 10. 빈칸채우기 
-- +----------------------+----------------------+
-- | lpad('ABC' , 5, '#') | rpad('ABC' , 5, '#') |
-- +----------------------+----------------------+
-- | ##ABC                | ABC##                |
-- +----------------------+----------------------+
-- 1 row in set (0.00 sec)

-- mysql>





-- ■ 진행5. CRUD (SELECT Function-Number 연습문제)

-- mysql> desc fn_select_userinfo2;
-- +-------+-------------+------+-----+---------+-------+
-- | Field | Type        | Null | Key | Default | Extra |
-- +-------+-------------+------+-----+---------+-------+
-- | no    | int         | NO   |     | 0       |       |
-- | name  | varchar(20) | NO   |     | NULL    |       |
-- | age   | int         | NO   |     | NULL    |       |
-- | email | varchar(20) | NO   |     | NULL    |       |
-- +-------+-------------+------+-----+---------+-------+
-- 4 rows in set (0.01 sec)

-- mysql> select * from fn_select_userinfo2;
-- +----+------+-----+---------------+
-- | no | name | age | email         |
-- +----+------+-----+---------------+
-- |  1 | aaa  |  11 | aaa@gmail.com |
-- |  2 | bbb  |  22 | bbb@gmail.com |
-- |  3 | ccc  |  33 | ccc@gmail.com |
-- |  4 | ddd  |  44 | ddd@gmail.com |
-- |  5 | abc  |  55 | abc@gmail.com |
-- |  6 | bca  |  66 | bca@gmail.com |
-- +----+------+-----+---------------+
-- 6 rows in set (0.00 sec)

-- mysql>


-- 1. 유저의 이름의 글자수를 조회하시오.
-- +------+------+
-- | 이름 | 갯수 |
-- +------+------+
-- | aaa  |    3 |
-- | bbb  |    3 |
-- | ccc  |    3 |
-- | ddd  |    3 |
-- | abc  |    3 |
-- | bca  |    3 |
-- +------+------+
-- 6 rows in set (0.00 sec)

-- 2. 유저의 이름과 이름의  첫번째 글자 , 마지막글자 를 조회하시오. (left, right)
-- +------+-------------+------------+
-- | name | 첫번째 글자 | 마지막글자 |
-- +------+-------------+------------+
-- | aaa  | a           | a          |
-- | bbb  | b           | b          |
-- | ccc  | c           | c          |
-- | ddd  | d           | d          |
-- | abc  | a           | c          |
-- | bca  | b           | a          |
-- +------+-------------+------------+
-- 6 rows in set (0.00 sec)


-- 3. 유저이름의 aaa인 유저를 찾아서 'aaa 1등'으로 변경하시오.
-- +------+-----------------------------------+
-- | name | replace( name, 'aaa' , 'aaa 1등') |
-- +------+-----------------------------------+
-- | aaa  | aaa 1등                           |
-- | bbb  | bbb                               |
-- | ccc  | ccc                               |
-- | ddd  | ddd                               |
-- | abc  | abc                               |
-- | bca  | bca                               |
-- +------+-----------------------------------+
-- 6 rows in set, 1 warning (0.00 sec)

-- mysql>
-- mysql>

-- 4. 다음과 같이 직업을 출력하시오.   (concat)
-- +---------------------+
-- | 직업                |
-- +---------------------+
-- | aaa는 개발자입니다. |
-- | bbb는 개발자입니다. |
-- | ccc는 개발자입니다. |
-- | ddd는 개발자입니다. |
-- | abc는 개발자입니다. |
-- | bca는 개발자입니다. |
-- +---------------------+
-- 6 rows in set, 1 warning (0.00 sec)


-- 5. 이름을 대문자로 조회하시오.
-- +-------------+
-- | upper(name) |
-- +-------------+
-- | AAA         |
-- | BBB         |
-- | CCC         |
-- | DDD         |
-- | ABC         |
-- | BCA         |
-- +-------------+
-- 6 rows in set (0.00 sec)

--  6. 이름을 소문자로 조회하시오.
-- +-------------+
-- | lower(name) |
-- +-------------+
-- | aaa         |
-- | bbb         |
-- | ccc         |
-- | ddd         |
-- | abc         |
-- | bca         |
-- +-------------+
-- 6 rows in set (0.00 sec)

-- 7. 나이가 40대이상의 유저의 이름과 b의 위치를  조회하시오. (instr)
-- +------+-----------------+
-- | name | instr(name,'b') |
-- +------+-----------------+
-- | ddd  |               0 |
-- | abc  |               2 |
-- | bca  |               1 |
-- +------+-----------------+
-- 3 rows in set (0.03 sec)

-- 8. [upgrade] 나이가 40대이상의 유저의 이름과 b의 위치를  조회시 나이 많은 순으로 2분을 조회하시오(instr)
-- +------+-----------------+
-- | name | instr(name,'b') |
-- +------+-----------------+
-- | bca  |               1 |
-- | abc  |               2 |
-- +------+-----------------+
-- 2 rows in set (0.02 sec)



-- 9. [upgrade] 유저의 이름과 이름의  첫번째 글자 , 마지막글자 를 조회하시오.
-- +------+------+
-- | name | test |
-- +------+------+
-- | aaa  | a*a  |
-- | bbb  | b*b  |
-- | ccc  | c*c  |
-- | ddd  | d*d  |
-- | abc  | a*c  |
-- | bca  | b*a  |
-- +------+------+
-- 6 rows in set (0.00 sec)

-- mysql>

-- 10. 테이블 select_userinfo복사해서 한개더 만들기
-- mysql> select * from select_userinfo2;
-- +----+-------+-----+---------------+
-- | no | name  | age | email         |
-- +----+-------+-----+---------------+
-- |  1 | aaaa  |  11 | aaa@gmail.com |
-- |  2 | bbaab |  22 | bbb@gmail.com |
-- |  3 | ccaac |  33 | ccc@gmail.com |
-- |  4 | daadd |  44 | abc@gmail.com |
-- |  5 | abc   |  55 | abc@gmail.com |
-- |  6 | baaca |  66 | bca@gmail.com |
-- +----+-------+-----+---------------+
-- 6 rows in set (0.00 sec)


-- +-------+-------+
-- | name  | test  |
-- +-------+-------+
-- | aaaa  | a**a  |
-- | bbaab | b***b |
-- | ccaac | c***c |
-- | daadd | d***d |
-- | abc   | a*c   |
-- | baaca | b***a |
-- +-------+-------+







