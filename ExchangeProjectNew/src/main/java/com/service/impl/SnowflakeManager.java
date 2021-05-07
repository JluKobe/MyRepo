package com.service.impl;

import com.xiangyun.common.zookeeper.snowflake.Snowflake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 产生SnowFlakeId-服务实现类
 * @author wcl
 * @time 2020-08-17
 */
@Service
@Slf4j
public class SnowflakeManager {

    @Autowired
    private Snowflake snowflake;

    /**
     * 产生SnowFlakeId
     * @return String
     * @author hanlj
     * @time 2020-08-05
     */
    public Long getSnowFlakeId (){
        return snowflake.nextId();
    }
}
