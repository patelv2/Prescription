package com.prescription.Prescription.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prescription.Prescription.jpaentity.PrescriptionEntity;

public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Long> {
 
	PrescriptionEntity findByPrescriptionId(Integer prescriptionId);

	List<PrescriptionEntity> findByPatientId(Integer patientId);

}
