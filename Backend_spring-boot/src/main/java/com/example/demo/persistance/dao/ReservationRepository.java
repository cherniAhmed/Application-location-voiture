package com.example.demo.persistance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Client;
import com.example.demo.persistance.entities.Reservation;
import com.example.demo.persistance.entities.Voiture; 

public interface ReservationRepository extends JpaRepository<Reservation, Long> { 

    @Query(value = "select count(*) from reservation", nativeQuery = true) 
    int getQuantityOfReservation(); 

    @Query(value = "select * from reservation where id= :id", nativeQuery = true) 
    Reservation getReservationByIdReservation(@Param("id") Long id);

	
}

