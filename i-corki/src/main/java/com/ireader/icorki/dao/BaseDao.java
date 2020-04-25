package com.ireader.icorki.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {

  /**
   * 查询得到结果
   */
  T get(ID id);

  /**
   * 持久化实体
   */
  void save(T entity);

  /**
   * 更新实体
   */
  void update(T entity);

  /**
   * 删除实体
   */
  void delete(T entity);

  /**
   * 查询该对象的所有信息
   */
  List<T> findAll(T entity);

}
