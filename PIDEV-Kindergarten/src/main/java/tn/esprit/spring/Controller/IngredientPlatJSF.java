package tn.esprit.spring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import tn.esprit.spring.Repository.IngredientPlatRepository;
import tn.esprit.spring.Repository.IngredientRepository;
import tn.esprit.spring.Repository.PlatRepository;
import tn.esprit.spring.Services.IngredientService;
import tn.esprit.spring.Services.IngretientPlatServiceImpl;
import tn.esprit.spring.Services.PlatServiceImpl;
import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.IngredientPlat;
import tn.esprit.spring.entity.IngredientPlatPk;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Scope(value = "session")
@Controller(value ="ingplatController")
@ELBeanName(value ="ingplatController")
@Join(path = "/", to = "AffichageReaps.jsf")
public class IngredientPlatJSF {
	@Autowired
	IngretientPlatServiceImpl igservice;
	@Autowired
	PlatServiceImpl platservice;
	@Autowired
	IngredientService ingservice;
	@Autowired
	PlatRepository prepo;
	@Autowired
	IngredientRepository irepo;
	@Autowired
	IngredientPlatRepository ingplrepo;
	private int idplat;
	 private int iding;
	private int quantity;
	 private int calories;
	 private Plat plb;
	private IngredientPlatPk ingpk;
	 
	 public IngredientPlatPk getIngpk() {
		return ingpk;
	}
	public void setIngpk(IngredientPlatPk ingpk) {
		this.ingpk = ingpk;
	}

	private Ingredient ingredient;
	
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

	@Autowired
		IngredientPlatRepository ingrepo;

	private IngredientPlatPk ingp;
	public IngredientPlatPk getIngp() {
		return ingp;
	}
	public void setIngp(IngredientPlatPk ingp) {
		this.ingp = ingp;
	}
	public int getIdplat() {
		return idplat;
	}
	public void setIdplat(int idplat) {
		this.idplat = idplat;
	}
	public int getIding() {
		return iding;
	}
	public void setIding(int iding) {
		this.iding = iding;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String add(){
		int idp=prepo.GetId(nomp);
		System.out.println( "takwa 1 "+idp);
		int idi=irepo.GetId(noming);
		System.out.println( "takwa 1 "+idi);
		IngredientPlatPk ingpk =new IngredientPlatPk();
		ingpk.setIdingredient(idi);
		System.out.println( "takwa set "+idi);
		ingpk.setIdplat(idp);
		System.out.println( "takwa set "+idp);
		ingpk.setCalories(calories);
		IngredientPlat ingpl=new IngredientPlat();
		ingpl.setIngp(ingpk);
		ingpl.setQuantity(quantity);
		System.out.println( "takwa avant save");
		ingplrepo.save(ingpl);
		
		System.out.println( "takwa aprés save");
		 return "/AffichageIngPlat.xhtml?faces-redirect=true";
		}
	public List<IngredientPlat> ings;
	public List<IngredientPlat> GetAll() {
		ings = igservice.getAll();
		
	    return ings;
	    }
	
 public List<IngredientPlat> getIngs() {
		return ings;
	}
	public Model getModel() {
	return model;
}
public void setModel(Model model) {
	this.model = model;
}
public List<Plat> getPlats() {
	return plats;
}
public void setPlats(List<Plat> plats) {
	this.plats = plats;
}
	public void setIngs(List<IngredientPlat> ings) {
		this.ings = ings;
	}
	private Model model;
	private List<Plat> plats;
	
public List<String> GetAllPlat(){
	List<Plat> pl=new ArrayList<>();
	 pl = platservice.AllPlats();
	 for (Plat p:pl){
		 nomp=p.getNom();
		 listPls.add(nomp);
		 System.out.println("Takwa" +listPls);
		 
	 }
	 return listPls;

 }
private String nomp;
private String noming;
private List<String> listing =new ArrayList<>();

public String getNoming() {
	return noming;
}
public void setNoming(String noming) {
	this.noming = noming;
}
public List<String> getListing() {
	return listing;
}
public void setListing(List<String> listing) {
	this.listing = listing;
}
public String getNomp() {
	return nomp;
}
public void setNomp(String nomp) {
	this.nomp = nomp;
}
private List<String> listPls =new ArrayList<>();

public List<String> getListPls() {
	return listPls;
}
public void setListPls(List<String> listPls) {
	this.listPls = listPls;
}
public List<String> GetNomIng(){
	List<Ingredient> ing=new ArrayList<>();
	ing=ingservice.GetallIng();
	for(Ingredient i:ing){
		noming=i.getNom();
		System.out.println("Takwa" + noming);
		listing.add(noming);
		System.out.println("Takwa" +listing);
		
	}
	return listing;
	
	
	
}
public String GoFormAddIngPL()
{
	
return "/AddIngPl.xhtml?faces-redirect=true";
}
private  String nomingedit;
private String nompedit;
public String getNompedit() {
	return nompedit;
}
public void setNompedit(String nompedit) {
	this.nompedit = nompedit;
}
public String getNomingedit() {
	return nomingedit;
}
public void setNomingedit(String nomingedit) {
	this.nomingedit = nomingedit;
}
public String displayINGPL(IngredientPlat ingp)

{   
	this.setIding(ingp.getIngp().getIdingredient());
	nomingedit=irepo.GetNom(iding);
	System.out.println("takwa"+nomingedit);
	this.setIdplat(ingp.getIngp().getIdplat());
	nompedit=prepo.GetNom(idplat);
	System.out.println("takwa"+nomingedit);
	this.setQuantity(ingp.getQuantity());
	
	this.setCalories(ingp.getIngp().getCalories());
	this.setIngpk(ingp.getIngp());

return "/editingp.xhtml?faces-redirect=true";
}
private IngredientPlat ingpl;
public IngredientPlat getIngpl() {
	return ingpl;
}
public void setIngpl(IngredientPlat ingpl) {
	this.ingpl = ingpl;
}

public void CalculPrix(){
	igservice.CalculPrixPlat();
	
	
}
public String Update(){
	int idp=prepo.GetId(nompedit);
	System.out.println( "takwa 1 "+idp);
	int idi=irepo.GetId(nomingedit);
	plb=prepo.GETP(nompedit);
	System.out.println(plb);
	System.out.println( "takwa 1 "+idi);
	
	
	//ingplrepo.mettreajourPlat(plb.getId_plat());
	//ingpk.setIdplat(plb.getId_plat());
//	ingplrepo.mettreajourIngredient(irepo.GETI(nomingedit));
	ingplrepo.save(new IngredientPlat(ingpk,plb,ingredient,quantity));
	
	 return "/AffichageIngPlat.xhtml?faces-redirect=true";
}

public void Delete(IngredientPlat ingp){

	System.out.println(ingp);
	ingplrepo.delete(ingp);
	
	
}
public String GoBackIngpl(){
	return "/AffichageIngPlat.xhtml?faces-redirect=true";
	
}
public String GoHome(){
	return "/RestoFront.xhtml?faces-redirect=true";
	
}
}
