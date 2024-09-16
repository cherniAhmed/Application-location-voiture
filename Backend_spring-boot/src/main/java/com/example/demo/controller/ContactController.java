package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Client;
import com.example.demo.persistance.entities.Contact; 
import com.example.demo.service.interfaces.IContact; 

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    IContact contactService; 

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Contact save(@RequestBody Contact contact) { 
        System.out.println("*******save ***********");
        Contact c = contactService.saveContact(contact); 
        System.out.println("*******" + c.getEmail());
        return c;
    }

    @GetMapping("/{id}")
    Contact getContactById(@PathVariable Long id) {
        return contactService.getContact(id); 
    }

    @GetMapping("/quantity")
    int getQuantityContact() { 
        return contactService.getQuantityOfContact(); 
    }

    @GetMapping("/contactByName/{name}") 
    Contact getContactByName(@PathVariable String name) { 
        return contactService.findContactByName(name); 
    }

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        contactService.deleteContact(id); 
        return true;
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        System.out.println("******update **********");

        // Retrieve the existing contact by ID
        Optional<Contact> existingContactOptional = contactService.getContactById(id);

        if (existingContactOptional.isPresent()) {
            Contact existingContact = existingContactOptional.get();

            // Update the necessary fields
            existingContact.setNom(updatedContact.getNom());
            existingContact.setEmail(updatedContact.getEmail());
            existingContact.setTel(updatedContact.getTel());
            existingContact.setSujet(updatedContact.getSujet());
            existingContact.setContenu(updatedContact.getContenu());

            // Save the updated contact
            Contact updatedContactResult = contactService.updateContact(existingContact);

            // Return the updated contact in the response
            return ResponseEntity.ok(updatedContactResult);
        } else {
            // Contact not found, return 404
            return ResponseEntity.notFound().build();
        }
    }


}
