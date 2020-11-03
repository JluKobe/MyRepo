package com.myproject.jpa.repository;

import com.myproject.jpa.bean.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface WordRepository extends JpaRepository<Word, Long> {
    Word findWordByWord(String word);

    @Query(value = "select sentence from word", nativeQuery = true)
    List<String> findSentence();

    @Query(value = "select meaning from word", nativeQuery = true)
    List<String> findMeans();
}
