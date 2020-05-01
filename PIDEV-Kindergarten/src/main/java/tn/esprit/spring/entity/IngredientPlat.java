package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IngredientPlat implements Serializable{
	@EmbeddedId
	private IngredientPlatPk ingp;
	@ManyToOne
    @JoinColumn(name ="idp", referencedColumnName = "id_plat", insertable=false, updatable=false)
	private Plat plb;
	@ManyToOne
    @JoinColumn(name ="idingredient", referencedColumnName = "id", insertable=false, updatable=false)
	private Ingredient ingredient;
	private int quantity;
	public IngredientPlatPk getIngp() {
		return ingp;
	}
	public void setIngp(IngredientPlatPk ingp) {
		this.ingp = ingp;
	}
	public Plat getPl() {
		return plb;
	}
	public void setPl(Plat plb) {
		this.plb = plb;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
