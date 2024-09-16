package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Facture;
import com.example.demo.service.interfaces.IFacture;

@RestController
@RequestMapping("/api/facture")
public class FactureController {
	@Autowired
	IFacture factureService;
	private IFacture service;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Facture save(@RequestBody Facture facture) {	
		  System.out.println("*******save ***********");
		  Facture f=factureService.saveFacture(facture);
		  System.out.println("*******"+f.getNumero());
        return f  ;
    }
	
	@GetMapping("/{id}")
	Facture getFactureById(@PathVariable Long id) {
        return factureService.getFacture(id);
    }
	
	
	
	@GetMapping("/FactureBynumero/{numero}")
	Facture getFactureBynumero(@PathVariable Long numero) {
        return factureService.findFactureBynumero(numero);
    }

	
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
		service.deleteFacture(id);
        return true;
    }
	
	@GetMapping
	List<Facture> getAllFactures() {
	    return factureService.getAllFactures();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateFacture(@PathVariable Long id, @RequestBody Facture updatedFacture) {
	    System.out.println("******update **********");

	    // Retrieve the existing facture by ID
	    Optional<Facture> existingFactureOptional = factureService.getFactureById(id);

	    if (existingFactureOptional.isPresent()) {
	        Facture existingFacture = existingFactureOptional.get();

	        // Update the necessary fields
	        existingFacture.setMontant(updatedFacture.getMontant());
	        existingFacture.setNumero(updatedFacture.getNumero());
	        existingFacture.setDate_facture(updatedFacture.getDate_facture());
	        
	        // Save the updated facture
	        Facture updatedFactureResult = factureService.updateFacture(existingFacture);

	        // Return the updated facture in the response
	        return ResponseEntity.ok(updatedFactureResult);
	    } else {
	        // Facture not found, return 404
	        return ResponseEntity.notFound().build();
	    }
	}

}