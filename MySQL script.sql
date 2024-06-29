create database universitymanagementsystem;

show databases;

use universitymanagementsystem;

create table login(username varchar(25), password varchar(25));

insert into login values
('admin', '12345');

create table student(
name varchar(50), fname varchar(50), rollno varchar(10), dob varchar(40), address varchar(100),
phone varchar(20), email varchar(40), aadhar varchar(40), class_x varchar(20), class_xii varchar(20),
course varchar(40), branch varchar(40)); 

select * from student;

create table teacher(
name varchar(50), fname varchar(50), empID varchar(10), dob varchar(40), address varchar(100),
phone varchar(20), email varchar(40), aadhar varchar(40), pan varchar(20), UGCNETscore float(20),
qualification varchar(40), department varchar(40)); 

select * from teacher;

create table studentleave(
rollno varchar(20),
date varchar(50),
duration varchar(20),
reason varchar(100)
);

select * from studentleave;

create table teacherleave(
empID varchar(20),
date varchar(50),
duration varchar(20),
reason varchar(100)
);

select * from teacherleave;

create table subject(
rollno varchar(20),
semester varchar(20), subject1 varchar(50), 
subject2 varchar(50), subject3 varchar(50), 
subject4 varchar(50), subject5 varchar(50));

select * from subject;

create table marks(
rollno varchar(20),
semester varchar(20), marks1 int(10),
marks2 int(10), marks3 int(10),
marks4 int(10), marks5 int(10));

select * from marks;

create table fee(course varchar(20), semester1 varchar(20), semester2 varchar(20), semester3 varchar(20), semester4 varchar(20), semester5 varchar(20), semester6 varchar(20), semester7 varchar(20), semester8 varchar(20));

select * from fee;

insert into fee values("BTech", "48000", "43000", "43000", "43000", "43000", "43000", "43000","43000");
insert into fee values("BSc", "40000", "35000", "35000", "35000", "35000", "35000", "","");
insert into fee values("BCA", "35000", "30000", "30000", "30000", "30000", "30000", "","");
insert into fee values("MTech", "65000", "60000", "60000", "60000", "", "", "","");
insert into fee values("MSc", "57565", "52000", "52000", "52000", "", "", "","");
insert into fee values("MCA", "47500", "42000", "42000", "42000", "", "", "","");

create table collegefee(rollno varchar(20), course varchar(20), branch varchar(20), semester varchar(20), total varchar(20));

select * from collegefee;

show tables;