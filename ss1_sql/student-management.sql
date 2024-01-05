create database if not exists student_management;
use student_management;
create table class (
id_class int auto_increment primary key,
class_name varchar(50) not null
);
drop table class;
create table teacher (
id_teacher int auto_increment primary key,
teacher_name varchar(50) not null,
age int,
country varchar(50)
);
insert into class value(1,'C0723L1');
select * from class;
insert into teacher value(1,'Chanh',38,'Viet Nam');
select * from teacher;
insert into class(class_name) value('C0523L1');
