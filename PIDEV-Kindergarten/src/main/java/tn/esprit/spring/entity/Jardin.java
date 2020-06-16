package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "jardin")
public class Jardin implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String description;
	private String adresse;
	@ManyToOne(cascade = CascadeType.ALL) 
	User user;
	
	private int nombreEnfant;
	
	
	public Jardin() {
		super();
	}

	public Jardin(Long id, String nom, String description, String adresse, User user) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.user = user;
	}

	public Jardin(String nom, String description, String adresse, User user) {
		super();
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.user = user;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNombreEnfant() {
		return nombreEnfant;
	}

	public void setNombreEnfant(int nombreEnfant) {
		this.nombreEnfant = nombreEnfant;
	}
	
	

}
