package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SQLUpdate;

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
	
	public Plat getPlb() {
		return plb;
	}
	public void setPlb(Plat plb) {
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
	public IngredientPlat(IngredientPlatPk ingp,  int quantity) {
		super();
		this.ingp = ingp;
	
		this.quantity = quantity;
	}
	public IngredientPlat() {
		super();
	}
	
	

	public IngredientPlat(IngredientPlatPk ingp, Plat plb, Ingredient ingredient, int quantity) {
		super();
		this.ingp = ingp;
		this.plb = plb;
		this.ingredient = ingredient;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "IngredientPlat [ingp=" + ingp + ", plb=" + plb + ", ingredient=" + ingredient + ", quantity=" + quantity
				+ "]";
	}
	

}
