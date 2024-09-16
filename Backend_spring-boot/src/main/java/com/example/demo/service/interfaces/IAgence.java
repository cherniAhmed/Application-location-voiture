package com.example.demo.service.interfaces;
import com.example.demo.persistance.entities.Agence;
import java.util.List;
import java.util.Optional;

public interface IAgence {

	Agence saveAgence(Agence agence);
	Agence updateAgence(Agence agence);
    boolean deleteAgence(Long id);
    List<Agence> getListAgence();
    Agence getAgence(Long id);
    Agence findAgenceByName(String nom);
    int getQuantityOfAgence();
    Agence getAgenceByIdAgence(Long id);
	List<Agence> getAllAgences();
	Optional<Agence> getAgenceById(Long id);

}
