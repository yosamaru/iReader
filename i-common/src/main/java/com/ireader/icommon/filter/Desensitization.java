package com.ireader.icommon.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitization {

  /**
   * 脱敏规则
   */
  DesensitizationType type();

  /**
   * 自定义正则表达式
   */
  String attach() default "";
}
