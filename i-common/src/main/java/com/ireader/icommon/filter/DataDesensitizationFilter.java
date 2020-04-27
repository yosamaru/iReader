package com.ireader.icommon.filter;

import com.alibaba.fastjson.serializer.ValueFilter;
import java.lang.reflect.Field;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataDesensitizationFilter implements ValueFilter {

  private Logger logger = LoggerFactory.getLogger(DataDesensitizationFilter.class);

  @Override
  public Object process(Object object, String name, Object value) {
    //Object 序列化的对象，name 序列化的字段， value，字段对应的值
    if (null == value || !(value instanceof String) || ((String) value).length() == 0) {
      return value;
    }

    try {
      Field field = object.getClass().getDeclaredField(name);
      Desensitization desensitization;
      if (String.class != field.getType()
          || (desensitization = field.getAnnotation(Desensitization.class)) == null) {
        return value;
      }
      List<String> regular;
      DesensitizationType type = desensitization.type();
      switch (type) {
        case BANK:
          break;
        case TELEPHONE:
          break;
        default:
          break;
      }
    } catch (NoSuchFieldException e) {
      logger.warn("ValueDesensitizeFilter the class {} has no field {}", object.getClass(), name);
    }
    return value;
  }
}
