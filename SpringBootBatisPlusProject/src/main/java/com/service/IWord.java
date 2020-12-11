package com.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bean.entity.Word;

import java.util.List;

public interface IWord extends IService<Word> {
    List<Word> findAllData();
}
