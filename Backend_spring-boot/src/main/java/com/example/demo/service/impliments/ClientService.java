package com.example.demo.service.impliments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.ClientRepository;
import com.example.demo.persistance.entities.Client;
import com.example.demo.service.interfaces.IClient;

@Service
public class ClientService implements IClient{
	@Autowired
    ClientRepository clientRepository; 

    @Override
    public Client saveClient(Client client) { 
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) { 
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public boolean deleteClient(Long id) { 
        clientRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Client> getListClient() { 
        return clientRepository.findAll(); 
    }

    @Override
    public Client getClient(Long id) { 
        return clientRepository.findById(id).get(); 
    }

    @Override
    public Client findClientByName(String name) { 
        return clientRepository.findByNom(name); 
    }

    @Override
    public int getQuantityOfClient() { 
        return clientRepository.getQuantityOfClient(); 
    }

    @Override
    public Client getClientByIdClient(Long id) { 
        return null;
    }

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> getClientById(Long id) {
		return clientRepository.findById(id);
	}

	
}


