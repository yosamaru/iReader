package com.ireader.icommon.exception;

import com.ireader.icommon.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * 业务异常基类
 */
@Getter
public abstract class BaseBizException extends RuntimeException {

  protected ResultCodeEnum returnCode = null;

  public BaseBizException(String message) {
    super(message);
  }

  public BaseBizException(ResultCodeEnum returnCode) {
    super(returnCode.getMessage());
    this.returnCode = returnCode;
  }

  /**
   * 业务异常不记录stack trace
   */

  public synchronized Throwable fillInStackTrace() {
    return this;
  }
}

