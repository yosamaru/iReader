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
@Table(name = "PUBLISHER")
public class PublisherDO {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_seq")
  @SequenceGenerator(name = "publisher_seq", sequenceName = "publisher_seq")
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "EMAIL", nullable = false)
  private String email;


  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "TELEPHONE")
  private String telephone;

  @Column(name = "FAX")
  private String fax;

  @Column(name = "create_time")
  private Timestamp createTime;

  @Column(name = "update_time")
  private Timestamp updateTime;

}
