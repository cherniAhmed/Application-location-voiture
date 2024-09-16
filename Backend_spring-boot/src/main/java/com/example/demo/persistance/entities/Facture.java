package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  @AllArgsConstructor
public class Facture implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private Long numero;
	private Long montant;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date date_facture;
	public Facture(Long id, Long numero, Long montant , Date date_facture) {
		super();
		this.id = id;
		this.numero = numero;
		this.montant = montant;
		this.date_facture = date_facture;
	}
	
	public Facture() {
		super();
	}

	public Date getDate_facture() {
		return date_facture;
	}

	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getMontant() {
		return montant;
	}
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	@OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
