package tn.esprit.spring.Controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import tn.esprit.spring.Services.IngredientServiceImpl;
import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value ="ingController")
@ELBeanName(value ="ingController")
@Join(path = "/", to = "AffichageIng.jsf")
public class IngredientControllerJSF {
	@Autowired
	IngredientServiceImpl ingservice;
	private Ingredient ingredient;
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	private String nom;
	private double prix;
	
	private Integer IngToBeUpadated;
	public Integer getIngToBeUpadated() {
		return IngToBeUpadated;
	}
	public void setIngToBeUpadated(Integer ingToBeUpadated) {
		IngToBeUpadated = ingToBeUpadated;
	}
	
	private List<Ingredient> ingre; 
	public List<Ingredient> getIngre() {
		return ingre;
	}
	public void setIngre(List<Ingredient> ingre) {
		this.ingre = ingre;
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


public List<Ingredient> getings() {
	ingre = ingservice.GetallIng();
	return ingre;
	} 
public void removeIng(int id)
{
	ingservice.DeleteIngredient(id);	}

public String displayIng(Ingredient i)
{
	
this.setNom(i.getNom());
this.setPrix(i.getPrix());
this.setIngToBeUpadated(i.getId());
return "/editIng.xhtml?faces-redirect=true";
}
public String updateIng() 
{ 
	ingservice.AddIngredient(new Ingredient (IngToBeUpadated,nom, prix));
	return "/AffichageIng.xhtml?faces-redirect=true";
	}
public String AddIng(){
	ingservice.AddIngredient(new Ingredient(nom, prix));
	return "/AffichageIng.xhtml?faces-redirect=true";
	
	
}
public String GoFormAdd(){
	return "/AddIng.xhtml?faces-redirect=true";
	
	
}

}
