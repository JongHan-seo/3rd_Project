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
gas varchar2(20),
temp varchar2(20),
water varchar2(20),
feeding varchar2(4),
feedtime date
);

select * from sencing;


drop table sencing;