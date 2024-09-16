package com.example.demo.service.impliments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.PaiementRepository;
import com.example.demo.persistance.entities.Contact;
import com.example.demo.persistance.entities.Paiement; 
import com.example.demo.service.interfaces.IPaiement; 

@Service
public class PaiementService implements IPaiement { 

    @Autowired
    PaiementRepository paiementRepository; 

    @Override
    public Paiement savePaiement(Paiement paiement) { 
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) { 
        return paiementRepository.saveAndFlush(paiement);
    }

    @Override
    public boolean deletePaiement(Long id) { 
        paiementRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Paiement> getListPaiement() { 
        return paiementRepository.findAll(); 
    }

    @Override
    public Paiement getPaiement(Long id) { 
        return paiementRepository.findById(id).get(); 
    }



    @Override
    public int getQuantityOfPaiement() { 
        return paiementRepository.getQuantityOfPaiement(); 
    }

    @Override
    public Paiement getPaiementByIdPaiement(Long id) { 
        return null;
    }
    
    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id);
    }
}

