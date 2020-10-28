package com.myproject.aop;

import com.myproject.vo.result.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


@Slf4j
public class ControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;

        try {
            result = (ResultBean<?>) pjp.proceed();
            logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = null;
        }
        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean<>();
        if(e instanceof IOException) {
            System.out.println("IoException");
            result.setCode(0);
            result.setError("IoException");
        }
        else if(e instanceof NullPointerException) {
            System.out.println("NullPointerException");
            result.setCode(0);
            result.setError("NullPointerException");
        }
        else {
            result.setCode(0);
            result.setError("Error Exception");
        }
        return result;
    }
}
