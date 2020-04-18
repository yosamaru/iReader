package com.ireader.icommon.enums;

import lombok.Getter;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 全局响应码
 */
@Getter
public enum ResultCodeEnum {
  SUCCESS(true, 00000, "成功"),
  UNKNOWN_ERROR(false, 20001, "未知错误"),
  PARAM_ERROR(false, 20002, "参数错误"),
  SYSTEM_ERROR(false, 99999, "参数错误"),
  INVALID_REQUEST_PARAM(false, 99999, "参数错误"),
  DUPLICATED_RECORD(false, 99999, "参数错误"),;
  // 响应是否成功
  private Boolean success;
  // 响应状态码
  private Integer code;
  // 响应信息
  private String message;

  ResultCodeEnum(Boolean success, Integer code, String message) {
    this.success = success;
    this.code = code;
    this.message = message;
  }

  /**
   * 根据状态码获取其错误信息
   *
   * @param code 状态码
   * @return 错误码对应的错误信息。如果没有找到则返回{@code null}
   */
  public static String getMessageByCode(String code) {
    for (ResultCodeEnum resultCodeEnum : values()) {
      if (resultCodeEnum.code.equals(code)) {
        return resultCodeEnum.message;
      }
    }
    return null;
  }
}
