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
@Table(name="T_Plat")
public class Plat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_Plat;
	@Enumerated(EnumType.STRING)
	private TypePlat typeplat;
	private String nom;
	private double prix;
	@OneToMany(mappedBy="plat")
	private List<Repas> repas;
	public int getId() {
		return id_Plat;
	}
	public void setId(int id_Plat) {
		this.id_Plat = id_Plat;
	}
	
	public TypePlat getTypeplat() {
		return typeplat;
	}
	public void setTypeplat(TypePlat typeplat) {
		this.typeplat = typeplat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Plat(TypePlat typeplat, String nom, double prix) {
		super();
		this.typeplat = typeplat;
		this.nom = nom;
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Plat [id=" + id_Plat+ ", typeplat=" + typeplat + ", nom=" + nom + ", prix=" + prix + "]";
	}
	public Plat() {
		super();
	}
	

}
