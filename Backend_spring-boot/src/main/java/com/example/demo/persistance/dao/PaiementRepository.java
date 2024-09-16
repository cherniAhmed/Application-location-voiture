package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Paiement; 

public interface PaiementRepository extends JpaRepository<Paiement, Long> { 

    

    @Query(value = "select count(*) from paiement", nativeQuery = true) 
    int getQuantityOfPaiement(); 

    @Query(value = "select * from paiement where id= :id", nativeQuery = true) 
    Paiement getPaiementByIdPaiement(@Param("id") Long id); 
}
