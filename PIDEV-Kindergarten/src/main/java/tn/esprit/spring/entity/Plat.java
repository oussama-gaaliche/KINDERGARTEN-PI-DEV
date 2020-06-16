package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	private int id_plat;
	public int getId_plat() {
		return id_plat;
	}
	public void setId_plat(int id_plat) {
		this.id_plat = id_plat;
	}
	 @Column
	@Enumerated(EnumType.STRING)
	private TypePlat typeplat;
	 @Column
	private String nom;
	 @Column
	private double prix;
	 @Lob
		@Column(length = 2125635)
		private byte[] image;
	
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@OneToMany(mappedBy="plb")
	private  List<IngredientPlat> ingredientplat ;
	
	@OneToMany(mappedBy="plat")
	private List<Repas> repas;
	
	
	
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
		return "Plat [id=" + id_plat+ ", typeplat=" + typeplat + ", nom=" + nom + ", prix=" + prix + "]";
	}
	public Plat() {
		super();
	}
	public Plat(String nom, double prix,TypePlat typeplat) {
		super();
		this.typeplat = typeplat;
		this.nom = nom;
		this.prix = prix;
		
		
	}
	
	public Plat(int id_plat, TypePlat typeplat, String nom, double prix) {
		super();
		this.id_plat = id_plat;
		this.typeplat = typeplat;
		this.nom = nom;
		this.prix = prix;
	}
	public Plat(byte[] image, String nom, double prix,TypePlat typeplat ) {
		super();
		this.typeplat = typeplat;
		this.nom = nom;
		this.prix = prix;
		this.image = image;
	}

	
	
	
	
	
	
	

}
