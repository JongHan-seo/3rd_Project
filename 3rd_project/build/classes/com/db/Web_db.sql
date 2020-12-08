create table member(
id varchar2(20),
pw varchar2(20),
name varchar2(20),
serialcode varchar2(20),
address varchar2(20),
phoneNumber	varchar2(20));

insert into MEMBER(id, pw, serialcode) values('송승룡','1234','abc');
select * from member;

drop table member cascade constraints;

create table sencing( 	
a varchar2(20),
b varchar2(20),
c varchar2(20),
d varchar2(20)
feeding varchar2(4),
feedtime date
);