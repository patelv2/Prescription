package com.prescription.Prescription.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.prescription.Prescription.jpaentity.PharmacyEntity;
import com.prescription.Prescription.service.PharmacyService;



@RestController
@RequestMapping("/api")
public class PharmacyController {
	
	@Autowired
	PharmacyService pharmacyService;
	
	@GetMapping(path = "/pharmacy/{id}")
	public PharmacyEntity getPharmacy(@PathVariable("id") Integer pharmacyId) {
		return pharmacyService.getPharmacyId(pharmacyId);
	}
	
	@GetMapping(path = "/pharmacy")
	public List<PharmacyEntity> getPharmacies() {
		return pharmacyService.getPharmacyIds();
	}
	
	@PostMapping(path = "/pharmacy")
	public PharmacyEntity post(@RequestBody PharmacyEntity pharmacyEntity) {
		
		return pharmacyService.save(pharmacyEntity);
	}
	
	@PatchMapping("/pharmacy/{id}")
	public ResponseEntity<PharmacyEntity> update(@RequestBody PharmacyEntity pharmacy, @PathVariable("id") Integer pharmacyId) {
		Boolean isPharmacyUpdated = pharmacyService.update(pharmacy,pharmacyId);
		if (isPharmacyUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(pharmacy);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping(path = "/pharmacy/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer pharmacyId) {
		PharmacyEntity pharmacyEntity = pharmacyService.delete(pharmacyId);
		if (pharmacyEntity.getActive().equalsIgnoreCase("N")) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	


	

}
