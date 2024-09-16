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

import com.example.demo.service.interfaces.IClient;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	 @Autowired
	    IClient clientService; // Changed from IPatient to IClient

	    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	    Client save(@RequestBody Client client) { // Changed from Patient to Client
	    System.out.println("*******save ***********");
	    Client c = clientService.saveClient(client); // Changed from Patient to Client
	    System.out.println("*******" + c.getEmail());
	    return c;
	    }

	    @GetMapping("/{id}")
	    Client getClientById(@PathVariable Long id) {
	        return clientService.getClient(id);
	    }

	    @GetMapping("/quantity")
	    int getQuantityClient() { // Changed from Patient to Client
	        return clientService.getQuantityOfClient(); // Changed from getQuantityOfPatient to getQuantityOfClient
	    }

	    @GetMapping("/clientByName/{name}") // Changed from patientByName to clientByName
	    Client getClientByName(@PathVariable String name) { // Changed from Patient to Client
	        return clientService.findClientByName(name); // Changed from findPatientByName to findClientByName
	    }

	    @DeleteMapping("/delete/{id}")
	    boolean delete(@PathVariable Long id) {
	        clientService.deleteClient(id); // Changed from deletePatient to deleteClient
	        return true;
	    }
	    
	    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		List<Client> getAllClients() {
		    return clientService.getAllClients();
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
		    System.out.println("******update **********");

		    // Retrieve the existing patient by ID
		    Optional<Client> existingClientOptional = clientService.getClientById(id);

		    if (existingClientOptional.isPresent()) {
		        Client existingClient = existingClientOptional.get();

		        // Update the necessary fields
		        existingClient.setNom(updatedClient.getNom());
		        existingClient.setEmail(updatedClient.getEmail());
		        existingClient.setAdresse(updatedClient.getAdresse());
		        existingClient.setTel(updatedClient.getTel());

		        // Save the updated patient
		        Client updatedClientResult = clientService.updateClient(existingClient);

		        // Return the updated patient in the response
		        return ResponseEntity.ok(updatedClientResult);
		    } else {
		        // Patient not found, return 404
		        return ResponseEntity.notFound().build();
		    }
		}



	
	
}
