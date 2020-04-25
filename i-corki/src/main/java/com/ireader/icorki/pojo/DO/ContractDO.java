package com.ireader.icorki.pojo.DO;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CONTRACT")
public class ContractDO {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_seq")
  @SequenceGenerator(name = "contract_seq", sequenceName = "contract_seq")
  @Column(name = "ID")
  private Long id;

  @Column(name = "USER_ID")
  private Long userId;

  @Column(name = "book_id")
  private Long bookId;

  @Column(name = "VOIDED_DATE")
  private Date voidedDate;

  @Column(name = "STATUS")
  private Integer status;

  @Column(name = "APPROVED_ID")
  private Long approvedId;

  @Transient
  private String moderatorName;

  @Column(name = "CASH_ACCOUNT_TRANSACTION_ID")
  private Long cashAccountTransactionId;

  @Column(name = "create_time")
  private Timestamp createTime;

  @Column(name = "update_time")
  private Timestamp updateTime;
}
