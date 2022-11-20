drop database if exists ss3_qlsvien;
create database ss3_qlsvien;
use ss3_qlsvien;
create table class(
	class_id int auto_increment not null primary key,
	class_name varchar(60) not null,
	start_date datetime,
	`status` bit(1)
);
create table student(
	student_id int not null auto_increment primary key,
    student_name varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    status bit(1),
    class_id int not null,
    foreign key (class_id) references class(class_id)
);
create table `subject`(
	sub_id int not null primary key auto_increment,
	sub_name varchar(30),
    credit tinyint not null default 1 check(credit>=1),
    status bit(1) default 1
);
create table mark(
	mark_id int not null primary key auto_increment,
    sub_id int not null,
    student_id int not null,
    mark float default 0 check(mark between 0 and 100),
    exam_times tinyint default 1,
    unique(sub_id,student_id),
    foreign key (sub_id) references `subject`(sub_id),
    foreign key (student_id) references student(student_id)
);

insert into class values
(1, 'A1', '2008-12-20', 1),
(2, 'A2', '2008-12-22', 1),
(3, 'B3', current_date, 0);
insert into student(student_name,address,phone,status,class_id) values
('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student(student_name, address,status,class_id) values
('Hoa', 'Hai phong', 1, 1);
insert into student(student_name,address,phone,status,class_id) values
('Manh', 'HCM', '0123123123', 0, 2);
-- insert bảng subject
insert into subject(sub_name,credit,status) values 
('CF', 5, 1),
('C', 6, 1),
('HDJ', 5, 1),
('RDBMS', 10, 1);
insert into mark(sub_id,student_id,mark,exam_times) values
(1, 1, 8, 1),
(1, 2, 10, 2),
(2, 1, 12, 1);

select * from student where student_name like 'h%';
select * from class where start_date like '%20%';
select * from subject where credit between 3 and 5;
update student set class_id =2 where student_name = 'Hung';
select st.student_name,sj.sub_name,m.mark from student st
join mark m on st.student_id = m.student_id
join subject sj on m.sub_id = sj.sub_id
order by m.mark desc, st.student_name asc;
select address, count(student_id) as 'so luong hoc sinh' from student
group by address;
-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
select s.student_id,s.student_name,avg(mark) from student s 
join mark m on s.student_id = m.student_id
group by s.student_id,s.student_name;

SELECT S.student_id,S.student_name, AVG(mark)
FROM student s join mark m on s.student_id = m.student_id
GROUP BY s.student_id, s.student_name
HAVING AVG(mark) > 15;
SELECT s.student_id, s.student_name, AVG(mark)
FROM student s join mark m on s.student_id = m.student_id
GROUP BY s.student_id, s.student_name
HAVING AVG(mark) >= ALL (SELECT AVG(mark) FROM mark GROUP BY mark.student_id);
/*Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
Hiển thị các thông tin môn học có điểm thi lớn nhất.
Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần*/
select * from `subject` having credit >=( select max(credit) from `subject`);
select * from subject having credit >= (select credit from subject 
											group by sub_id 
                                            order by credit desc
                                            limit 1);
select * from `subject` sj
join mark m on sj.sub_id = m.sub_id
order by m.mark desc
limit 1;
select * , avg(m.mark) as 'diem trung binh' from student st
join mark m on st.student_id=m.student_id
group by m.student_id
order by 'diem trung binh' desc;


 
