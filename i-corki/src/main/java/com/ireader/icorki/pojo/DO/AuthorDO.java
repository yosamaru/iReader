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
@Table(name = "AUTHOR")
public class AuthorDO {

  private static final long serialVersionUID = -4126788655432292921L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
  @SequenceGenerator(name = "author_seq", sequenceName = "author_seq")
  @Column(name = "ID")
  private Long Id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "COUNTRY")
  private String Country;

  @Column(name = "create_time")
  private Timestamp createTime;

  @Column(name = "update_time")
  private Timestamp updateTime;
}
