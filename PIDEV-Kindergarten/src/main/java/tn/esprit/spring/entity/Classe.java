package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	private int size;
	Long jardin;
	
	
	public Classe() {
		super();
	}
	public Classe(Long id, String nom, int size, Long jardin,Niveau niveau) {
		super();
		this.id = id;
		this.nom = nom;
		this.size = size;
		this.jardin = jardin;
		this.niveau=niveau;
	}
	public Classe(String nom, int size, Long jardin,Niveau niveau) {
		super();
		this.nom = nom;
		this.size = size;
		this.jardin = jardin;
		this.niveau=niveau;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Long getJardin() {
		return jardin;
	}
	public void setJardin(Long jardin) {
		this.jardin = jardin;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
	

}
