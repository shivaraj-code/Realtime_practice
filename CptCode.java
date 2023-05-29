package com.io.codesystem.dto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import lombok.Data;

@Entity
@Table(name = "cpt_ctg")
@Indexed
@Data
public class CptCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@FullTextField(analyzer = "edgengram",searchAnalyzer = "stdquery")
	@Column(name = "code")
	private String code;

	@FullTextField
	@Column(name = "short_name")
	private String shortName;

	// @FullTextField
	@Column(name = "description")
	private String description;

	@Column(name = "is_hcpcs")
	private Integer isHcpcs;

	@Column(name = "version_state")
	private String versionState;
	
	@Column(name = "cpt_major_category")
	private String cptMajorCategory;
	
	@Column(name = "cpt_minor_category")
	private String cptMinorCategory;
	

	/*
	 * @Column(name = "created_by") private Integer createdBy;
	 * 
	 * @CreationTimestamp
	 * 
	 * @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	 * 
	 * @Column(name = "created_date") private Date createdDate;
	 * 
	 * @Column(name = "modified_by") private Integer modifiedBy;
	 * 
	 * @UpdateTimestamp
	 * 
	 * @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	 * 
	 * @Column(name = "modified_date") private Date modifiedDate;
	 * 
	 * @Column(name = "ref_id") private Integer refId;
	 * 
	 * @Column(name = "original_ref_id") private Integer originalRefId;
	 * 
	 * @Column(name = "retired") private String retired = "N";
	 * 
	 * // @UpdateTimestamp
	 * 
	 * @Column(name = "retired_on") private Date retiredOn;
	 * 
	 * @Column(name = "retired_reason") private String retiredReason;
	 */

}
