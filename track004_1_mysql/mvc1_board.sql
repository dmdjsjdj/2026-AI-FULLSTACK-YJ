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
