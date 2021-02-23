package com.schedule;

import com.bean.vo.ExchangeTaskHandleItemVo;
import com.service.IDataExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 定时任务
 */

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class ScheduleTask {
//
//    @Value("${task.handle.item}")
//    private String taskHandleItemList;
//
//    @Value("${high.frequency}")
//    private String isHighFrequency;
//
//    @Value("${batch}")
//    private String isBatch;
//
//    @Autowired
//    IDataExchange iDataExchange;
//
//    //3.添加定时任务
//    //或直接指定时间间隔，例如：5秒
//    //@Scheduled(fixedRate=5000)
////    @Scheduled(cron = "0/5 * * * * ?")
//    private void exchangeTask() {
//        List<String> taskHandleItemList = getTaskHandleItemList();
//        ExchangeTaskHandleItemVo vo = ExchangeTaskHandleItemVo.builder()
//                .createOrgId("1")
//                .createUserId("1")
//                .isHighFrequency(isHighFrequency)
//                .updateOrgId("1")
//                .updateUserId("1")
//                .isBatch(isBatch)
//                .version("1")
//                .taskHandleItemList(taskHandleItemList)
//                .build();
//        iDataExchange.doBusiness(vo);
//    }
//
//    public List getTaskHandleItemList() {
//        List<String> list = new ArrayList<>();
//        String[] arr = taskHandleItemList.split(",");
//        for(String taskHandleItem : arr) {
//            list.add(taskHandleItem);
//        }
//        return list;
//    }
}
