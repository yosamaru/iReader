package com.ireader.icommon.result;

import com.alibaba.fastjson.JSONArray;
import com.ireader.icommon.enums.ResultCodeEnum;

/**
 * 全局响应结构
 */
public class CommonResponseParams {

  private Boolean success;

  /**
   * 返回码 - 必填
   */
  private Integer code;

  /**
   * 返回描述 - 必填
   */
  private String message;

  /**
   * 业务数据 - 必填
   */
  private Object data;

  private CommonResponseParams(final Boolean success, final Integer code, final String message,
      final Object data) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * 返回成功结果，没有响应数据
   *
   * @return 公共响应参数实体
   */
  public static CommonResponseParams ofSuccessful() {
    return ofSuccessful(null);
  }

  /**
   * 返回成功结果
   *
   * @param content 返回的数据
   * @param <T> 返回的数据的类型
   * @return 公共响应参数实体
   */
  public static <T> CommonResponseParams ofSuccessful(final T content) {
    return new CommonResponseParams(
        ResultCodeEnum.SUCCESS.getSuccess(),
        ResultCodeEnum.SUCCESS.getCode(),
        ResultCodeEnum.SUCCESS.getMessage(),
        JSONArray.toJSON(content));
  }

  /**
   * 返回失败结果
   *
   * @return 公共响应参数实体
   */
  public static CommonResponseParams ofFailure() {
    return new CommonResponseParams(
        ResultCodeEnum.SYSTEM_ERROR.getSuccess(),
        ResultCodeEnum.SYSTEM_ERROR.getCode(),
        ResultCodeEnum.SYSTEM_ERROR.getMessage(),
        null);
  }

  public static CommonResponseParams ofFailure(String message) {
    return new CommonResponseParams(
        ResultCodeEnum.SYSTEM_ERROR.getSuccess(),
        ResultCodeEnum.SYSTEM_ERROR.getCode(),
        message,
        null);
  }

  /**
   * 返回失败结果
   *
   * @param returnCode 错误的返回码
   * @return 公共响应参数实体
   */
  public static CommonResponseParams ofFailure(ResultCodeEnum returnCode) {
    return new CommonResponseParams(
        returnCode.getSuccess(),
        returnCode.getCode(),
        returnCode.getMessage(),
        null);
  }

  /**
   * 返回带有自定义错误信息的失败结果
   *
   * @param returnCode 错误相关的返回码
   * @param errMessage 自定义的错误信息
   * @return 公共响应参数实体
   */
  public static CommonResponseParams ofFailure(ResultCodeEnum returnCode, String errMessage) {
    return new CommonResponseParams(
        returnCode.getSuccess(),
        returnCode.getCode(),
        errMessage,
        null);
  }
}
