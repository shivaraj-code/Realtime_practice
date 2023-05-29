package com.io.codesystem.dto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "allergies")
@Indexed

//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Allergy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "dam_concept_id")
	private String damConceptId;

	@FullTextField
	@Column(name = "dam_concept_id_desc")
	private String damConceptIdDesc;
	
	@Column(name = "dam_concept_id_type")
	private Integer damConceptIdType;

	@FullTextField
	@Column(name = "dam_alrgn_grp_desc")
	private String damAlrgnGrpDesc;

	@FullTextField
	@Column(name = "allergy_desc")
	private String allergyDesc;

	@Column(name = "snomed_code")
	private String snomedCode;
	@Column(name = "snomed_concept")
	private String snomedConcept;
	@Column(name = "data_source")
	private String dataSource;
	@Column(name = "version_state")
	private String versionState;
	// @Column(name = "Status")
	// private String status = "Y";
	// @CreatedDate
	// @Temporal(TemporalType.TIMESTAMP) insertable = false, updatable = true)
	// @CreationTimestamp
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "created_date")
	public Date createdDate;
	@Column(name = "created_by")
	public String createdBy;
	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "last_modified_date")
	public Date lastModifiedDate;
	@Column(name = "last_modified_by")
	public String lastModifiedBy;
	@Column(name = "ref_id")
	private Integer refId;
	@Column(name = "original_ref_id")
	private Integer originalRefId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "original_created_date")
	private Date originalCreatedDate;
	@Column(name = "retired")
	private String retired;
	@Column(name = "retired_on")
	private String retiredOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDamConceptId() {
		return damConceptId;
	}

	public void setDamConceptId(String damConceptId) {
		this.damConceptId = damConceptId;
	}

	public String getDamConceptIdDesc() {
		return damConceptIdDesc;
	}

	public void setDamConceptIdDesc(String damConceptIdDesc) {
		this.damConceptIdDesc = damConceptIdDesc;
	}

	public Integer getDamConceptIdType() {
		return damConceptIdType;
	}

	public void setDamConceptIdType(Integer damConceptIdType) {
		this.damConceptIdType = damConceptIdType;
	}

	public String getDamAlrgnGrpDesc() {
		return damAlrgnGrpDesc;
	}

	public void setDamAlrgnGrpDesc(String damAlrgnGrpDesc) {
		this.damAlrgnGrpDesc = damAlrgnGrpDesc;
	}

	public String getAllergyDesc() {
		return allergyDesc;
	}

	public void setAllergyDesc(String allergyDesc) {
		this.allergyDesc = allergyDesc;
	}

	public String getSnomedCode() {
		return snomedCode;
	}

	public void setSnomedCode(String snomedCode) {
		this.snomedCode = snomedCode;
	}

	public String getSnomedConcept() {
		return snomedConcept;
	}

	public void setSnomedConcept(String snomedConcept) {
		this.snomedConcept = snomedConcept;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getVersionState() {
		return versionState;
	}

	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public Integer getOriginalRefId() {
		return originalRefId;
	}

	public void setOriginalRefId(Integer originalRefId) {
		this.originalRefId = originalRefId;
	}

	public Date getOriginalCreatedDate() {
		return originalCreatedDate;
	}

	public void setOriginalCreatedDate(Date originalCreatedDate) {
		this.originalCreatedDate = originalCreatedDate;
	}

	public String getRetired() {
		return retired;
	}

	public void setRetired(String retired) {
		this.retired = retired;
	}

	public String getRetiredOn() {
		return retiredOn;
	}

	public void setRetiredOn(String retiredOn) {
		this.retiredOn = retiredOn;
	}

}
