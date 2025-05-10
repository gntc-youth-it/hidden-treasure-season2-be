package com.hidden_treasure_season2.common.exception;

import com.hidden_treasure_season2.common.exception.model.ExceptionCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private final int code;
    private final String message;

    public BadRequestException(final ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }
}
