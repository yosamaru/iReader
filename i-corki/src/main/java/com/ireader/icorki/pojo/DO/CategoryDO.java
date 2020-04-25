package com.ireader.icorki.pojo.DO;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CATEGORY")
public class CategoryDO {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
  @SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "create_time")
  private Timestamp createTime;

  @Column(name = "update_time")
  private Timestamp updateTime;
}
