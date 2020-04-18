package com.ireader.icommon.exception;

import com.ireader.icommon.enums.ResultCodeEnum;
import com.ireader.icommon.result.CommonResponseParams;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一异常处理配置类
 */
@Slf4j
@ResponseBody
@ControllerAdvice(annotations = RestController.class)
public class UnifiedExceptionHandler {

  /**
   * 处理数据库连接失败抛出的异常
   *
   * @return 带有数据库连接失败信息的失败返回
   */
  @ExceptionHandler(CannotCreateTransactionException.class)
  public CommonResponseParams handleCannotCreateTransactionException(
      CannotCreateTransactionException e) {
    log.error(e.getMessage(), e);
    return CommonResponseParams.ofFailure("数据库连接失败");
  }

  /**
   * 处理未知的运行时错误
   *
   * @return 默认的失败返回
   */
  @ExceptionHandler(RuntimeException.class)
  public CommonResponseParams handleUnknownRuntimeExceptions(RuntimeException e) {
    log.error(e.getMessage(), e);
    return CommonResponseParams.ofFailure(e.getMessage());
  }

  /**
   * 处理公共请求参数校验失败异常
   *
   * @param e 参数校验失败抛出的异常
   * @return 带有校验失败原因提示信息的失败返回
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public CommonResponseParams handleRequestParamValidationExceptions(
      MethodArgumentNotValidException e) {
    String errMessage = Optional.ofNullable(e.getBindingResult().getFieldError())
        .map(FieldError::getDefaultMessage)
        .orElse(ResultCodeEnum.INVALID_REQUEST_PARAM.getMessage());

    log.error(e.getMessage());
    return CommonResponseParams.ofFailure(ResultCodeEnum.INVALID_REQUEST_PARAM, errMessage);
  }

  /**
   * 处理请求body为空的异常
   *
   * @return 带有请求体无效错误的失败返回
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public CommonResponseParams handleHttpMessageNotReadableException() {
    return CommonResponseParams.ofFailure(ResultCodeEnum.INVALID_REQUEST_PARAM);
  }

  /**
   * 处理新增数据主键重复异常
   *
   * @return 带有主键重复错误的失败返回
   */
  @ExceptionHandler(DuplicateKeyException.class)
  public CommonResponseParams handleDuplicateKeyException() {
    return CommonResponseParams.ofFailure(ResultCodeEnum.DUPLICATED_RECORD);
  }

  /**
   * 处理业务异常
   *
   * @return 业务异常对应的失败返回
   */
  @ExceptionHandler(BaseBizException.class)
  public CommonResponseParams handleBizExceptions(BaseBizException e) {
    if (e.getReturnCode() != null) {
      ResultCodeEnum resultCodeEnum = e.getReturnCode();
      log.error(resultCodeEnum.getMessage());
      return CommonResponseParams.ofFailure(resultCodeEnum);
    } else if (StringUtils.isNotBlank(e.getMessage())) {
      log.error(e.getMessage());
      return CommonResponseParams.ofFailure(e.getMessage());
    } else {
      log.error(e.getMessage());
      return CommonResponseParams.ofFailure();
    }
  }
}