## 1.  oraclce

1. table - oracle
1) 테이블
--SQL> desc  sboard2;
-- 이름                                         널?      유형
-- ----------------------------------------- -------- ----------------------------
-- ID                                        NOT NULL NUMBER
-- APP_USER_ID                          NOT NULL NUMBER
-- BTITLE                                   NOT NULL VARCHAR2(1000)
-- BCONTENT                             NOT NULL CLOB
-- BPASS                                   NOT NULL VARCHAR2(255)
-- BFILE                                                   VARCHAR2(255)
-- BHIT                                                    NUMBER
-- BIP                                       NOT NULL VARCHAR2(255)
-- CREATED_AT                                          DATE

create table sboard2(
 ID               NUMBER            NOT NULL ,
 APP_USER_ID      NUMBER            NOT NULL ,
 BTITLE           VARCHAR2(1000)    NOT NULL ,
 BCONTENT         CLOB              NOT NULL ,
 BPASS            VARCHAR2(255)     NOT NULL ,
 BFILE            VARCHAR2(255)   default 'the703.png',
 BHIT             NUMBER          default 0 ,
 BIP              VARCHAR2(255)     NOT NULL ,
 CREATED_AT       DATE            default sysdate
 );

create sequence  sboard2_seq; 

2. dto
3. dao - mapper( mybatis )
위의 테이블보고
1) crud
insert
-- 전체 insert
 insert into Sboard2 (ID                 , APP_USER_ID, BTITLE , BCONTENT      , BPASS  , BFILE     , BIP)
  values            (sboard2_seq.nextval , 1           ,  'Hi'  , 'test content', '1234' , 'test.png', '123');

-- 전체 select (페이징)
 select * from Sboard2 order by id desc;

-- mysql ( oracle에선 동작안함 )
 select * from Sboard2 order by id desc limit 0, 10;

-- 해당번호의 select
 select * from Sboard2 where ID=1;

-- 해당번호 조회수 올리기
 update Sboard2 set BHIT= BHIT+ 1 where ID=1;

-- 해당번호 업데이트
 update  Sboard2 
set  BTITLE= 'new' , BCONTENT= 'new', BFILE= '2.png' 
where ID= 1;

-- 해당번호 삭제
 delete from Sboard2 where ID=1;

2) sboard2-mapper.xml
insert
전체 insert
- insert into Sboard2 (ID                 , APP_USER_ID , BTITLE   , BCONTENT      , BPASS  , BFILE     , BIP)
  values            (sboard2_seq.nextval , #{appUserId} , #{btitle} , #{bcontent},#{bpass} , #{bfile}, #{bip});

전체 select (페이징)
- select * from Sboard2 order by id desc;

-- mysql ( oracle에선 동작안함 )
- select * from Sboard2 order by id desc limit 0, 10;

해당번호의 select
- select * from Sboard2 where ID=#{id}

해당번호 조회수 올리기
- update Sboard2 set BHIT= BHIT+ 1 where ID= #{id}

해당번호 업데이트
- update  Sboard2 
set  BTITLE= #{btitle} , BCONTENT= #{bcontent}, BFILE= #{bfile}  
where ID= #{id}

해당번호 삭제
- delete from Sboard2 where ID= #{id}

3) Sboard2Dto.java
