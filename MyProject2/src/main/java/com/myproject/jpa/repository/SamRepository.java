package com.myproject.jpa.repository;

import com.myproject.jpa.bean.Sam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamRepository extends JpaRepository<Sam, Long> {
}
