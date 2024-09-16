
package com.example.demo.persistance.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.persistance.entities.Facture;



public interface FactureRepository extends JpaRepository<Facture,Long> {
	Facture findBynumero(Long numero);
    @Query(value = "select count(*) from Facture",nativeQuery = true)
    int getQuantityAgence();
    @Query(value = "select * from Facture where id= :id",nativeQuery = true)
    Facture getFactureByFacture(@Param("id") Long id);

}
