package com.myproject.service.impl;

import com.myproject.service.IDataExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataExchangeImpl implements IDataExchange {

    @Autowired
    @Qualifier("jdbcTemplateOne")
    private JdbcTemplate jdbcTemplateOne;

    @Override
    public void test() {
        String sql1 = "select count(1) from task.igt_task_basic";

        String sql2 = "select count(1) from task_test.igt_task_basic";

        int count1 = jdbcTemplateOne.queryForObject(sql1, null, Integer.class);

        int count2 = jdbcTemplateOne.queryForObject(sql2, null, Integer.class);

        System.out.println(count1);
        System.out.println(count2);
    }
}
