package com.myproject.service;

import com.myproject.jpa.bean.Word;
import com.myproject.vo.WordVo;

import java.util.List;

public interface IWord {
    long addWord(WordVo wordVo);

    List<Word> getAllWord();

    List<String> getAllSentence();
}
