package com.prescription.Prescription.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prescription.Prescription.jpaentity.PrescriptionPrescribableDrugEntity;

public interface PrescriptionPrescribableDrugRepository extends JpaRepository<PrescriptionPrescribableDrugEntity, Long>{

	PrescriptionPrescribableDrugEntity findByPrescriptionPrescribableDrugId(Integer prescriptionPrescribableDrugId);
	
	List<PrescriptionPrescribableDrugEntity> findByPrescriptionId(Integer prescriptionId);
	
}
