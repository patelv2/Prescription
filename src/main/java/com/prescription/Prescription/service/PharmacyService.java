package com.prescription.Prescription.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prescription.Prescription.jpaentity.PharmacyEntity;
import com.prescription.Prescription.repository.PharmacyRepository;



@Service
public class PharmacyService {
	
	@Autowired
	PharmacyRepository pharmacyRepository;
	
	public PharmacyEntity save(PharmacyEntity pharmacyEntity) {
		pharmacyEntity.setActive("Y");
		return pharmacyRepository.save(pharmacyEntity);
	}

	public PharmacyEntity getPharmacyId(Integer id) {
		PharmacyEntity pharmacyEntity = pharmacyRepository.findByPharmacyId(id);
		if (pharmacyEntity.getActive().equalsIgnoreCase("Y")) {
			return pharmacyEntity;
		} else {
			return null;

		}
	}
	
	public List<PharmacyEntity> getPharmacyIds() {
		List<PharmacyEntity> pharmacyEntities = pharmacyRepository.findAll();
		List<PharmacyEntity> deActiveEntities = new ArrayList<>();
		for(PharmacyEntity pharmacyEntity : pharmacyEntities) {
			if(pharmacyEntity.getActive().equalsIgnoreCase("N")) {
				deActiveEntities.add(pharmacyEntity);
			}
		}
		pharmacyEntities.removeAll(deActiveEntities);
		return pharmacyEntities;
	}
	
	public Boolean update(PharmacyEntity pharmacy,Integer id) {
		PharmacyEntity pharmacyEntityFromDB = getPharmacyId(id);
		if(pharmacyEntityFromDB != null)
		{
			if (pharmacy.getPharmacyName() != null) {
				pharmacyEntityFromDB.setPharmacyName(pharmacy.getPharmacyName());
			}
			if (pharmacy.getZipCode() != null) {
				pharmacyEntityFromDB.setZipCode(pharmacy.getZipCode());
			}
			save(pharmacyEntityFromDB);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public PharmacyEntity delete(Integer id) {
		PharmacyEntity pharmacyEntity = getPharmacyId(id);
		if (pharmacyEntity != null) {
			pharmacyEntity.setActive("N");
			pharmacyRepository.save(pharmacyEntity);
		}
		return pharmacyEntity;
	}

}
