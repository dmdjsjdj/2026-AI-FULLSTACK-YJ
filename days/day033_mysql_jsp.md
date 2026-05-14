- Todo1: MYSQL
- Todo2: JSP

### ■1.  복습문제

1.   MySQL은 데이터베이스 관리 시스템(DBMS)이다.
2.  (#1 데이터 )는 수집된 사실이나 값을 의미하고 (#2 정보 )는 의미를 제공하는 데이터를 의미한다.
3. 대표적인 데이터베이스 종류에는 (Oracle, Mysql, MSSql) 등이 있다.
4.  RDBMS는 (Realational) Database Management System의 약자이다.
5. RDBMS의 구성요소는  (개체(entity, table), 관계(relationship) , 속성(attribute: 필드) )
6. 데이터베이스 언어
DDL(  정의어   )  CREATE, ALTER, DROP  -> CAD
DML(  조작어   )  (INSERT, SELECT, UPDATE, DELETE) -> CRUD
DCL(  제어어   )  (GRANT, REVOKE) 

7. 데이터베이스  mbasic, 를 생성하는 SQL 명령어를 작성하시오.
create database mbasic;

8.  생성된 데이터베이스 목록을 확인하는 SQL 명령어를 작성하시오.
show databases;

9. 데이터베이스 db703을 삭제하는 SQL 명령어를 작성하시오.
drop database db703;

---

### ■2. Todo1: MYSQL

1) WEB BASIC - HTML + CSS + JS ( 화면단 )
2) JAVA ( 프로그래밍 )
3) MYSQL/ORACLE (DB)
4) JSP (Html+Java)

#### TABLE
#### ALTER


---

### ■3. Todo2: JSP

1. 클라이언트 ↔ 서버
2. WS  VS  WAS

>> track005_jsp > jsp2026.md

---

### ■4.  복습문제

1.  데이터베이스 언어
-- DDL(  정의어   )  CREATE, ALTER, DROP 
-- DML(  조작어   )  INSERT, SELECT, UPDATE , DELETE
-- DCL(  제어어   )  GRANT, REVOKE


2. 다음과 같이 테이블준비
-- DB명     : mbasic    
-- 테이블명: userinfo
-- 필드1 -  필수입력 no    ,  숫자자동증가, 기본키      정수형
-- 필드2 -  필수입력  name  가변형문자열(100)
-- 필드3 -  필수입력  age      정수형
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)


3. 다음을 수정  
-- 1. 이메일 필드 추가(add)       email varchar(100)
-- 2. 이메일 필드 수정(change)   email을 email2로  자료형은 varchar(50) 으로 
-- 3. 이메일 필드 수정(modify)   email을 email2로  자료형은 varchar(50) 으로 
-- 4. 이메일 필드 삭제(drop)   