package com.murali.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PlanEntity {
	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer planId;
	
	@Column(name = "PLAN_NAME")
	private String planname;
	
	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;
	
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "CREATED_DATE",  updatable = false)
	@CreationTimestamp
	private LocalDate cretaedate;
	
	@Column(name = "UPDATED_DATE",  insertable = false)
	@UpdateTimestamp
	private LocalDate updatedate;

}
