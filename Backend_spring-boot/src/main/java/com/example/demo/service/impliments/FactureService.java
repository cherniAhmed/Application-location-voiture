package com.example.demo.service.impliments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.FactureRepository;
import com.example.demo.persistance.entities.Facture;
import com.example.demo.service.interfaces.IFacture;
@Service
public class FactureService implements IFacture {
    @Autowired
    FactureRepository factureRepository; 

    @Override
    public Facture saveFacture(Facture facture) { 
        return factureRepository.save(facture);
    }

    @Override
    public Facture updateFacture(Facture facture) { 
        return factureRepository.saveAndFlush(facture);
    }

    @Override
    public boolean deleteFacture(Long id) { 
        factureRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Facture> getListFacture() { 
        return factureRepository.findAll(); 
    }

    @Override
    public Facture getFacture(Long id) { 
        return factureRepository.findById(id).get(); 
    }

    @Override
    public Facture findFactureBynumero(Long numero) { 
        return factureRepository.findBynumero(numero); 
    }

  

    @Override
    public Facture getFactureByIdFacture(Long id) { 
        return null;
    }
    
    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

}
