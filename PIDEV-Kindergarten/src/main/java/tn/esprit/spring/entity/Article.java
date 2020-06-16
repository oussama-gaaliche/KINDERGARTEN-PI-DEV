package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_article;
	private String reference;
	@Enumerated(EnumType.STRING)
	private FamilleArticles famille;
	private String description;
	private String nom;
	private int qteStock;
	private int qteMin;
	private int qteMax;
	@Enumerated(EnumType.STRING)
	private EtatArticle etat;
	private int remise;
	private float venteHT;
	private float venteTTC;
	private float achatHT;
	private float achatTTC;
	@Enumerated(EnumType.STRING)
	private TVA tva;
	// A discuter !!!!!!!!!(un article ne possede une facture que après vente)
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Facture> facture;

	public Article() {
		super();
	}
	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", reference=" + reference + ", famille=" + famille
				+ ", description=" + description + ", nom=" + nom + ", qteStock=" + qteStock + ", qteMin=" + qteMin
				+ ", qteMax=" + qteMax + ", etat=" + etat + ", remise=" + remise + ", venteHT=" + venteHT
				+ ", venteTTC=" + venteTTC + ", achatHT=" + achatHT + ", achatTTC=" + achatTTC + ", tva=" + tva
				+  "]";
	}
	public Article(Long id_article, String reference, FamilleArticles famille, String description, String nom,
			int qteStock, int qteMin, int qteMax, EtatArticle etat, int remise, float venteHT, float venteTTC,
			float achatHT, float achatTTC, TVA tva) {
		super();
		this.id_article = id_article;
		this.reference = reference;
		this.famille = famille;
		this.description = description;
		this.nom = nom;
		this.qteStock = qteStock;
		this.qteMin = qteMin;
		this.qteMax = qteMax;
		this.etat = etat;
		this.remise = remise;
		this.venteHT = venteHT;
		this.venteTTC = venteTTC;
		this.achatHT = achatHT;
		this.achatTTC = achatTTC;
		this.tva = tva;
	}
	
	public Long getId_article() {
		return id_article;
	}
	public void setId_article(Long id_article) {
		this.id_article = id_article;
	}
	public EtatArticle getEtat() {
		return etat;
	}
	public void setEtat(EtatArticle etat) {
		this.etat = etat;
	}
	public TVA getTva() {
		return tva;
	}
	public void setTva(TVA tva) {
		this.tva = tva;
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
	public int getRemise() {
		return remise;
	}
	public void setRemise(int remise) {
		this.remise = remise;
	}
	
	public float getVenteHT() {
		return venteHT;
	}

	public void setVenteHT(float venteHT) {
		this.venteHT = venteHT;
	}

	public float getVenteTTC() {
		return venteTTC;
	}

	public void setVenteTTC(float venteTTC) {
		this.venteTTC = venteTTC;
	}

	public float getAchatHT() {
		return achatHT;
	}

	public void setAchatHT(float achatHT) {
		this.achatHT = achatHT;
	}

	public float getAchatTTC() {
		return achatTTC;
	}

	public void setAchatTTC(float achatTTC) {
		this.achatTTC = achatTTC;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
