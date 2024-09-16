package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Voiture;
import com.example.demo.service.interfaces.IVoiture;

@RestController
@RequestMapping("/api/voiture")
public class VoitureController {
	@Autowired
	IVoiture voitureService;
	private IVoiture service;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Voiture save(@RequestBody Voiture voiture) {	
		  System.out.println("*******save ***********");
		  Voiture v=voitureService.saveVoiture(voiture);
		  System.out.println("*******"+v.getMatricule());
        return v ;
    }
	
	@GetMapping("/{id}")
	Voiture getVoitureById(@PathVariable Long id) {
        return voitureService.getVoiture(id);
    }
	
	
	@GetMapping("/voitureBycoulour/{couleur}")
	Voiture getVoitureByCouleur(String couleur) {
        return voitureService.findVoitureByCouleur(couleur);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVoiture(@PathVariable Long id) {
	    boolean deleted = voitureService.deleteVoiture(id);
	    if (deleted) {
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	
	@GetMapping
	List<Voiture> getAllVoitures() {
	    return voitureService.getAllVoitures();
	}
	
	@PostMapping("/reserver-voiture")
    public ResponseEntity<Object> reserverVoiture(@RequestBody Voiture voiture) {
        
        voitureService.reserveVoiture(voiture);

        return ResponseEntity.ok().build();
    }

	@PutMapping("/{id}")
	public ResponseEntity<?> updateVoiture(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
	    System.out.println("******update **********");

	    // Retrieve the existing voiture by ID
	    Optional<Voiture> existingVoitureOptional = voitureService.getVoitureById(id);

	    if (existingVoitureOptional.isPresent()) {
	        Voiture existingVoiture = existingVoitureOptional.get();

	        // Update the necessary fields
	        existingVoiture.setMatricule(updatedVoiture.getMatricule());
	        existingVoiture.setCouleur(updatedVoiture.getCouleur());
	        existingVoiture.setModele(updatedVoiture.getModele());
	        existingVoiture.setDate_fab(updatedVoiture.getDate_fab());
	        existingVoiture.setPrix_location(updatedVoiture.getPrix_location());
	        existingVoiture.setImageUrl(updatedVoiture.getImageUrl());

	        
	        // Save the updated voiture
	        Voiture updatedVoitureResult = voitureService.updateVoiture(existingVoiture);

	        // Return the updated voiture in the response
	        return ResponseEntity.ok(updatedVoitureResult);
	    } else {
	        // Voiture not found, return 404
	        return ResponseEntity.notFound().build();
	    }
	}
	

}