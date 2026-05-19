-- 데이터베이스 언어
-- - DDL : CREATE, ALTER(#), DROP  ->  CAD

-- 1) alter 문법
-- https://dev.mysql.com/doc/refman/8.0/en/table.html

help alter
help alter table;


-- ALTER TABLE 테이블명
--     ADD     추가컬럼명  자료형  옵션    [FIRST | AFTER col_name]
--     DROP    삭제필드명
--     CHANGE  이번필드명  새로운필드명    자료형  옵션
--     MODIFY  수정필드명  자료형  옵션
--     RENAME  새로운 테이블 이름

-- #1) 필드추가
    alter table userinfo add uno   int;
    alter table userinfo add uno2  int first;               
    
    -- 맨앞에
    alter table userinfo add email varchar(100) after name; -- name 뒤에

-- #2) 필드삭제
    alter table userinfo drop uno;
    alter table userinfo drop uno2;   --  ※ uno2 삭제

-- #3) 필드수정(CHANGE) - 필드형, 자료형 옵션 수정
--  > alter table userinfo  change oldname newname 자료형 옵션
 alter table userinfo  change email  email2 varchar(50) ;
 alter table userinfo  change email2  email varchar(50) ;  -- ※ email2 다시 email로 바꾸기

-- #4) 필드수정(MODIFY) - 자료형 옵션 수정  ( add, drop, change | modify )
alter table userinfo modify email varchar(20) not null;
alter table userinfo drop email;

-- #5) 테이블명 수정   ( add, drop, change | modify, rename)
alter table userinfo rename users;

-- 1. 테이블 준비
create table userinfo(
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


-- >>>> 연습문제1)
-- [001]  다음과 같이 테이블을 준비하시오    >> alter_coffee
-- mysql> desc alter_coffee;
-- +--------+-------------+------+-----+---------+-------+
-- | Field  | Type        | Null | Key | Default | Extra |
-- +--------+-------------+------+-----+---------+-------+
-- | cno    | int(11)     | YES  |     | NULL    |       |
-- | cname  | varchar(20) | YES  |     | NULL    |       |
-- | cprice | int(11)     | YES  |     | NULL    |       |
-- +--------+-------------+------+-----+---------+-------+
-- 3 rows in set (0.00 sec)

create table alter_coffee(
    cno     int ,
    cname   varchar(20),
    cprice  int
);

-- > DDL : CREAT, DROP, ALTER
-- > ALTER TABLE 테이블명
--     (추가: add,삭제: drop,수정: change:modify, rename)

-- [002] 다음과 같이 DB와 테이블을 수정하시오  [TABLE명 : alter_coffee] -  ALTER TABLE
-- 연습문제1) cno, cname,cprice필드를 ( not null )으로 수정
alter table alter_coffee 
    modify cno int not null,
    modify cname varchar(20) not null,
    modify cprice int not null;

-- ※ ALTER TABLE alter_coffee change cno cno int not null;
--    alter table alter_coffee modify cno     int not null

-- 연습문제2) 쿠폰필드  cgift    문자열고정(10)  미필수로 추가
alter table alter_coffee add cgift char(10);

-- 연습문제3) 쿠폰필드  cgift를  ccoupon으로 바꾸기
alter table alter_coffee change cgift ccoupon char(10);
alter table alter_coffee2 rename column cgift to ccoupon; ※ rename 버전

-- 연습문제4) 쿠폰필드 ccoupon삭제
alter table alter_coffee drop ccoupon;

-- 연습문제5) cno를 cprice뒤로이동
alter table alter_coffee modify cno     int not null after cprice;
alter table alter_coffee change cno cno int not null after cprice;

-- 연습문제6) cno를 맨위로
alter table alter_coffee modify cno     int not null first;
alter table alter_coffee change cno cno int not null first;

-- 연습문제7) cno를 primary key 추가
alter table alter_coffee modify cno     int not null primary key;
alter table alter_coffee change cno cno int not null primary key;
alter table alter_coffee add    primary key(cno);
alter table alter_coffee drop   primary key;  -- 기본키 삭제

-- 연습문제8) alter_coffee테이블의 이름을 alter_coffee2로 바꾸기
alter table alter_coffee rename alter_coffee2;

-- 연습문제9) 다음과 같이 최종본으로 테이블만들기
alter table alter_coffee2 modify cno int not null auto_increment primary key;

-- mysql> desc alter_coffee2;
-- +--------+-------------+------+-----+---------+----------------+
-- | Field  | Type        | Null | Key | Default | Extra          |
-- +--------+-------------+------+-----+---------+----------------+
-- | cno    | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | cname  | varchar(20) | NO   |     | NULL    |                |
-- | cprice | int(11)     | NO   |     | NULL    |                |
-- +--------+-------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)