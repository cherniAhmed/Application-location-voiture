package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Agence;
import com.example.demo.service.interfaces.IAgence;

@RestController
@RequestMapping("/api/agence")
public class AgenceController {
	@Autowired
	IAgence agenceService;
	private IAgence service;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Agence save(@RequestBody Agence agence) {	
		  System.out.println("*******save ***********");
		  Agence a=agenceService.saveAgence(agence);
		  System.out.println("*******"+a.getNom());
        return a  ;
    }
	
	@GetMapping("/{id}")
	Agence getAgenceById(@PathVariable Long id) {
        return agenceService.getAgence(id);
    }
	
	@GetMapping("/quantity")
    int getQuantityAgence() {
        return agenceService.getQuantityOfAgence();
    }
	
	@GetMapping("/AgenceBynom/{nomag}")
	Agence getAgencebyName(@PathVariable String name) {
        return agenceService.findAgenceByName(name);
    }
	
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
		service.deleteAgence(id);
        return true;
    }
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	List<Agence> getAllAgences() {
	    return agenceService.getAllAgences();
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAgence(@PathVariable Long id, @RequestBody Agence updatedAgence) {
	    System.out.println("******update **********");

	    // Retrieve the existing patient by ID
	    Optional<Agence> existingAgenceOptional = agenceService.getAgenceById(id);

	    if (existingAgenceOptional.isPresent()) {
	        Agence existingAgence = existingAgenceOptional.get();

	        // Update the necessary fields
	        existingAgence.setNom(updatedAgence.getNom());
	        existingAgence.setCouladresse(updatedAgence.getCouladresse());
	        existingAgence.setTel(updatedAgence.getTel());
	        existingAgence.setDate_creation(updatedAgence.getDate_creation());
	        existingAgence.setDescription(updatedAgence.getDescription());
	        


	        // Save the updated patient
	        Agence updatedAgenceResult = agenceService.updateAgence(existingAgence);

	        // Return the updated patient in the response
	        return ResponseEntity.ok(updatedAgenceResult);
	    } else {
	        // Patient not found, return 404
	        return ResponseEntity.notFound().build();
	    }
	}

}