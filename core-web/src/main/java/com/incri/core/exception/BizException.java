package com.incri.core.exception;

import com.incri.core.contract.error.ErrorCode;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
  private final ErrorCode errorCode;

  public BizException(ErrorCode errorCode) {
    super(errorCode.message());
    this.errorCode = errorCode;
  }
}
