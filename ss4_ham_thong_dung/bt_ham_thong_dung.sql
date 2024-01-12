use quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject
where Credit >= all(select Credit from subject);
select * from subject
where Credit = (select max(Credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from subject s 
join mark m on s.subid = m.subid
where m.mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần.
select s.*, AVG(m.Mark) as tbm 
from student s
join mark m on s.StudentId = m.StudentId
group by s.StudentId, s.StudentName
order by tbm desc;



select * from subject;
select * from class;
select * from student;
select * from mark;