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

import com.prescription.Prescription.jpaentity.DrugEntity;
import com.prescription.Prescription.service.DrugService;


@RestController
@RequestMapping("/api")
public class DrugController {
	
	@Autowired
	DrugService drugService;
	
	@GetMapping(path = "/drug/{id}")
	public DrugEntity getPatient(@PathVariable("id") Integer drugId) {
		return drugService.getDrugId(drugId);
	}
	
	@GetMapping(path = "/drug")
	public List<DrugEntity> getPatients() {
		return drugService.getDrugIds();
	}
	
	@PostMapping(path = "/drug")
	public DrugEntity post(@RequestBody DrugEntity drugEntity) {
		
		return drugService.save(drugEntity);
	}
	
	@PatchMapping("/drug/{id}")
	public ResponseEntity<DrugEntity> update(@RequestBody DrugEntity drug, @PathVariable("id") Integer drugId) {
		Boolean isDrugUpdated = drugService.update(drug,drugId);
		if (isDrugUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(drug);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping(path = "/drug/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer drugId) {
		DrugEntity drugEntity = drugService.delete(drugId);
		if (drugEntity.getActive().equalsIgnoreCase("N")) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
