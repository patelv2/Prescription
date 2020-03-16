package com.prescription.Prescription.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prescription.Prescription.jpaentity.PatientPrescriptionResponse;
import com.prescription.Prescription.jpaentity.Prescription;
import com.prescription.Prescription.jpaentity.PrescriptionEntity;
import com.prescription.Prescription.service.PrescriptionService;


@RestController
@RequestMapping("/api")
public class PrescriptionController {
	
	@Autowired
	PrescriptionService prescriptionService;
	
	@GetMapping(path = "/prescription/{id}")
	public PrescriptionEntity getPrescriptionDetail(@PathVariable("id") Integer prescriptionId) {
		return prescriptionService.printgetPrescriptionId(prescriptionId);
	}
	
	@GetMapping(path = "/prescriptions")
	public List<PatientPrescriptionResponse> getPrescriptionDetailBasedOnPatient(@RequestParam("patientId") Integer patientId) {
		return prescriptionService.findByPatientId(patientId);
	}
	
	@PostMapping(path = "/prescription")
	public PrescriptionEntity post(@RequestBody Prescription prescription) throws ParseException {
		
		return prescriptionService.save(prescription);
	}
	
	@PatchMapping("/prescription/{id}")
	public ResponseEntity<PrescriptionEntity> update(@RequestBody PrescriptionEntity prescription, @PathVariable("id") Integer prescriptionId) {
		Boolean isPrescriptionUpdated = prescriptionService.update(prescription,prescriptionId);
		if (isPrescriptionUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(prescription);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping(path = "/prescription/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer prescriptionId) {
		PrescriptionEntity prescriptionEntity = prescriptionService.delete(prescriptionId);
		if (prescriptionEntity.getActive().equalsIgnoreCase("N")) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	



}
