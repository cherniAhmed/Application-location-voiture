package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Contact; 

public interface ContactRepository extends JpaRepository<Contact, Long> { 

    Contact findByNom(String nom); 

    @Query(value = "select count(*) from contact", nativeQuery = true) 
    int getQuantityOfContact(); 

    @Query(value = "select * from contact where id= :id", nativeQuery = true) 
    Contact getContactByIdContact(@Param("id") Long id); 
}
