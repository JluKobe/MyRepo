package com.advice;

import com.bean.ResultBean;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@NoArgsConstructor
@RestControllerAdvice
public class ControllerAdvice {

    private static final String COMMON_ERROR_FORMAT =
            "Error occurs ex: {}, code: {}, message: {}, cause: {}, stack_trace: {}";

//    @ResponseBody
//    @ExceptionHandler(value = BadResponseException.class)
//    public Map myErrorHandler(BadResponseException ex) {
//        Map map = new HashMap();
//        map.put("code", ex.getCode());
//        map.put("msg", ex.getMessage());
//        map.put("error", "program has error");
//        return map;
//    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ResultBean<Object> handleException(Exception ex) {
//        log.error(COMMON_ERROR_FORMAT, ex.getClass(), ex.getMessage(), ex.getCause(), ex.getStackTrace());
//        ResultBean resultBean = new ResultBean();
//        return ResponseWrapper.resp(ErrorCodeEnum.GL909500.code(), ex.getMessage());
//    }
}
