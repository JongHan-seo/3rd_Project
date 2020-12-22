drop table member;

create table member(
name varchar2(20),
phone varchar2(20),
id varchar2(20) unique,
adress varchar2(20),
pw varchar2(20));


insert into MEMBER(name, phone, id, pw ) values('송승룡','01000000','as','as');
insert into MEMBER(name, phone, id, pw ) values('z','z','z','z');

select * from member;
delete from member where name is null;

drop table member cascade constraints;

create table sencing(
gas varchar2(20),
temp varchar2(20),
water varchar2(20),
feeding varchar2(4),
uptime varchar2(20),
upsys date
);

select * from sencing;
select * from(select * from(select gas,temp,water,uptime from sencing order by upsys desc) where rownum <= 10) order by rownum desc;
delete from sencing where gas is null;
delete from sencing where upsys < sysdate-1;  -- 하루 지난 데이터 삭제


drop table sencing;

create sequence count_seq;
drop sequence count_seq;