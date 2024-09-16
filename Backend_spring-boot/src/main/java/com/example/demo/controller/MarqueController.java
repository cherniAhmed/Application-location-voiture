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

import com.example.demo.persistance.entities.Marque;
import com.example.demo.service.interfaces.IMarque;

@RestController
@RequestMapping("/api/marque")
public class MarqueController  {
	@Autowired
	IMarque marqueService;
	private IMarque service;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Marque save(@RequestBody Marque marque) {	
		  System.out.println("*******save ***********");
		  Marque m=marqueService.saveMarque(marque);
		  System.out.println("*******"+m.getNomMar());
        return m  ;
    }
	
	@GetMapping("/{id}")
	Marque getMarqueById(@PathVariable Long id) {
        return marqueService.getMarque(id);
    }
	
	@GetMapping("/MarqueBynom/{nomag}")
	Marque getMarquebyName(@PathVariable String name) {
        return marqueService.findMarquebynomMar(name);
    }
	
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
		service.deleteMarque(id);
        return true;
    }
	
	@GetMapping
	List<Marque> getAllMarques() {
	    return marqueService.getAllMarques();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateMarque(@PathVariable Long id, @RequestBody Marque updatedMarque) {
	    System.out.println("******update **********");

	    // Retrieve the existing marque by ID
	    Optional<Marque> existingMarqueOptional = marqueService.getMarqueById(id);

	    if (existingMarqueOptional.isPresent()) {
	        Marque existingMarque = existingMarqueOptional.get();

	        // Update the necessary fields
	        existingMarque.setNomMar(updatedMarque.getNomMar());
	        

	        // Save the updated marque
	        Marque updatedMarqueResult = marqueService.updateMarque(existingMarque);

	        // Return the updated marque in the response
	        return ResponseEntity.ok(updatedMarqueResult);
	    } else {
	        // Marque not found, return 404
	        return ResponseEntity.notFound().build();
	    }
	}

}