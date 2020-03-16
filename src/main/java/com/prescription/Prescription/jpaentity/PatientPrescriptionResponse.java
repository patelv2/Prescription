package com.prescription.Prescription.jpaentity;

public class PatientPrescriptionResponse {
	
	private String doctorFirstName;
	private String doctorLastName;
	private String doctorPhoneNumber;
	private String doctorEmail;
	private String pharmacistFirstName;
	private String pharmacistLastName;
	private String pharmacistPhoneNumber;
	private String pharmacistEmail;
	private String pharmacyName;
	private String pharmacyZipCode;
	private String createdAt;
	private String updatedAt;
	private String drugDosage;
	private String drugMinWeight;
	private String drugRefillFrequency;
	private String drugDosesPerDay;
	private String drugName;
	private String drugManufacturer;
	private String drugIsGeneric;
	private String drugFederalDrugIdentifier;
	private String reason;
	private String reasonDescription;
	private Integer prescriptionId;
	
	
	public PatientPrescriptionResponse(String doctorFirstName, String doctorLastName, String doctorPhoneNumber,
			String doctorEmail, String pharmacistFirstName, String pharmacistLastName, String pharmacistPhoneNumber,
			String pharmacistEmail, String pharmacyName, String pharmacyZipCode, String createdAt, String updatedAt,
			String drugDosage, String drugMinWeight, String drugRefillFrequency, String drugDosesPerDay,
			String drugName, String drugManufacturer, String drugIsGeneric, String drugFederalDrugIdentifier,
			String reason, String reasonDescription, Integer prescriptionId) {
		super();
		this.doctorFirstName = doctorFirstName;
		this.doctorLastName = doctorLastName;
		this.doctorPhoneNumber = doctorPhoneNumber;
		this.doctorEmail = doctorEmail;
		this.pharmacistFirstName = pharmacistFirstName;
		this.pharmacistLastName = pharmacistLastName;
		this.pharmacistPhoneNumber = pharmacistPhoneNumber;
		this.pharmacistEmail = pharmacistEmail;
		this.pharmacyName = pharmacyName;
		this.pharmacyZipCode = pharmacyZipCode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.drugDosage = drugDosage;
		this.drugMinWeight = drugMinWeight;
		this.drugRefillFrequency = drugRefillFrequency;
		this.drugDosesPerDay = drugDosesPerDay;
		this.drugName = drugName;
		this.drugManufacturer = drugManufacturer;
		this.drugIsGeneric = drugIsGeneric;
		this.drugFederalDrugIdentifier = drugFederalDrugIdentifier;
		this.reason = reason;
		this.reasonDescription = reasonDescription;
		this.prescriptionId = prescriptionId;
	}
	public String getDoctorFirstName() {
		return doctorFirstName;
	}
	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}
	public String getDoctorLastName() {
		return doctorLastName;
	}
	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}
	public String getDoctorPhoneNumber() {
		return doctorPhoneNumber;
	}
	public void setDoctorPhoneNumber(String doctorPhoneNumber) {
		this.doctorPhoneNumber = doctorPhoneNumber;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getPharmacistFirstName() {
		return pharmacistFirstName;
	}
	public void setPharmacistFirstName(String pharmacistFirstName) {
		this.pharmacistFirstName = pharmacistFirstName;
	}
	public String getPharmacistLastName() {
		return pharmacistLastName;
	}
	public void setPharmacistLastName(String pharmacistLastName) {
		this.pharmacistLastName = pharmacistLastName;
	}
	public String getPharmacistPhoneNumber() {
		return pharmacistPhoneNumber;
	}
	public void setPharmacistPhoneNumber(String pharmacistPhoneNumber) {
		this.pharmacistPhoneNumber = pharmacistPhoneNumber;
	}
	public String getPharmacistEmail() {
		return pharmacistEmail;
	}
	public void setPharmacistEmail(String pharmacistEmail) {
		this.pharmacistEmail = pharmacistEmail;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getPharmacyZipCode() {
		return pharmacyZipCode;
	}
	public void setPharmacyZipCode(String pharmacyZipCode) {
		this.pharmacyZipCode = pharmacyZipCode;
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
	public String getDrugDosage() {
		return drugDosage;
	}
	public void setDrugDosage(String drugDosage) {
		this.drugDosage = drugDosage;
	}
	public String getDrugMinWeight() {
		return drugMinWeight;
	}
	public void setDrugMinWeight(String drugMinWeight) {
		this.drugMinWeight = drugMinWeight;
	}
	public String getDrugRefillFrequency() {
		return drugRefillFrequency;
	}
	public void setDrugRefillFrequency(String drugRefillFrequency) {
		this.drugRefillFrequency = drugRefillFrequency;
	}
	public String getDrugDosesPerDay() {
		return drugDosesPerDay;
	}
	public void setDrugDosesPerDay(String drugDosesPerDay) {
		this.drugDosesPerDay = drugDosesPerDay;
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
	public String getDrugIsGeneric() {
		return drugIsGeneric;
	}
	public void setDrugIsGeneric(String drugIsGeneric) {
		this.drugIsGeneric = drugIsGeneric;
	}
	public String getDrugFederalDrugIdentifier() {
		return drugFederalDrugIdentifier;
	}
	public void setDrugFederalDrugIdentifier(String drugFederalDrugIdentifier) {
		this.drugFederalDrugIdentifier = drugFederalDrugIdentifier;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReasonDescription() {
		return reasonDescription;
	}
	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}
	public Integer getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	
	
	

}
