package tn.esprit.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity 
@Table(name = "commande")
public class Commande implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CommandePk commandepk ;
	
	@Temporal (TemporalType.DATE)
	private Date date_cmd;
	private int qte_cmd;
	private float montant_ht;
	private double montant_ttc;
	private double total_tva;
	
	private TypeLivraison livraison;
	@ManyToOne
	private Facture facture;

	@ManyToOne
	@JoinColumn(name="userid" ,referencedColumnName="id",insertable=false, updatable=false)
	private User user_commande ;
	
	@ManyToOne
	@JoinColumn(name="articleid" ,referencedColumnName="id_article",insertable=false, updatable=false)
	private Article article_commande;
	
	public CommandePk getCommandepk() {
		return commandepk;
	}

	public void setCommandepk(CommandePk commandepk) {
		this.commandepk = commandepk;
	}

	public User getUser_commande() {
		return user_commande;
	}

	public void setUser_commande(User user_commande) {
		this.user_commande = user_commande;
	}

	public Article getArticle_commande() {
		return article_commande;
	}

	public void setArticle_commande(Article article_commande) {
		this.article_commande = article_commande;
	}

	public Commande() {
		super();
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

	public double  getMontant_ttc() {
		return montant_ttc;
	}

	public void setMontant_ttc(double montant_ttc) {
		this.montant_ttc = montant_ttc;
	}

	public double getTotal_tva() {
	
		return total_tva;
	}

	public void setTotal_tva(double total_tva) {
		this.total_tva = total_tva;
	}


	public int getQte_cmd() {
		return qte_cmd;
	}

	public void setQte_cmd(int qte_cmd) {
		this.qte_cmd = qte_cmd;
	}

	public TypeLivraison getLivraison() {
		return livraison;
	}

	public void setLivraison(TypeLivraison livraison) {
		this.livraison = livraison;
	}

	@Override
	public String toString() {
		return "Commande [commandepk=" + commandepk + ", date_cmd=" + date_cmd + ", qte_cmd=" + qte_cmd
				+ ", montant_ht=" + montant_ht + ", montant_ttc=" + montant_ttc + ", total_tva=" + total_tva
				+  ", livraison=" + livraison + ", facture=" + facture + ", user_commande="
				+ user_commande + ", article_commande=" + article_commande + "]";
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}


	




	
	

}
