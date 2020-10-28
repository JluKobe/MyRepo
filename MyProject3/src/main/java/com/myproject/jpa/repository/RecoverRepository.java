package com.myproject.jpa.repository;

import com.myproject.jpa.bean.RecoverDataLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecoverRepository extends JpaRepository<RecoverDataLog, Long> {

}