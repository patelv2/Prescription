package com.prescription.Prescription.jpaentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prescribable")

public class PrescribableEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PrescribableId")
	private Integer prescribableId;
	@Column(name = "Dosage")
	private Integer dosage;
	@Column(name = "MinWeight")
	private Float minWeight;
	@Column(name = "RefillFrequency")
	private Integer refillFrequency;
	@Column(name = "DosesPerDay")
	private String dosesPerDay;
	@Column(name = "DrugId")
	private Integer drugId;
	@Column(name = "Active")
	private String active;
	public Integer getPrescribableId() {
		return prescribableId;
	}
	public void setPrescribableId(Integer prescribableId) {
		this.prescribableId = prescribableId;
	}
	public Integer getDosage() {
		return dosage;
	}
	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}
	public Float getMinWeight() {
		return minWeight;
	}
	public void setMinWeight(Float minWeight) {
		this.minWeight = minWeight;
	}
	public Integer getRefillFrequency() {
		return refillFrequency;
	}
	public void setRefillFrequency(Integer refillFrequency) {
		this.refillFrequency = refillFrequency;
	}
	public String getDosesPerDay() {
		return dosesPerDay;
	}
	public void setDosesPerDay(String dosesPerDay) {
		this.dosesPerDay = dosesPerDay;
	}
	public Integer getDrugId() {
		return drugId;
	}
	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
	

}
