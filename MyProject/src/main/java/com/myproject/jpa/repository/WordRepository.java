package com.myproject.jpa.repository;

import com.myproject.jpa.bean.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
    Word findWordByWord(String word);
}
