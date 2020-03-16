package com.prescription.Prescription.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prescription.Prescription.jpaentity.ReasonEntity;
import com.prescription.Prescription.repository.ReasonRepository;



@Service
public class ReasonService {

	@Autowired
	ReasonRepository reasonRepository;
	
	public ReasonEntity save(ReasonEntity reasonEntity) {
		reasonEntity.setActive("Y");
		return reasonRepository.save(reasonEntity);
	}

	public ReasonEntity getReasonId(Integer id) {
		ReasonEntity reasonEntity = reasonRepository.findByReasonId(id);
		if (reasonEntity.getActive().equalsIgnoreCase("Y")) {
			return reasonEntity;
		} else {
			return null;

		}
	}
	
	public List<ReasonEntity> getReasonIds() {
		List<ReasonEntity> reasonEntities = reasonRepository.findAll();
		List<ReasonEntity> deActiveEntities = new ArrayList<>();
		for(ReasonEntity reasonEntity : reasonEntities) {
			if(reasonEntity.getActive().equalsIgnoreCase("N")) {
				deActiveEntities.add(reasonEntity);
			}
		}
		reasonEntities.removeAll(deActiveEntities);
		return reasonEntities;
	}
	
	public Boolean update(ReasonEntity reason,Integer id) {
		ReasonEntity reasonEntityFromDB = getReasonId(id);
		if(reasonEntityFromDB != null)
		{
			if (reason.getReason() != null) {
				reasonEntityFromDB.setReason(reason.getReason());
			}
			if (reason.getDescription() != null) {
				reasonEntityFromDB.setDescription(reason.getDescription());
			}
			save(reasonEntityFromDB);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public ReasonEntity delete(Integer id) {
		ReasonEntity reasonEntity = getReasonId(id);
		if (reasonEntity != null) {
			reasonEntity.setActive("N");
			reasonRepository.save(reasonEntity);
		}
		return reasonEntity;
	}
}
