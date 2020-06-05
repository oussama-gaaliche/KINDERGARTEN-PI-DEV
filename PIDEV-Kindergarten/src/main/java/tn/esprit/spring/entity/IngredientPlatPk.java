package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IngredientPlatPk implements Serializable {
	private int idingredient;
	private int idp;
	private int calories;
	public int getIdingredient() {
		return idingredient;
	}
	public void setIdingredient(int idingredient) {
		this.idingredient = idingredient;
	}
	public int getIdplat() {
		return idp;
	}
	public void setIdplat(int idp) {
		this.idp = idp;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public IngredientPlatPk(int idingredient, int idp, int calories) {
		super();
		this.idingredient = idingredient;
		this.idp = idp;
		this.calories = calories;
	}
	public IngredientPlatPk() {
		super();
	}
	

}
