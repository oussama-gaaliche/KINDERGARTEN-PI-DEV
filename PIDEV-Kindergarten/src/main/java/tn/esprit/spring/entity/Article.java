package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	@Enumerated(EnumType.STRING)
	private FamilleArticles famille;
	private String description;
	private String nom;
	private int qteStock;
	private int qteMin;
	private int qteMax;
	@Enumerated(EnumType.STRING)
	private Etat etat;
	private int remise;
	private double venteHT;
	private double venteTTC;
	private double achatHT;
	private double achatTTC;
	@Enumerated(EnumType.STRING)
	private TVA tva;
	private Facture facture;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Facture> factures;
	
	public Set<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public FamilleArticles getFamille() {
		return famille;
	}
	public void setFamille(FamilleArticles famille) {
		this.famille = famille;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public int getQteMin() {
		return qteMin;
	}
	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}
	public int getQteMax() {
		return qteMax;
	}
	public void setQteMax(int qteMax) {
		this.qteMax = qteMax;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public int getRemise() {
		return remise;
	}
	public void setRemise(int remise) {
		this.remise = remise;
	}
	public double getVenteHT() {
		return venteHT;
	}
	public void setVenteHT(double venteHT) {
		this.venteHT = venteHT;
	}
	public double getVenteTTC() {
		return venteTTC;
	}
	public void setVenteTTC(double venteTTC) {
		this.venteTTC = venteTTC;
	}
	public double getAchatHT() {
		return achatHT;
	}
	public void setAchatHT(double achatHT) {
		this.achatHT = achatHT;
	}
	public double getAchatTTC() {
		return achatTTC;
	}
	public void setAchatTTC(double achatTTC) {
		this.achatTTC = achatTTC;
	}
	public TVA getTVA() {
		return tva;
	}
	public void setTVA(TVA tva) {
		tva = tva;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
