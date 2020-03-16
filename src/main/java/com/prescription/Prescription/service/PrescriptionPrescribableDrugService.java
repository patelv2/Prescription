package com.prescription.Prescription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prescription.Prescription.jpaentity.PrescriptionPrescribableDrugEntity;
import com.prescription.Prescription.repository.PrescriptionPrescribableDrugRepository;



@Service
public class PrescriptionPrescribableDrugService {

	@Autowired
	PrescriptionPrescribableDrugRepository prescriptionPrescribableDrugRepository;
	
	public PrescriptionPrescribableDrugEntity save(
			PrescriptionPrescribableDrugEntity prescriptionPrescribableDrugEntity) {
		return prescriptionPrescribableDrugRepository.save(prescriptionPrescribableDrugEntity);
	}
	
	public List<PrescriptionPrescribableDrugEntity> getPrescriptionPrescribableBasedOnPrescriptionId(
			Integer prescriptionId) {
		return prescriptionPrescribableDrugRepository.findByPrescriptionId(prescriptionId);
	}
}
