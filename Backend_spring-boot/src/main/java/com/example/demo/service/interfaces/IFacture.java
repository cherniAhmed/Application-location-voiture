package com.example.demo.service.interfaces;
import com.example.demo.persistance.entities.Facture;
import java.util.Optional;

import java.util.List;

public interface IFacture {

	Facture saveFacture(Facture facture);
	Facture updateFacture(Facture facture);
    boolean deleteFacture(Long id);
    List<Facture> getListFacture();
    Facture getFacture(Long id);
    Facture findFactureBynumero(Long numero);
    Facture getFactureByIdFacture(Long id);
	List<Facture> getAllFactures();
	Optional<Facture> getFactureById(Long id);

}
