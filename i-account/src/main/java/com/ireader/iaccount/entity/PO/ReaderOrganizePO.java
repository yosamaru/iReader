package com.ireader.iaccount.entity.PO;

import java.util.Date;
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
@Table(name = "R_ORGANIZE")
public class ReaderOrganizePO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_ORGANIZE_SEQ")
	@SequenceGenerator(name = "R_ORGANIZE_SEQ", sequenceName = "R_ORGANIZE_SEQ")
	@Column(name = "ORGANIZE_ID")
	private Long organizeId;
	@Column(name = "ORGANIZE_NAME")
	private String organizeName;
	@Column(name = "ORGANIZE_PARENT_NAME")
	private String organizeParentName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
}
