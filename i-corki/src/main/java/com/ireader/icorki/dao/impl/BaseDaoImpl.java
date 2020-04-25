package com.ireader.icorki.dao.impl;

import com.ireader.icorki.dao.BaseDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@SuppressWarnings("unchecked")
public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

  @Resource
  private EntityManagerFactory entityManagerFactory;


  private Class<T> clazz;

  public Session getSession() {
    return entityManagerFactory.unwrap(SessionFactory.class).openSession();
  }


  public BaseDaoImpl() {
    // 谁实现该类，这就是谁的类字节码
    Class c = this.getClass();
    // 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
    Type type = c.getGenericSuperclass();
    // 将类型强转为参数化类型
    ParameterizedType pType = (ParameterizedType) type;
    // 获取该类的父类的所有实际类型参数，也就是泛型的实际参数
    // 这里也就是获取BaseDaoImpl的实际类型参数
    Type[] actualTypeArguments = pType.getActualTypeArguments();
    // 将实际类型参数赋值给成员变量
    clazz = (Class<T>) (actualTypeArguments[0]);
  }

  /*
   * (non-Javadoc)
   *
   * @see com.outlook.sftjun.dao.IBaseDao#get(java.io.Serializable)
   */
  public T get(ID id) {
    return this.getSession().get(clazz, id);
  }

  /*
   * (non-Javadoc)
   *
   * @see com.outlook.sftjun.dao.IBaseDao#save(T)
   */
  public void save(T entity) {
    this.getSession().save(entity);
  }

  public void update(T entity) {
    this.getSession().update(entity);
  }

  public void delete(T entity) {
    this.getSession().delete(entity);
  }

  public List<T> findAll(T entity) {
    Session session = this.getSession();
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
    Root<T> root = criteriaQuery.from(clazz);
    criteriaQuery.select(root);
    return session.createQuery(criteriaQuery).getResultList();
  }
}