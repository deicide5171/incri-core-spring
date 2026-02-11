package com.incri.core.web;

import com.incri.core.exception.BizException;
import com.incri.core.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BizException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiResponse<?> handleBiz(BizException e) {
    return ApiResponse.fail(e.getErrorCode().code(), e.getErrorCode().message());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ApiResponse<?> handleUnknown(Exception e) {
    return ApiResponse.fail("E500", "서버 오류가 발생했습니다.");
  }
}