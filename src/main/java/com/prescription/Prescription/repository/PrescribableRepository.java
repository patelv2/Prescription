package com.prescription.Prescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prescription.Prescription.jpaentity.PrescribableEntity;

public interface PrescribableRepository extends JpaRepository<PrescribableEntity, Long>{

	PrescribableEntity findByPrescribableId(Integer prescribableId);

}
