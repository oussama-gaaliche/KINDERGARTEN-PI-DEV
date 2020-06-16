package tn.esprit.spring.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import tn.esprit.spring.Services.IngredientServiceImpl;
import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
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
	private Plat plat;
	
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
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
public String GoBackIng(){
	return "/AffichageIng.xhtml?faces-redirect=true";	

}

private Part image;
public Part getImage() {
	return image;
}
public void setImage(Part image) {
	this.image = image;
}
public boolean isUpladed() {
	return upladed;
}
public void setUpladed(boolean upladed) {
	this.upladed = upladed;
}
private boolean upladed;
public void doUpload(){
    try{
        InputStream in=image.getInputStream();
        
        File f=new File("C:/Work/sts_bundle/Pi-Spring/src/main/webapp/files/myImage/"+image.getSubmittedFileName());
        f.createNewFile();
        FileOutputStream out=new FileOutputStream(f);
        
        byte[] buffer=new byte[1024];
        int length;
        
        while((length=in.read(buffer))>0){
            out.write(buffer, 0, length);
        }
        
        out.close();
        in.close();
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
        upladed=true;
        
    }catch(Exception e){
        e.printStackTrace(System.out);
    }

}


}
