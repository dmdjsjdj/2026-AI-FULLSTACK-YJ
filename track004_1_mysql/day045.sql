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
desc mvcboard2;




