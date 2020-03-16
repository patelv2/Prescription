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

import com.prescription.Prescription.jpaentity.ReasonEntity;
import com.prescription.Prescription.service.ReasonService;


@RestController
@RequestMapping("/api")
public class ReasonController {
		
	@Autowired
	ReasonService reasonService;
	
	@GetMapping(path = "/reason/{id}")
	public ReasonEntity getReason(@PathVariable("id") Integer reasonId) {
		return reasonService.getReasonId(reasonId);
	}
	
	@GetMapping(path = "/reason")
	public List<ReasonEntity> getReasons() {
		return reasonService.getReasonIds();
	}
	
	@PostMapping(path = "reason")
	public ReasonEntity post(@RequestBody ReasonEntity reasonEntity) {
		
		return reasonService.save(reasonEntity);
	}
	
	@PatchMapping("/reason/{id}")
	public ResponseEntity<ReasonEntity> update(@RequestBody ReasonEntity reason, @PathVariable("id") Integer reasonId) {
		Boolean isReasonUpdated = reasonService.update(reason,reasonId);
		if (isReasonUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(reason);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping(path = "/reason/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer reasonId) {
		ReasonEntity reasonEntity = reasonService.delete(reasonId);
		if (reasonEntity.getActive().equalsIgnoreCase("N")) {
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	



}
