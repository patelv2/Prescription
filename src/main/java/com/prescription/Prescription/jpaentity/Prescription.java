package com.prescription.Prescription.jpaentity;

import java.util.List;

public class Prescription {

	private Integer patientId;

	private Integer pharmacyId;

	private Integer doctorId;

	private Integer reasonId;

	private String selfDiagnosed;

	private Integer pharmacistId;
	
	private List<Drug> drug;
	
	private String errorMessage;

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

	public List<Drug> getDrug() {
		return drug;
	}

	public void setDrug(List<Drug> drug) {
		this.drug = drug;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

	
	
	
	
	
}
