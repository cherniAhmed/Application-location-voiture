package com.example.demo.service.interfaces;
import com.example.demo.persistance.entities.Marque;


import java.util.List;
import java.util.Optional;

public interface IMarque {

	Marque saveMarque(Marque marque);
	Marque updateMarque(Marque marque);
    boolean deleteMarque(Long id);
    List<Marque> getListMarque();
    Marque getMarque(Long id);
    Marque findMarquebynomMar(String nomMar);
    Marque getMarqueByIdMarque(Long id);
	List<Marque> getAllMarques();
	Optional<Marque> getMarqueById(Long id);

}
