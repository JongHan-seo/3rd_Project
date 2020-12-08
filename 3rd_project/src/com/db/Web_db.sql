drop table member;

create table member(
name varchar2(20),
phon varchar2(20),
id varchar2(20),
pw varchar2(20));

insert into MEMBER(name, phon, id, pw ) values('송승룡','01000000','as','as');
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