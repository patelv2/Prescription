package com.prescription.Prescription.jpaentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "Prescription")

public class PrescriptionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PrescriptionId")
	private Integer prescriptionId;
	
	@Column(name = "PatientId")
	private Integer patientId;
	
	@Column(name = "PharmacyId")
	private Integer pharmacyId;
	
	@Column(name = "DoctorId")
	private Integer doctorId;
	
	@Column(name = "ReasonId")
	private Integer reasonId;
	
	@Column(name = "SelfDiagnosed")
	private String selfDiagnosed;
	
	@Column(name = "PharmacistId")
	private Integer pharmacistId;
	
	@Column(name = "Active")
	private String active;
	
	@JsonInclude()
	@Transient
	private String errorMessage;
	
	public Integer getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(Integer pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getReasonId() {
		return reasonId;
	}
	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}
	public String getSelfDiagnosed() {
		return selfDiagnosed;
	}
	public void setSelfDiagnosed(String selfDiagnosed) {
		this.selfDiagnosed = selfDiagnosed;
	}
	public Integer getPharmacistId() {
		return pharmacistId;
	}
	public void setPharmacistId(Integer pharmacistId) {
		this.pharmacistId = pharmacistId;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
