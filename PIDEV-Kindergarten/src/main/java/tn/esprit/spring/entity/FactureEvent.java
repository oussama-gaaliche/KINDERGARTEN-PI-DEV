package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FactureEvent")
public class FactureEvent {
private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Facture_id")
    private int id;

	
	@Column(name="charge_locale")
	private double montant_locale;
	
	@Column(name="charge_stocks")
	private double montant_stocks;
	
	
	@Column(name="charge_totale")
	private double montant_totale;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Date_Dacture")
	private Date date_facture;



	
	



	public FactureEvent() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getMontant_locale() {
		return montant_locale;
	}



	public void setMontant_locale(double montant_locale) {
		this.montant_locale = montant_locale;
	}



	public double getMontant_stocks() {
		return montant_stocks;
	}



	public void setMontant_stocks(double montant_stocks) {
		this.montant_stocks = montant_stocks;
	}



	public double getMontant_totale() {
		return montant_totale;
	}



	public void setMontant_totale(double montant_totale) {
		this.montant_totale = montant_totale;
	}



	public Date getDate_facture() {
		return date_facture;
	}



	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
