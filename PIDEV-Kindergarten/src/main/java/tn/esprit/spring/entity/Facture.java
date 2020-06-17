package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
@Entity 
@Table(name = "facture")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String num_fact;
	private double timbre_fiscal=0.6;
	   @Enumerated(EnumType.STRING)

	private TypePaiement paiement;
	private double montant;
	private String adresse;
	private Long codePasotal;
	public double getMontant() {
		
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum_fact() {
		return num_fact;
	}

	public void setNum_fact(String num_fact) {
		this.num_fact = num_fact;
	}

	public double getTimbre_fiscal() {
		return timbre_fiscal;
	}

	public void setTimbre_fiscal(double timbre_fiscal) {
		this.timbre_fiscal = timbre_fiscal;
	}

	public TypePaiement getPaiement() {
		return paiement;
	}

	public void setPaiement(TypePaiement paiement) {
		this.paiement = paiement;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", num_fact=" + num_fact + ", timbre_fiscal=" + timbre_fiscal + ", paiement="
				+ paiement + ", montant=" + montant + "]";
	}

	public Facture() {
		super();
	}

	

	
	
}
