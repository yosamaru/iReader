package com.ireader.icorki.pojo.DO;

import java.math.BigDecimal;
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
@Table(name = "BOOK")
public class BookDO {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
  @SequenceGenerator(name = "book_seq", sequenceName = "book_seq")
  @Column(name = "ID")
  private Long id;

  @Column(name = "SUBJECT", unique = true)
  private String subject;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "ISBN")
  private String isbn;

  @Column(name = "CONTENT")
  private String content;

  @Column(name = "CONTENT_TYPE")
  private String contentType;

  @Column(name = "AUTHOR_ID", nullable = false)
  private Long authorId;

  @Column(name = "PUBLISHER_ID", nullable = false)
  private Long publisherId;

  @Column(name = "CATEGORY_ID", nullable = false)
  private Long categoryId;

  @Column(name = "price", nullable = false, columnDefinition = "Decimal(10,2) default 0.00")
  private BigDecimal price;

  @Column(name = "FILE_DOWNLOAD_URI")
  private String fileDownloadUri;

  @Column(name = "create_time")
  private Timestamp createTime;

  @Column(name = "update_time")
  private Timestamp updateTime;
}
