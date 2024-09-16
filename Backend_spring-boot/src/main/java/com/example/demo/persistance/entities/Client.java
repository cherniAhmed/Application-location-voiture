package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Client implements Serializable{
	
	@Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nom;
	  private String email;
	  private String adresse;
	  private String tel;
	  
	  
	  
	public Client() {
		super();
	}

	public Client(Long id, String nom, String email, String adresse, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
}
