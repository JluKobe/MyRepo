package com.myproject.vo.result;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ResultBean <T> {
    private int code;

    private String message;

    private String error;

    private T data;

    public ResultBean() {}

    public ResultBean(T data) {
        this.code = 1;
        this.data = data;
    }

    public ResultBean(T data, String message) {
        this.code = 1;
        this.data = data;
        this.message = message;
    }

    public ResultBean(String error) {
        this.code = 0;
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
}
