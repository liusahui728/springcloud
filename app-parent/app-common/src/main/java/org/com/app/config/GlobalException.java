package org.com.app.config;

import lombok.extern.slf4j.Slf4j;
import org.com.app.base.entry.Result;
import org.com.app.base.exception.CustomerException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler()
    @ResponseBody
    Result handleCustomerException(CustomerException e) {
        log.error(e.getMessage(), e);
        return Result.utils.setFailResult(e.getMessage());
    }

    @ExceptionHandler()
    @ResponseBody
    Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.utils.setFailResult("操作失败");
    }
    @ExceptionHandler()
    @ResponseBody
    Result httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        return Result.utils.setFailResult("请检查get/post请求方式");
    }
}
