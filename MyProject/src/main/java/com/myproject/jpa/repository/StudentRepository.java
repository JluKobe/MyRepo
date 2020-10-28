package com.myproject.jpa.repository;

import com.myproject.jpa.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
