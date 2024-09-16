package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.persistance.entities.Marque;



public interface MarqueRepository extends JpaRepository<Marque,Long> {
	Marque findBynomMar(String nomMar);
    @Query(value = "select count(*) from Marque",nativeQuery = true)
    int getQuantityOVoiture();
    @Query(value = "select * from Marque where id= :id",nativeQuery = true)
    Marque getMarqueByIdMarque(@Param("id") Long id);

}
