package com.prescription.Prescription.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.prescription.Prescription.jpaentity.Drug;
import com.prescription.Prescription.jpaentity.PatientPrescriptionResponse;
import com.prescription.Prescription.jpaentity.PrescribableEntity;
import com.prescription.Prescription.jpaentity.Prescription;
import com.prescription.Prescription.jpaentity.PrescriptionEntity;
import com.prescription.Prescription.jpaentity.PrescriptionPrescribableDrugEntity;
import com.prescription.Prescription.repository.PrescriptionRepository;



@Service
public class PrescriptionService {
	
	@Autowired
	PrescriptionRepository prescriptionRepository;

	@Autowired
	PrescriptionPrescribableDrugService prescriptionPrescribableDrugService;
	
	@Autowired 
	PrescribableService prescribableService;
	
	DateFormat dtf = new SimpleDateFormat("MM/dd/yyyy");
	
	DateFormat dtfParser = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	
	
	public PrescriptionEntity save(Prescription prescription) throws ParseException {
		PrescriptionEntity insertedPrescriptionEntity = new PrescriptionEntity();
		// check is any existing record is exist?
		Map<Integer, Date> notEligibleItemMap = checkPatienEligiblinessForMedicine(prescription);
		List<Drug> removalNotEligibleItemList = new ArrayList<>();
		if (!notEligibleItemMap.isEmpty()) {
			for (Map.Entry<Integer, Date> notEligibleItem : notEligibleItemMap.entrySet()) {
				for (Drug drug : prescription.getDrug()) {
					if (drug.getPrescribableId().equals(notEligibleItem.getKey())) {
						removalNotEligibleItemList.add(drug);
					}
				}
			}
			prescription.getDrug().removeAll(removalNotEligibleItemList);
		}
		if (!prescription.getDrug().isEmpty()) {
			Date date = new Date();
			PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
			prescriptionEntity.setDoctorId(prescription.getDoctorId());
			prescriptionEntity.setPatientId(prescription.getPatientId());
			prescriptionEntity.setPharmacistId(prescription.getPharmacistId());
			prescriptionEntity.setPharmacyId(prescription.getPharmacyId());
			prescriptionEntity.setReasonId(prescription.getReasonId());
			prescriptionEntity.setSelfDiagnosed(prescription.getSelfDiagnosed());
			prescriptionEntity.setActive("Y");
			insertedPrescriptionEntity = prescriptionRepository.save(prescriptionEntity);
			for (Drug drug : prescription.getDrug()) {
				PrescriptionPrescribableDrugEntity prescriptionPrescribableDrugEntity = new PrescriptionPrescribableDrugEntity();
				prescriptionPrescribableDrugEntity.setActive("Y");
				prescriptionPrescribableDrugEntity.setCreatedAt(dtf.format(date));
				prescriptionPrescribableDrugEntity.setUpdatedAt(dtf.format(date));
				prescriptionPrescribableDrugEntity.setPrescribableId(drug.getPrescribableId());
				prescriptionPrescribableDrugEntity.setPrescriptionId(insertedPrescriptionEntity.getPrescriptionId());
				prescriptionPrescribableDrugService.save(prescriptionPrescribableDrugEntity);
			}
		}
		insertedPrescriptionEntity.setErrorMessage(notEligibleItemMap.toString());
		return insertedPrescriptionEntity;
	}

	public PrescriptionEntity getPrescriptionId(Integer prescriptionId) {
		PrescriptionEntity prescriptionPatientResponses = prescriptionRepository.findByPrescriptionId(prescriptionId);
		return prescriptionPatientResponses;
	}
	
	public PrescriptionEntity printgetPrescriptionId(Integer prescriptionId) {
		List<PatientPrescriptionResponse> prescriptionResponses = findByPatientId(prescriptionId);
		PrescriptionEntity prescriptionPatientResponses = prescriptionRepository.findByPrescriptionId(prescriptionId);
		return prescriptionPatientResponses;
	}
	
	public List<PatientPrescriptionResponse> findByPatientId(Integer prescriptionId) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("PatientId", prescriptionId);
      
