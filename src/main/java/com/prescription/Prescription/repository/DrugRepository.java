package com.prescription.Prescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prescription.Prescription.jpaentity.DrugEntity;

public interface DrugRepository extends JpaRepository<DrugEntity, Long>{

	DrugEntity findByDrugId(Integer drugId);
	
//	@Query("select * from Drug")
//	List<Long> getAllIds();

}
