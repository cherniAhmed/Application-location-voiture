package com.example.demo.service.impliments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.MarqueRepository;
import com.example.demo.persistance.entities.Marque;
import com.example.demo.service.interfaces.IMarque;

@Service
public class MarqueService implements IMarque {
    @Autowired
    MarqueRepository marqueRepository; 

    @Override
    public Marque saveMarque(Marque marque) { 
        return marqueRepository.save(marque);
    }

    @Override
    public Marque updateMarque(Marque marque) { 
        return marqueRepository.saveAndFlush(marque);
    }

    @Override
    public boolean deleteMarque(Long id) { 
        marqueRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Marque> getListMarque() { 
        return marqueRepository.findAll(); 
    }

    @Override
    public Marque getMarque(Long id) { 
        return marqueRepository.findById(id).get(); 
    }

    @Override
    public Marque findMarquebynomMar(String name) { 
        return marqueRepository.findBynomMar(name); 
    }


    @Override
    public Marque getMarqueByIdMarque(Long id) { 
        return null;
    }
    
    @Override
    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    @Override
    public Optional<Marque> getMarqueById(Long id) {
        return marqueRepository.findById(id);
    }

}
