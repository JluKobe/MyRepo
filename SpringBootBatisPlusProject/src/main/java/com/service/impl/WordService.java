package com.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bean.entity.Word;
import com.repository.WordRepository;
import com.service.IWord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WordService extends ServiceImpl<WordRepository, Word> implements IWord {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<Word> findAllData() {
        List<Word> wordList = wordRepository.selectList(Wrappers.<Word>lambdaQuery());
        return wordList;
    }
}
