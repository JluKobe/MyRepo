package com.schedule;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bean.entity.clean.CleanBasic;
import com.config.DbContextHolder;
import com.enums.DBTypeEnum;
import com.repository.CleanBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时任务demo
 */

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTask {

    @Autowired
    private CleanBasicRepository cleanBasicRepository;

    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        DbContextHolder.setDbType(DBTypeEnum.db2);
        CleanBasic cleanBasic = cleanBasicRepository.selectOne(Wrappers.<CleanBasic>lambdaQuery().eq(CleanBasic::getRowguid, "0a12fb4e-9123-8992-a847-4ae7163bc87a"));
        System.out.println(cleanBasic.getTaskname());
    }
}
