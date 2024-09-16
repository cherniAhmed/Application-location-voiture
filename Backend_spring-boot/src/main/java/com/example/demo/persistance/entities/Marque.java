package com.example.demo.persistance.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data  @AllArgsConstructor
public class Marque implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nomMar;
	
	public Marque(Long id, String nomMar) {
		super();
		this.id = id;
		this.nomMar = nomMar;
	}
	
	public Marque() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomMar() {
		return nomMar;
	}
	public void setNomMar(String nomMar) {
		this.nomMar = nomMar;
	}
	
	@OneToMany(mappedBy = "marque")
    private List<Voiture> voitures;
}