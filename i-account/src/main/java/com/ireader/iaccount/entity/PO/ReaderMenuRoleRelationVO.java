package com.ireader.iaccount.entity.PO;

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
@Table(name = "R_MENU_ROLE_RELATION")
public class ReaderMenuRoleRelationVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_MENU_ROLE_SEQ")
	@SequenceGenerator(name = "R_MENU_ROLE_SEQ", sequenceName = "R_MENU_ROLE_SEQ")
	@Column(name = "MENU_ROLE_ID")
	private Long menuRoleId;
	@Column(name = "MENU_ID")
	private Long menuId;
	@Column(name = "ROLE_ID")
	private Long roleId;
}
