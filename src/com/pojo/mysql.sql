-- 创建数据库

drop database hr;

create database hr;

-- 创建部门表
create table dept
(
did integer primary key auto_increment,
dname varchar(20) not null
);

-- 创建员工表
create table emp
(
eid integer primary key auto_increment,
ename varchar(8) not null,
esex varchar(2) not null default '男',
eage integer not null check(eage>0 and eage<=120),
ehobby varchar(200) ,
did integer references dept(did)
);

-- 插入数据
insert into dept values(null,'开发部');
insert into dept values(null,'销售部');
insert into dept values(null,'财务部');

select * from dept;

insert into emp values(null,'张飞','男',20,'喝酒,杀人',1);
insert into emp values(null,'孙二娘','女',18,'做饭,跳舞',2);
insert into emp values(null,'王小二','男',23,'喝酒,杀人',3);

select * from emp;

