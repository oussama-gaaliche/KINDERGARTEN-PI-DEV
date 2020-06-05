package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingredient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id; 
	private String nom;
	private double prix;
	@OneToMany(mappedBy="ingredient")
	private  List<IngredientPlat> ingredientplat ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ingredient(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}
	public Ingredient(int id, String nom, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
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
	public Ingredient() {
		super();
		
		
	}
	
	
	
	


}
