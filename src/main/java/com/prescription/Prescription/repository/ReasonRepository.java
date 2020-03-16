package com.prescription.Prescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prescription.Prescription.jpaentity.ReasonEntity;

public interface ReasonRepository extends JpaRepository<ReasonEntity, Long> {
	
	ReasonEntity findByReasonId(Integer reasonId);

}
