package com.ireader.icommon.filter;

/**
 * 脱敏类型 通用型
 */
public enum DesensitizationType {
  TELEPHONE("1"),
  BANK("2"),
  IDENTITY("3"),;
  private String attach;

  DesensitizationType(String attach) {
    this.attach = attach;
  }

  public String getAttach() {
    return attach;
  }
}