        return jdbcTemplate.query(
        		"SELECT U1.firstName AS doctorFirstName, U1.lastName AS doctorLastName, U1.phoneNumber AS doctorPhoneNumber, "+ 
        		"U1. email AS doctorEmail, U2.FIRSTNAME AS pharmacistFirstName, U2.lastName AS pharmacistLastName, "+
        		"U2.phoneNumber AS pharmacistPhoneNumber, U2. email AS pharmacistEmail, Pharmacy.PharmacyName AS pharmacyName, Pharmacy.ZipCode AS pharmacyZipCode, PrescriptionPrescribableDrug.CreatedAt AS createdAt, "+ 
        		"PrescriptionPrescribableDrug.UpdatedAt AS updatedAt, Prescribable.Dosage AS drugDosage, Prescribable.MinWeight AS drugMinWeight, Prescribable.RefillFrequency AS drugRefillFrequency, "+
        		"Prescribable.DosesPerDay AS drugDosesPerDay, DRUG.DrugName AS drugName, Drug.DrugManufacturer AS drugManufacturer, Drug.IsGeneric AS drugIsGeneric, Drug.FederalDrugIdentifier AS drugFederalDrugIdentifier, Reason.Reason AS reason, "+
        		"Reason.DESCRIPTION AS reasonDescription, Prescription.PrescriptionId AS prescriptionId "+
        		"FROM Prescription INNER JOIN Users U1 ON U1.id = Prescription.DoctorId "+
        		"INNER JOIN Users U2 ON U2.id = Prescription.PharmacistId "+
        		"INNER JOIN Pharmacy on Pharmacy.PharmacyId = Prescription.PharmacyId "+
        		"INNER JOIN PrescriptionPrescribableDrug on PrescriptionPrescribableDrug.PrescriptionId = Prescription.PrescriptionId "+
        		"INNER JOIN Prescribable on Prescribable.PrescribableId = PrescriptionPrescribableDrug.PrescribableId "+
        		"INNER JOIN Drug on Drug.DrugId = Prescribable.DrugId "+
        		"INNER JOIN Reason on Reason.ReasonId = Prescription.ReasonId "+
                "Where Prescription.PatientId = :PatientId",
                mapSqlParameterSource,
                (rs, rowNum) ->
                        new PatientPrescriptionResponse(
                                rs.getString("doctorFirstName"), rs.getString("doctorLastName"), rs.getString("doctorPhoneNumber"),
                                rs.getString("doctorEmail"), rs.getString("pharmacistFirstName"), rs.getString("pharmacistLastName"),
                                rs.getString("pharmacistPhoneNumber"), rs.getString("pharmacistEmail"), rs.getString("pharmacyName"),
                                rs.getString("pharmacyZipCode"), rs.getString("createdAt"), rs.getString("updatedAt"), rs.getString("drugDosage"),
                                rs.getString("drugMinWeight"), rs.getString("drugRefillFrequency"), rs.getString("drugDosesPerDay"), 
                                rs.getString("drugName"), rs.getString("drugManufacturer"), rs.getString("drugIsGeneric"), rs.getString("drugFederalDrugIdentifier"),
                                rs.getString("reason"), rs.getString("reasonDescription"), rs.getInt("prescriptionId")
                        )
        );
    }
	
	
	
	public Map<Integer,Date> checkPatienEligiblinessForMedicine(Prescription prescription) throws ParseException {
		Map<Integer,Date> latestUpdatetdDrugMap = new HashMap<>();
		Map<Integer,Integer> drugMapWithRefillFrquency = new HashMap<>();
		Map<Integer,Date> notEliglibeItemMap = new HashMap<>();
		List<PrescriptionEntity> prescriptionEntity = prescriptionRepository
				.findByPatientId(prescription.getPatientId());
		List<PrescriptionPrescribableDrugEntity> prescriptionPrescribableDrugEntityList = new ArrayList<>();
		for (PrescriptionEntity presc : prescriptionEntity) {
			prescriptionPrescribableDrugEntityList.addAll(prescriptionPrescribableDrugService
					.getPrescriptionPrescribableBasedOnPrescriptionId(presc.getPrescriptionId()));
		}
	
		for(PrescriptionPrescribableDrugEntity ppDrugEntity : prescriptionPrescribableDrugEntityList) {
			latestUpdatetdDrugMap.put(ppDrugEntity.getPrescribableId(), dtfParser.parse(ppDrugEntity.getUpdatedAt()));
		}
		
		for(Map.Entry<Integer,Date> drugMap : latestUpdatetdDrugMap.entrySet()) {
			PrescribableEntity prescribableEntity = prescribableService.getPrescribableEntityId(drugMap.getKey()); 
			drugMapWithRefillFrquency.put(drugMap.getKey(), prescribableEntity.getRefillFrequency());
		}
		
		for(Map.Entry<Integer,Date> drugMap : latestUpdatetdDrugMap.entrySet()) {
			for(Map.Entry<Integer, Integer> drugMapWithRefill : drugMapWithRefillFrquency.entrySet()) {
				if(drugMapWithRefill.getKey().equals(drugMap.getKey())) {
					Date date = new Date();
					Calendar c = Calendar.getInstance();
			        c.setTime(drugMap.getValue());
			        c.add(Calendar.DATE, drugMapWithRefill.getValue());
			        Date currentDatePlusOne = c.getTime();
			    
			        if(currentDatePlusOne.compareTo(date) > 0) {
			        	System.out.println("Date1 is after Date2");
			        	notEliglibeItemMap.put(drugMap.getKey(), currentDatePlusOne);
			        }
				}
			}
		}
		return notEliglibeItemMap;
		

	}

	private Prescription buildPrescrption(PrescriptionEntity prescriptionEntity) {
		Prescription prescription = new Prescription();
		prescription.setDoctorId(prescriptionEntity.getDoctorId());
		prescription.setPatientId(prescriptionEntity.getPatientId());
		prescription.setPharmacistId(prescriptionEntity.getPharmacistId());
		prescription.setPharmacyId(prescriptionEntity.getPharmacyId());
		prescription.setReasonId(prescriptionEntity.getReasonId());
		prescription.setSelfDiagnosed(prescriptionEntity.getSelfDiagnosed());
		
		if (prescriptionEntity.getActive().equalsIgnoreCase("Y")) {
			List<PrescriptionPrescribableDrugEntity> prescriptionPrescribableDrugEntityList = prescriptionPrescribableDrugService.getPrescriptionPrescribableBasedOnPrescriptionId(prescriptionEntity.getPrescriptionId());
			List<Drug> drugList = new ArrayList<>();
			for(PrescriptionPrescribableDrugEntity prescriptionPrescribableDrugEntity : prescriptionPrescribableDrugEntityList) {
				Drug drug = new Drug();
				drug.setPrescribableId(prescriptionPrescribableDrugEntity.getPrescribableId());
				drugList.add(drug);
			}
			prescription.setDrug(drugList);
			return prescription;
		} else {
			return null;

		}
	}
	
	public Boolean update(PrescriptionEntity prescription,Integer id) {
		PrescriptionEntity prescriptionEntityFromDB = prescriptionRepository.findByPrescriptionId(id);
		if(prescriptionEntityFromDB != null)
		{
			if (prescription.getPharmacistId() != null) {
				prescriptionEntityFromDB.setPharmacistId(prescription.getPharmacistId());
			}
			if (prescription.getPharmacyId() != null) {
				prescriptionEntityFromDB.setPharmacyId(prescription.getPharmacyId());
			}
			if (prescription.getReasonId() != null) {
				prescriptionEntityFromDB.setReasonId(prescription.getReasonId());
			}
			if (prescription.getSelfDiagnosed() != null) {
				prescriptionEntityFromDB.setSelfDiagnosed(prescription.getSelfDiagnosed());
			}
			prescriptionRepository.save(prescriptionEntityFromDB);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public PrescriptionEntity delete(Integer id) {
		PrescriptionEntity prescriptionEntity = prescriptionRepository.findByPrescriptionId(id);
		if (prescriptionEntity != null) {
			prescriptionEntity.setActive("N");
			prescriptionRepository.save(prescriptionEntity);
		}
		return prescriptionEntity;
	}
	

	
}
