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

import com.prescription.Prescription.jpaentity.PrescribableEntity;
import com.prescription.Prescription.service.PrescribableService;


@RestController
@RequestMapping("/api")
public class PrescribableController {
	
	@Autowired
	PrescribableService prescribableService;
	
	@GetMapping(path = "/prescribable/{id}")
	public PrescribableEntity getPatient(@PathVariable("id") Integer prescribableId) {
		return prescribableService.getPrescribableEntityId(prescribableId);
	}
	
	@GetMapping(path = "/prescribable")
	public List<PrescribableEntity> getPrescribableEntities() {
		return prescribableService.getPrescribableEntityIds();
	}
	
	@PostMapping(path = "/prescribable")
	public PrescribableEntity post(@RequestBody PrescribableEntity prescribableEntity) {
		
		return prescribableService.save(prescribableEntity);
	}
	
	@PatchMapping("/prescribable/{id}")
	public ResponseEntity<PrescribableEntity> update(@RequestBody PrescribableEntity prescribable, @PathVariable("id") Integer prescribableId) {
		Boolean isPrescribableUpdated = prescribableService.update(prescribable,prescribableId);
		if (isPrescribableUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(prescribable);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping(path = "/prescribable/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer prescribableId) {
		PrescribableEntity prescribableEntity = prescribableService.delete(prescribableId);
		if (prescribableEntity.getActive().equalsIgnoreCase("N")) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
