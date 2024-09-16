package com.example.demo.service.impliments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.AgenceRepository;
import com.example.demo.persistance.entities.Agence;
import com.example.demo.service.interfaces.IAgence;

@Service
public class AgenceService implements IAgence {
    @Autowired
    AgenceRepository agenceRepository; 

    @Override
    public Agence saveAgence(Agence agence) { 
        return agenceRepository.save(agence);
    }

    @Override
    public Agence updateAgence(Agence agence) { 
        return agenceRepository.saveAndFlush(agence);
    }

    @Override
    public boolean deleteAgence(Long id) { 
        agenceRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Agence> getListAgence() { 
        return agenceRepository.findAll(); 
    }

    @Override
    public Agence getAgence(Long id) { 
        return agenceRepository.findById(id).get(); 
    }

    @Override
    public Agence findAgenceByName(String name) { 
        return agenceRepository.findByNom(name); 
    }

    @Override
    public int getQuantityOfAgence() { 
        return agenceRepository.getQuantityAgence(); 
    }

    @Override
    public Agence getAgenceByIdAgence(Long id) { 
        return null;
    }

	@Override
	public List<Agence> getAllAgences() {
		// TODO Auto-generated method stub
		return agenceRepository.findAll();
	}

	@Override
	public Optional<Agence> getAgenceById(Long id) {
		// TODO Auto-generated method stub
		return agenceRepository.findById(id);
	}
}
