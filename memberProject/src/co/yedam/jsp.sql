-- 사원테이블 (사원번호,사원명,연락처, 이메일,입사일자,급여)
create table emp (
 emp_no number primary key, 
 emp_name varchar2(40) not null,
 emp_phone varchar2(12) not null,
 email varchar2(30) not null,
 hire_date  date default sysdate,
 salary number
);

--C(create)Rr=(read)U(upadte)D(delete)
create sequence emp_seq;
insert into emp (emp_no,emp_name,emp_phone,email,salary)
values (emp_seq.nextval, 'kildonHong','01-1234-5678','kilhong@email',2000);
insert into emp (emp_no,emp_name,emp_phone,email,salary)
values (emp_seq.nextval, 'kildongPark','01-3333-5678','pkildong@eamil',2300);

select *
from emp
order by emp_no;

update emp 
set salary = 3000
where emp_name = 'kildongPark';

delete emp
where emp_no = 2;

commit;

update emp
set salary = salary+500,
    emp_phone = '11-2311-3213'
where emp_name = 'kildonhPark';

delete emp
where emp_no = 21;

rollback;

create table swim(
 mem_number number primary key,
 mem_name varchar2(15) not null,
 mem_phone varchar2(15) not null,
 mem_day  varchar2(8) not null,
 mem_gender varchar(2)
 );
 
select *
from swim;

create sequence Swim_swq;

commit;
insert into swim(mem_number,mem_name,mem_phone,mem_day,mem_gender)
values (Swim_swq.nextval,'길동','010-2321-1314','99-04-30','여');

alter table swim
modify  (mem_gender varchar(10));

commit;

alter table swim add mem_date varchar2(10); 