package com.murali.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PLAN-CATEGORY")
public class PlanCategory {
	@Id
	@GeneratedValue
	
	private Integer categoryID;
	private String categoryname;
	private String activeSw;
	private String ctreatedBy;
	private String updatedBy;
	@Column(name = "CREATED_DATE",  updatable = false)
	@CreationTimestamp
	private LocalDate cretaedate;
	
	@Column(name = "UPDATED_DATE",  insertable = false)
	@UpdateTimestamp
	private LocalDate updatedate;

}
