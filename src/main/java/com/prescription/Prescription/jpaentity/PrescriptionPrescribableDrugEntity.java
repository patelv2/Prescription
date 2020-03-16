package com.prescription.Prescription.jpaentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PrescriptionPrescribableDrug")


public class PrescriptionPrescribableDrugEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PrescriptionPrescribableDrugId")
	private Integer prescriptionPrescribableDrugId;
	@Column(name = "PrescriptionId")
	private Integer prescriptionId;
	@Column(name = "PrescribableId")
	private Integer prescribableId;
	@Column(name = "CreatedAt")
	private String createdAt;
	@Column(name = "UpdatedAt")
	private String updatedAt;
	@Column(name = "Active")
	private String active;
	public Integer getPrescriptionPrescribableDrugId() {
		return prescriptionPrescribableDrugId;
	}
	public void setPrescriptionPrescribableDrugId(Integer prescriptionPrescribableDrugId) {
		this.prescriptionPrescribableDrugId = prescriptionPrescribableDrugId;
	}
	public Integer getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public Integer getPrescribableId() {
		return prescribableId;
	}
	public void setPrescribableId(Integer prescribableId) {
		this.prescribableId = prescribableId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	

}
