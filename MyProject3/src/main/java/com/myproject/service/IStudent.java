package com.myproject.service;

import com.myproject.vo.StudentVo;

public interface IStudent {
    StudentVo getStudent(Long id);

    boolean insertStudent(StudentVo vo);
}
