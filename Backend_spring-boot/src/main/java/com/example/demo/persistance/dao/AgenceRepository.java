package com.example.demo.persistance.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Agence;



public interface AgenceRepository extends JpaRepository<Agence,Long> {
	Agence findByNom(String nom);
    @Query(value = "select count(*) from Agence",nativeQuery = true)
    int getQuantityAgence();
    @Query(value = "select * from Agence where id= :id",nativeQuery = true)
    Agence getAgenceByIdAgence(@Param("id") Long id);

}
