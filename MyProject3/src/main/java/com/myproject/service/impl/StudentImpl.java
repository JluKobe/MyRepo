package com.myproject.service.impl;

import com.myproject.jpa.bean.Student;
import com.myproject.jpa.repository.StudentRepository;
import com.myproject.service.IStudent;
import com.myproject.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentImpl implements IStudent {

    @Autowired
    private StudentRepository repository;

    @Override
    public StudentVo getStudent(Long id) {
        Optional<Student> result = repository.findById(id);
        Student student = result.get();
        StudentVo vo = StudentVo.builder()
                .id(id)
                .age(student.getAge())
                .name(student.getName())
                .build();
        return vo;
    }

    @Override
    public boolean insertStudent(StudentVo vo) {
        long id = vo.getId();
        int age = vo.getAge();
        String name = vo.getName();
        Student s = Student.builder()
                .id(id)
                .age(age)
                .name(name)
                .build();
        repository.save(s);
        return true;
    }
}
