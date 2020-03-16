package com.prescription.Prescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prescription.Prescription.jpaentity.PharmacyEntity;

public interface PharmacyRepository extends JpaRepository<PharmacyEntity, Long>{

	PharmacyEntity findByPharmacyId(Integer pharmacyId);
	
}
