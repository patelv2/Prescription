package com.prescription.Prescription.jpaentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Drug")

public class DrugEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DrugId")
	private Integer drugId;
	@Column(name = "DrugName")
	private String drugName;
	@Column(name = "DrugManufacturer")
	private String drugManufacturer;
	@Column(name = "IsGeneric")
	private String isGeneric;
	@Column(name = "FederalDrugIdentifier")
	private String federalDrugIdentifier;
	@Column(name = "Active")
	private String active;
	public Integer getDrugId() {
		return drugId;
	}
	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugManufacturer() {
		return drugManufacturer;
	}
	public void setDrugManufacturer(String drugManufacturer) {
		this.drugManufacturer = drugManufacturer;
	}
	public String getIsGeneric() {
		return isGeneric;
	}
	public void setIsGeneric(String isGeneric) {
		this.isGeneric = isGeneric;
	}
	public String getFederalDrugIdentifier() {
		return federalDrugIdentifier;
	}
	public void setFederalDrugIdentifier(String federalDrugIdentifier) {
		this.federalDrugIdentifier = federalDrugIdentifier;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	


}
