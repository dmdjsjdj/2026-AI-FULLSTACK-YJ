use mbasic;
CREATE TABLE mbasic.mvcboard1 LIKE dbdbig.mvcboard1;
INSERT INTO mbasic.mvcboard1 SELECT * FROM dbdbig.mvcboard1;
create table mvcboard1 (
	bno 	int 	   	 not null primary key auto_increment,
    bname 	varchar(200) not null,
    bpass 	varchar(50)  not null,
    btitle  varchar(100) not null,
    bcontent text not null,
    bdate timestamp not null default current_timestamp,
    bhit int not null default 0,
    bip  varchar(50) not null
);

desc mvcboard1;
select * from mvcboard1;
insert into mvcboard1 (bname, bpass, btitle, bcontent, bip) values ('yj','jsp','hi','hello','192.168.40.32');

insert into mvcboard1 (bname, bpass, btitle, bcontent, bip) values (?,?,?,?,?);

delete from mvcboard1 where bno>1;

select count(*) from mvcboard1 where bno;
-- users ---------------------------------------------
create table users (
uno int not null primary key auto_increment,
nickname varchar(20) not null,
bpass    varchar(50) not null,
email  varchar(100) not null,
mobile varchar(50)  not null,
udate   timestamp   not null  DEFAULT CURRENT_TIMESTAMP,
bip     varchar(50) not null
);

desc users;
select * from users;

-- list
select * from mvcboard1 order by bdate desc;
select count(*) `cnt` from mvcboard1;

SELECT b.*, (SELECT COUNT(*) FROM mvcboard1) `cnt` FROM mvcboard1 b ORDER BY bno DESC;
-- join
insert into users (nickname, bpass, email, mobile, bip) values (?,?,?,?,?);
-- write
insert into mvcboard1 ( bname, bpass, btitle, bcontent, bip) values (?,?,?,?,?);
-- login
select * from users where bpass=? and email=?;
-- mypage
SELECT * FROM users where nickname=?;
-- detail
select * from mvcboard1 where bno=?;
update mvcboard1 set bhit=bhit+1 where bno=? and bpass=?;

select * from users where bpass=? and email=?;
-- -------
update mvcboard1 set btitle=?, bcontent=? where bno=? and bpass=?;
-- -------
delete from mvcboard1 where bno=? and bpass=?;

SELECT *, count(*) cnt FROM users where email='aaa@gmail.com';


