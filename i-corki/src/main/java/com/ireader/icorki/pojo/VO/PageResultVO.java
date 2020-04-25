package com.ireader.icorki.pojo.VO;

import java.util.List;

public class PageResultVO<T> {

  private int pageSize = 5;
  private int pageNum = 1;
  private int offSet = 0;
  private Long totalPages = 1L;
  private Long totalCount = 1L;
  private List<T> result;
  private String order;
  private String orderBy;

  public PageResultVO() {
  }


  /**
   * 获取每页显示的数据量
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * 设置每页显示的数据量
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * 获取当前页码
   */
  public int getPageNum() {
    return pageNum;
  }

  /**
   * 设置当前页码
   */
  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    if (pageNum < 1) {
      this.pageNum = 1;
    }
  }

  /**
   * 获取起始行号
   */
  public int getOffSet() {
    return offSet;
  }

  /**
   * 设置起始行号
   */
  public void setOffSet(int offSet) {
    this.offSet = offSet;
  }

  /**
   * 获取总页数
   */
  public Long getTotalPages() {
    return totalPages;
  }

  /**
   * 设置总页数
   */
  private void setTotalPages(Long totalPages) {
    this.totalPages = totalPages;
  }

  /**
   * 获取总记录数
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * 设置总记录数
   */
  public void setTotalCount(Long totalCount) {
    this.totalCount = totalCount;
    //根据总记录数自动计算总页数
    Long result = totalCount / getPageSize();
    if (totalCount % pageSize != 0) {
      result += 1;
    }
    setTotalPages(result);

    //根据当前页码自动计算起始行号
    setOffSet((this.pageNum - 1) * getPageSize());
  }

  /**
   * 获取当前页的数据集
   */
  public List<T> getResult() {
    return result;
  }

  /**
   * 设置当前页的数据集
   */
  public void setResult(List<T> result) {
    this.result = result;
  }

  /**
   * 获取排序属性名，多个属性之间采用,分割
   */
  public String getOrder() {
    return order;
  }

  /**
   * 设置排序属性名，多个属性之间采用,分割
   */
  public void setOrder(String order) {
    this.order = order;
  }

  /**
   * 获取排序方式，多个方式之间采用,分割
   */
  public String getOrderBy() {
    return orderBy;
  }

  /**
   * 设置排序方式，多个方式之间采用,分割
   */
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }


}

