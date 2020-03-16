package com.prescription.Prescription.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prescription.Prescription.jpaentity.DrugEntity;
import com.prescription.Prescription.repository.DrugRepository;



@Service
public class DrugService {
	
	@Autowired
	DrugRepository drugRepository;
	
	public DrugEntity save(DrugEntity drugEntity) {
		drugEntity.setActive("Y");
		return drugRepository.save(drugEntity);
	}

	public DrugEntity getDrugId(Integer id) {
		DrugEntity drugEntity = drugRepository.findByDrugId(id);
		if (drugEntity.getActive().equalsIgnoreCase("Y")) {
			return drugEntity;
		} else {
			return null;

		}
	}
	
	public List<DrugEntity> getDrugIds() {
		List<DrugEntity> drugEntities = drugRepository.findAll();
		List<DrugEntity> deActiveEntities = new ArrayList<>();
		for(DrugEntity drugEntity : drugEntities) {
			if(drugEntity.getActive().equalsIgnoreCase("N")) {
				deActiveEntities.add(drugEntity);
			}
		}
		drugEntities.removeAll(deActiveEntities);
		return drugEntities;
	}
	
	public Boolean update(DrugEntity drug,Integer id) {
		DrugEntity drugEntityFromDB = getDrugId(id);
		if(drugEntityFromDB != null)
		{
			if (drug.getDrugManufacturer() != null) {
				drugEntityFromDB.setDrugManufacturer(drug.getDrugManufacturer());
			}
			if (drug.getDrugName() != null) {
				drugEntityFromDB.setDrugName(drug.getDrugName());
			}
			if (drug.getFederalDrugIdentifier() != null) {
				drugEntityFromDB.setFederalDrugIdentifier(drug.getFederalDrugIdentifier());
			}
			if (drug.getIsGeneric() != null) {
				drugEntityFromDB.setIsGeneric(drug.getIsGeneric());
			}
			save(drugEntityFromDB);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public DrugEntity delete(Integer id) {
		DrugEntity drugEntity = getDrugId(id);
		if(drugEntity != null) {
		drugEntity.setActive("N");
		drugRepository.save(drugEntity);
		}
		return drugEntity;
	}
	
}
