package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.dao.ClientRepository;
import com.example.demo.persistance.dao.VoitureRepository;
import com.example.demo.persistance.entities.Client;
import com.example.demo.persistance.entities.Reservation;
import com.example.demo.persistance.entities.Voiture;
import com.example.demo.service.interfaces.IReservation;


@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    IReservation reservationService; // Changed from IPaiement to IReservation
    
    private ClientRepository clientRepository;
    private VoitureRepository voitureRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Reservation save(@RequestBody Reservation reservation) { 
        System.out.println("*******save ***********");
        Reservation r = reservationService.saveReservation(reservation); 
        return r;
    }

    @GetMapping("/{id}")
    Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservation(id); 
    }

    @GetMapping("/quantity")
    int getQuantityReservation() { 
        return reservationService.getQuantityOfReservation(); 
    }

    

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        reservationService.deleteReservation(id); 
        return true;
    }
    
    @GetMapping
    List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
        
    }
 

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
            // Retrieve the existing reservation by ID
            Optional<Reservation> existingReservationOptional = reservationService.getReservationById(id);

            if (existingReservationOptional.isPresent()) {
                Reservation existingReservation = existingReservationOptional.get();

                // Update the necessary fields
                existingReservation.setDate_debut(updatedReservation.getDate_debut());
                existingReservation.setDate_fin(updatedReservation.getDate_fin());
                
                // Save the updated reservation
                Reservation updatedReservationResult = reservationService.updateReservation(existingReservation);

                // Return the updated reservation in the response
                return ResponseEntity.ok(updatedReservationResult);
            } else {
                // Reservation not found, return 404
                return ResponseEntity.notFound().build();
            }
        }
    

}