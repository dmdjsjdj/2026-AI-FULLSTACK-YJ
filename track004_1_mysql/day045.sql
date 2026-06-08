use mbasic;
show tables;

desc date_userinfo;

create table userinfo_e select*from userinfo;
desc userinfo_e;
alter table userinfo_e modify no int not null primary key auto_increment;



-- ex02 ----------------------------
use mbasic;
show tables;
select * from mvcboard2;
create table mvcboard2 select * from mvcboard1;
alter table mvcboard2 modify bno int not null primary key auto_increment;
delete  from mvcboard2  where bno>120;
desc mvcboard2;

ALTER TABLE mvcboard2 ADD bfile VARCHAR(255);
alter table mvcboard2 modify bfile varchar(500) null;
update mvcboard2 set bfile='cat.jpg' where bno=1;

insert into mvcboard2 (bname , bpass , btitle ,  bcontent , bip ,  bfile) 
select bname, bpass, btitle, bcontent, bip, bfile from mvcboard2;
