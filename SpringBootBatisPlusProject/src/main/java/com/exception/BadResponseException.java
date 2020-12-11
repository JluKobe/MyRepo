package com.exception;

import com.bean.enums.ErrorCodeEnum;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * project standard exception
 */
@Data
public class BadResponseException extends RuntimeException {

    private static final long serialVersionUID = 1296923009039947638L;

    private final HttpStatus httpStatus;

    private final String code;

    private final String message;

    public BadResponseException(HttpStatus httpStatus, ErrorCodeEnum errorCodeEnum, String message) {
        super();
        this.httpStatus = httpStatus;
        this.code = errorCodeEnum.code();
        this.message = message;
    }

    public BadResponseException(HttpStatus httpStatus, ErrorCodeEnum errorCodeEnum) {
        this(httpStatus, errorCodeEnum, errorCodeEnum.message());
    }
}
