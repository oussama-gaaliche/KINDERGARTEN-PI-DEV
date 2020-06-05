package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Enumerated(EnumType.STRING)
	private Etat etat;
	private boolean abonnée;
	@Temporal (TemporalType.DATE)
	private Date dateNaissance;
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	@ManyToOne 
	private Classe classe;
	@ManyToOne(cascade = CascadeType.ALL) 
	User user;
	@ManyToOne(cascade = CascadeType.ALL)
	Jardin jardin;
	private String loisir;
	public Enfant() {
		super();
	}
	public Enfant(String nom, String prenom, Date dateNaissance, Niveau  niveau, Classe  classe, User user, String loisir
			) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.niveau = niveau;
		this.classe = classe;
		this.user = user;
		this.loisir = loisir;
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
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
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
	public boolean isAbonnée() {
		return abonnée;
	}
	public void setAbonnée(boolean abonnée) {
		this.abonnée = abonnée;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLoisir() {
		return loisir;
	}
	public void setLoisir(String loisir) {
		this.loisir = loisir;
	}
}