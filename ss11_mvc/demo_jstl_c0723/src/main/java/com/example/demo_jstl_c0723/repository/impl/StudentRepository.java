package com.example.demo_jstl_c0723.repository.impl;

import com.example.demo_jstl_c0723.model.Student;
import com.example.demo_jstl_c0723.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1,"chánh",true,4,1));
        students.add(new Student(2,"Tuấn",true,8,1));
        students.add(new Student(3,"Long",true,7,1));
        students.add(new Student(4,"Đoài",true,5,1));
        students.add(new Student(5,"Thư",false,8,1));
    }
    @Override
    public List<Student> findAll() {
        // kết nối DB
        return students;
    }

    @Override
    public boolean add(Student student) {
        students.add(student);
        return true;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
