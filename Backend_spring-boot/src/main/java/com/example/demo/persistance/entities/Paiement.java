package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Paiement implements Serializable {
	@Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private Long montant;
	  private String type_carte;
	  private String numero_carte;
	  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	  private LocalDateTime date_expiration_carte;
	  
	  

	public Paiement() {
		super();
	}

	public Paiement(Long id, Long montant, String type_carte, String numero_carte,
			LocalDateTime date_expiration_carte) {
		super();
		this.id = id;
		this.montant = montant;
		this.type_carte = type_carte;
		this.numero_carte = numero_carte;
		this.date_expiration_carte = date_expiration_carte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMontant() {
		return montant;
	}

	public void setMontant(Long montant) {
		this.montant = montant;
	}

	public String getType_carte() {
		return type_carte;
	}

	public void setType_carte(String type_carte) {
		this.type_carte = type_carte;
	}

	public String getNumero_carte() {
		return numero_carte;
	}

	public void setNumero_carte(String numero_carte) {
		this.numero_carte = numero_carte;
	}

	public LocalDateTime getDate_expiration_carte() {
		return date_expiration_carte;
	}

	public void setDate_expiration_carte(LocalDateTime date_expiration_carte) {
		this.date_expiration_carte = date_expiration_carte;
	}
	
	@OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

	
}
