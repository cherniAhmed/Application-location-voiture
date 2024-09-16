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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Agence implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nom;
	private String couladresse;
	private String tel; 
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date date_creation;
	
	private String description;
	public Agence(Long id, String nom, String couladresse, String tel, Date date_creation, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.couladresse = couladresse;
		this.tel = tel;
		this.date_creation = date_creation;
		this.description = description;
	}
	
	
	public Agence() {
		super();
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
	public String getCouladresse() {
		return couladresse;
	}
	public void setCouladresse(String couladresse) {
		this.couladresse = couladresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Voiture> voitures = new ArrayList<>();
  
  @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();
	
}