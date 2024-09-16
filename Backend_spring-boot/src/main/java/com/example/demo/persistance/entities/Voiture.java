package com.example.demo.persistance.entities;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Voiture implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String matricule;
	private String couleur;
	private String modele; 
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date date_fab;
	private String imageUrl;
	
	private Long prix_location;
	public Voiture(Long id, String matricule, String couleur, String modele, Date date_fab, Long prix_location,String imageUrl, Marque marque) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.couleur = couleur;
		this.modele = modele;
		this.date_fab = date_fab;
		this.prix_location = prix_location;
		this.imageUrl = imageUrl;
		this.marque=marque;
	}
	
	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Voiture() {
		super();
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public Date getDate_fab() {
		return date_fab;
	}
	public void setDate_fab(Date date_fab) {
		this.date_fab = date_fab;
	}
	public Long getPrix_location() {
		return prix_location;
	}
	public void setPrix_location(Long prix_location) {
		this.prix_location = prix_location;
	}
	@ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;


 
	@ManyToOne
 @JoinColumn(name = "marque_id")
 private Marque marque;
 
 @OneToMany(mappedBy = "voiture")
    private List<Reservation> reservations = new ArrayList<>();
 
public void setReservee(boolean b) {
	// TODO Auto-generated method stub
	
}
}
	