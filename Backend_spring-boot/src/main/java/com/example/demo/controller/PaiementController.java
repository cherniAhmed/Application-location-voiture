package com.example.demo.controller;

import java.time.LocalDateTime;
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

import com.example.demo.persistance.entities.Contact;
import com.example.demo.persistance.entities.Paiement; 
import com.example.demo.service.interfaces.IPaiement; 
@RestController
@RequestMapping("/api/paiement")
public class PaiementController {

    @Autowired
    IPaiement paiementService; 

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Paiement save(@RequestBody Paiement paiement) { 
        System.out.println("*******save ***********");
        Paiement p = paiementService.savePaiement(paiement); 
        return p;
    }

    @GetMapping("/{id}")
    Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiement(id); 
    }

    @GetMapping("/quantity")
    int getQuantityPaiement() { 
        return paiementService.getQuantityOfPaiement(); 
    }

   
    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        paiementService.deletePaiement(id); 
        return true;
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Paiement> getAllPaiemenets() {
        return paiementService.getAllPaiements();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaiement(@PathVariable Long id, @RequestBody Paiement updatedPaiement) {
        System.out.println("******update **********");

        // Retrieve the existing contact by ID
        Optional<Paiement> existingPaiementOptional = paiementService.getPaiementById(id);

        if (existingPaiementOptional.isPresent()) {
            Paiement existingPaiement = existingPaiementOptional.get();

            // Update the necessary fields
            existingPaiement.setMontant(updatedPaiement.getMontant());
            existingPaiement.setType_carte(updatedPaiement.getType_carte());
            existingPaiement.setNumero_carte(updatedPaiement.getNumero_carte());
            existingPaiement.setDate_expiration_carte(updatedPaiement.getDate_expiration_carte());
            
            // Save the updated contact
            Paiement updatedPaiementResult = paiementService.updatePaiement(existingPaiement);

            // Return the updated contact in the response
            return ResponseEntity.ok(updatedPaiementResult);
        } else {
            // Contact not found, return 404
            return ResponseEntity.notFound().build();
        }
    }


}
