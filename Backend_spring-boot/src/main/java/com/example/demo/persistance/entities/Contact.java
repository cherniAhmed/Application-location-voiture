package com.example.demo.persistance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Contact implements Serializable{

	  @Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nom;
	  private String tel;
	  private String email;
	  private String sujet;
	  private String contenu;
	  
	  
	  public Contact(Long id, String sujet, String contenu, String aa) {
			super();
			this.id = id;
			this.sujet = sujet;
			this.contenu = contenu;
			this.email = email;
			this.nom = nom;
			this.tel = tel;
		}
	  
	  public Contact() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToOne
    private Agence agence;
	
}
