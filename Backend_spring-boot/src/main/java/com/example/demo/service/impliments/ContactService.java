package com.example.demo.service.impliments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.ContactRepository; 
import com.example.demo.persistance.entities.Contact;
import com.example.demo.service.interfaces.IContact; 
@Service
public class ContactService implements IContact { 
    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact) { 
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) { 
        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public boolean deleteContact(Long id) { 
        contactRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Contact> getListContact() { 
        return contactRepository.findAll(); 
    }

    @Override
    public Contact getContact(Long id) { 
        return contactRepository.findById(id).get(); 
    }

    @Override
    public Contact findContactByName(String name) { 
        return contactRepository.findByNom(name); 
    }

    @Override
    public int getQuantityOfContact() { 
        return contactRepository.getQuantityOfContact(); 
    }

    @Override
    public Contact getContactByIdContact(Long id) { 
        return null;
    }
    
    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

}

