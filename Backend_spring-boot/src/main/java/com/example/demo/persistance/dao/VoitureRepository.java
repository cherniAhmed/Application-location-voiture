package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Marque;
import com.example.demo.persistance.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
	Voiture findByCouleur(String couleur);
    @Query(value = "select count(*) from Voiture",nativeQuery = true)
    int getQuantityOfVoiture(); 
    @Query(value = "select * from Voiture where id= :id",nativeQuery = true)
    Marque getMarqueByIdVoiture(@Param("id") Long id);

}
