package com.example.demo.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.persistance.entities.Client;
import com.example.demo.persistance.entities.Reservation;
import com.example.demo.persistance.entities.Voiture; 

public interface IReservation { 

    Reservation saveReservation(Reservation reservation); 
    Reservation updateReservation(Reservation reservation); 
    boolean deleteReservation(Long id); 
    List<Reservation> getListReservation(); 
    Reservation getReservation(Long id);  
    int getQuantityOfReservation(); 
    Reservation getReservationByIdReservation(Long id); 
    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(Long id);
	

}
