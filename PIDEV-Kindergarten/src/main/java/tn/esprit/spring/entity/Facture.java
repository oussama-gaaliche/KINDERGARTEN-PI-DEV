package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity 
@Table(name = "facture")
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String num_cmd;
	@Temporal (TemporalType.DATE)
	private Date date_cmd; 
	private float montant_ht;
	private float montant_ttc;
	private float total_tva;
	private float timbre_fiscal;
	private TypePaiement paiement;
	@ManyToOne
	private User user;
	
	public Facture() {
		super();
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToMany(mappedBy="facture", cascade = CascadeType.ALL)
    private List<Article> articles;
	

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum_cmd() {
		return num_cmd;
	}

	public void setNum_cmd(String num_cmd) {
		this.num_cmd = num_cmd;
	}

	public Date getDate_cmd() {
		return date_cmd;
	}

	public void setDate_cmd(Date date_cmd) {
		this.date_cmd = date_cmd;
	}

	public float getMontant_ht() {
		return montant_ht;
	}

	public void setMontant_ht(float montant_ht) {
		this.montant_ht = montant_ht;
	}

	public float getMontant_ttc() {
		return montant_ttc;
	}

	public void setMontant_ttc(float montant_ttc) {
		this.montant_ttc = montant_ttc;
	}

	public float getTotal_tva() {
		return total_tva;
	}

	public void setTotal_tva(float total_tva) {
		this.total_tva = total_tva;
	}

	public float getTimbre_fiscal() {
		return timbre_fiscal;
	}

	public void setTimbre_fiscal(float timbre_fiscal) {
		this.timbre_fiscal = timbre_fiscal;
	}

	public TypePaiement getPaiement() {
		return paiement;
	}

	public void setPaiement(TypePaiement paiement) {
		this.paiement = paiement;
	}
	
}
