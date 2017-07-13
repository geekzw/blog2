package com.gzw.config;

import com.alibaba.fastjson.JSON;
import com.gzw.domain.ResultInfo;
import com.gzw.enums.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by gujian on 2017/7/7.
 */
//@RestControllerAdvice
public class DefaultExceptionHandlerAdvice {
    @ExceptionHandler(value = { Exception.class })
    public String exception() {
        return JSON.toJSONString(ResultInfo.getErrorInfo(ResultCode.REQUEST_ERROR));
    }
}

