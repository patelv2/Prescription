package com.prescription.Prescription.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prescription.Prescription.jpaentity.PrescribableEntity;
import com.prescription.Prescription.repository.PrescribableRepository;



@Service
public class PrescribableService {

	@Autowired
	PrescribableRepository prescribableRepository;
	
	public PrescribableEntity save(PrescribableEntity prescribableEntity) {
		prescribableEntity.setActive("Y");
		return prescribableRepository.save(prescribableEntity);
	}

	public PrescribableEntity getPrescribableEntityId(Integer id) {
		PrescribableEntity prescribableEntity = prescribableRepository.findByPrescribableId(id);
		if (prescribableEntity.getActive().equalsIgnoreCase("Y")) {
			return prescribableEntity;
		} else {
			return null;

		}
	}
	
	
	public List<PrescribableEntity> getPrescribableEntityIds() {
		List<PrescribableEntity> prescribableEntities = prescribableRepository.findAll();
		List<PrescribableEntity> deActiveEntities = new ArrayList<>();
		for(PrescribableEntity prescribableEntity : prescribableEntities) {
			if(prescribableEntity.getActive().equalsIgnoreCase("N")) {
				deActiveEntities.add(prescribableEntity);
			}
		}
		prescribableEntities.removeAll(deActiveEntities);
		return prescribableEntities;
	}
	
	public Boolean update(PrescribableEntity prescribable,Integer id) {
		PrescribableEntity prescribableEntityFromDB = getPrescribableEntityId(id);
		if(prescribableEntityFromDB != null)
		{
			if (prescribable.getDosage() != null) {
				prescribableEntityFromDB.setDosage(prescribable.getDosage());
			}
			if (prescribable.getDosesPerDay() != null) {
				prescribableEntityFromDB.setDosesPerDay(prescribable.getDosesPerDay());
			}
			if (prescribable.getDrugId() != null) {
				prescribableEntityFromDB.setDrugId(prescribable.getDrugId());
			}
			if (prescribable.getMinWeight() != null) {
				prescribableEntityFromDB.setMinWeight(prescribable.getMinWeight());
			}
			if (prescribable.getPrescribableId() != null) {
				prescribableEntityFromDB.setPrescribableId(prescribable.getPrescribableId());
			}
			if (prescribable.getRefillFrequency() != null) {
				prescribableEntityFromDB.setRefillFrequency(prescribable.getRefillFrequency());
			}
			save(prescribableEntityFromDB);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public PrescribableEntity delete(Integer id) {
		PrescribableEntity prescribableEntity = getPrescribableEntityId(id);
		if (prescribableEntity != null) {
			prescribableEntity.setActive("N");
			prescribableRepository.save(prescribableEntity);
		}
		return prescribableEntity;
	}
	
}
