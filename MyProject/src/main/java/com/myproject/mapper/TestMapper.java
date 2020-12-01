package com.myproject.mapper;

import com.myproject.bean.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMapper implements RowMapper<Test> {

    @Override
    public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
        Test test = new Test();
        test.setId(rs.getInt("id"));
        test.setTask(rs.getString("task"));
        test.setNum(rs.getString("num"));
        return test;
    }
}
