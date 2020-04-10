package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "enfant")
public class Enfant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	@Temporal (TemporalType.DATE)
	private Date dateNaissance;
	private Niveau niveau;
	@ManyToOne 
	private Classe classe;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	User user;
	@ManyToOne 
	Jardin jardin;
	public Enfant() {
		super();
	}
	
	public Enfant(String nom, String prenom, Date dateNaissance, Niveau  niveau, Classe  classe, User user
			) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.niveau = niveau;
		this.classe = classe;
		this.user = user;
		
	}
	

	public Enfant(Long id, String nom, String prenom, Date dateNaissance, Niveau  niveau, Classe  classe, User user
			) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.niveau = niveau;
		this.classe = classe;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Niveau  getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau  niveau) {
		this.niveau = niveau;
	}
	public Classe  getClasse() {
		return classe;
	}
	public void setClasse(Classe  classe) {
		this.classe = classe;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}
	

}
