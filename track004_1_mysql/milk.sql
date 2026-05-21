
-- = MODEL
-- ★ 다음과 같이 테이블을 준비해주세요!
-- mysql> desc milk_order;
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | Field | Type         | Null | Key | Default           | Extra             |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | ono   | int          | NO   | PRI | NULL              | auto_increment    |
-- | oname | varchar(20)  | NO   |     | NULL              |                   |
-- | onum  | int          | NO   |     | NULL              |                   |
-- | odate | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | oip   | varchar(100) | NO   |     | NULL              |                   |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- 5 rows in set (0.00 sec)

-- Q1.  milk_order 값삽입.  insert 구문 완성   
create table milk_order (
 ono   int 			not null primary key auto_increment,
 oname varchar(20) 	not null, 
 onum  int          not null,
 odate datetime  	default   CURRENT_TIMESTAMP,
 oip   varchar(100) not null
 ); 
-- Q2.  milk_order ono가 1인데이터 조회 
select * from  milk_order where ono=1; 
-- Q3.  milk_order 전체데이터조회
select * from  milk_order; 
-- Q4.  milk_order 해당번호의 이름과 갯수 수정
update milk_order set oname='banana' where ono=3;
-- Q5.  milk_order 해당번호의 데이터 삭제
delete from milk_order where ono=1;

use mbasic;   

delete from milk where mno=1;
select * from milk; 
alter table milk modify mnum int null;
alter table milk modify mtotal int null;
insert into milk  values (1,'white',1500,6,9000);
insert into milk  values (2,'choco',1800,10,18000);
insert into milk  values (3,'white',1800,6,10800);
update milk set mname='banana' where mno=3;
desc milk;


select * from  milk_order; 
alter table milk_order modify oip  varchar(100) not null;
desc milk_order;
delete from milk_order where ono=1;
TRUNCATE TABLE milk_order;  --  테이블 데이터 비우기 , auto_increment 초기화