use mbasic;

create table t1 (
no int not null auto_increment primary key,
name varchar(100)
);

desc t1;
select * from t1;

-- -------------------
create table t2 (
ino int not null primary key ,
foreign key(ino) references t1(no)
); -- 외래키 (ino) 참고테이블 t1(no필드)

desc t2;
select * from t2;

drop table t2;