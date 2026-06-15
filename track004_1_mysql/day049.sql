use mbasic;

desc users;
select  *  from users;
delete from users where uno=15;

alter table users   modify  bpass varchar(500) not null;

-- ------------------------
create table authorities (
email varchar(50) not null,
auth  varchar(50) not null
);

desc authorities;

select  *  from authorities;

select  *  from emp;