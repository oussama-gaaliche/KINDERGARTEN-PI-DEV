package tn.esprit.spring.Controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Part;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.PlanningRepository;
import tn.esprit.spring.Repository.PlatRepository;
import tn.esprit.spring.Repository.RepasRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.PlanningServiceImpl;
import tn.esprit.spring.Services.PlatServiceImpl;
import tn.esprit.spring.Services.RatingRestoServiceImpl;
import tn.esprit.spring.Services.repasServiceImpl;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Etat;
import tn.esprit.spring.entity.LikePlat;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.RepasPk;
import tn.esprit.spring.entity.TypePlat;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.ratingResto;
import tn.esprit.spring.entity.ratingRestoPk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;




@Scope(value = "session")
@Controller(value ="repController")
@ELBeanName(value ="repController")
@Join(path = "/", to = "AffichageReaps.jsf")
public class RepasControllerJSF {
	
	@Autowired
	repasServiceImpl repasService;
	@Autowired
	PlanningServiceImpl planservice;
	@Autowired 
	RepasRepository repasrepo;
	@Autowired
	PlanningRepository planrepo;
	@Autowired
	PlatRepository platrepo;
	@Autowired
	UserRepository userrepo;
	@Autowired
	RatingRestoServiceImpl ratingresto;
	@Autowired
	PlatServiceImpl platservice;
	@Autowired
	EnfantRepository enfantrepo;
	private List<Repas> allrepas;
	private List<Planning> plans;
	

	public List<Planning> getPlans() {
		return plans;
	}



	public void setPlans(List<Planning> plans) {
		this.plans = plans;
	}



	public Part getMyImage() {
		return myImage;
	}



	public void setMyImage(Part myImage) {
		this.myImage = myImage;
	}



	public String getIm() {
		return im;
	}



	public void setIm(String im) {
		this.im = im;
	}
	private Repas repas;
	private Plat plat;
	private int quantity;
	private Planning planning;
	private RepasPk repasPK;
	private Date date;
	private int idplanning;
	private Part  myImage;
public String im;
private RepasPk RepasToBeUpdated;
private int idplat;

			
			
			
		
		
		
	
		
		
	
	
    
	
	

	public int getIdplat() {
	return idplat;
}



public void setIdplat(int idplat) {
	this.idplat = idplat;
}



	public int getIdplanning() {
		return idplanning;
	}



	public void setIdplanning(int idplanning) {
		this.idplanning = idplanning;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public repasServiceImpl getRepasService() {
		return repasService;
	}



	public void setRepasService(repasServiceImpl repasService) {
		this.repasService = repasService;
	}



	public Repas getRepas() {
		return repas;
	}



	public void setRepas(Repas repas) {
		this.repas = repas;
	}



	public Plat getPlat() {
		return plat;
	}



	public void setPlat(Plat plat) {
		this.plat = plat;
	}







	public int getQuantity() {
		return quantity;
	}
	
		
	



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Planning getPlanning() {
		return planning;
	}



	public void setPlanning(Planning planning) {
		this.planning = planning;
	}






	public List<Repas> getallRepas() {
		allrepas = repasService.GetAllRepas();
		return allrepas;}



	public RepasPk getRepasPK() {
		return repasPK;
	}



	public void setRepasPK(RepasPk repasPK) {
		this.repasPK = repasPK;
	}
	
	public String addRepas(){
	
		/*RepasPk rp=new RepasPk();		
		rp.setIdplanning(planservice.GetIDPlan(date));
		rp.setDate(date);
		Repas r=new Repas();
		r.setRepasPK(rp);*/
		int id=planservice.GetIDPlan(date);
		if(id !=0){
		 repasService.addRepas(id, date);
		return "/AffichageRepas.xhtml?faces-redirect=true";}
		else 
		{return "impossible";}
		
		
	}
	private String nomedit;
	public String getNomedit() {
		return nomedit;
	}



	public void setNomedit(String nomedit) {
		this.nomedit = nomedit;
	}



	public void removeRepas(Repas r)
	{ repasrepo.delete(r);		}
	public String displayRepas(Repas rp)
	{
		//this.setRepasPK(rp.getRepasPK());
	this.setIdplanning(rp.getRepasPK().getIdplanning());
	this.setIdplat(rp.getRepasPK().getIdplat());
	nomedit=platrepo.GetNom(idplat);
	this.setDate(rp.getRepasPK().getDate());
	this.setQuantity(rp.getQuantity());
	this.setRepasToBeUpdated(rp.getRepasPK());
	return "/editRepas.xhtml?faces-redirect=true";
	}
	
	public RepasPk getRepasToBeUpdated() {
		return RepasToBeUpdated;
	}



	public void setRepasToBeUpdated(RepasPk repasToBeUpdated) {
		RepasToBeUpdated = repasToBeUpdated;
	}



	public String updateRepas(){
		repasrepo.UpdateRepasJPQL(platrepo.GETP(nomedit),quantity);
		// repasService.updateRepas(new Repas(RepasToBeUpdated,planning,quantity));
		
		 return "/AffichageRepas.xhtml?faces-redirect=true";
		
	}
	public String getRepasByDate(){
		
		repasrepo.GetRepasByDate(date);
		return "/AffichageRepasdate.xhtml?faces-redirect=true";
		
		}
	 private String nomp;
	 private Date dater;
	public Date getDater() {
		return dater;
	}



	public void setDater(Date dater) {
		this.dater = dater;
	}
   
    	
    	
    	
    	private TypePlat type;
	 

    public TypePlat getType() {
			return type;
		}



		public void setType(TypePlat type) {
			this.type = type;
		}

private int idplan;
public int getIdplan() {
	return idplan;
}



public void setIdplan(int idplan) {
	this.idplan = idplan;
}
private List<Plat> pp;
private List<Date> d;

public List<Date> getD() {
	return d;
}



public void setD(List<Date> d) {
	this.d = d;
}
private List<Data> mydatalist =new ArrayList<>();
private List<Date> dr;
private List<RepasPk> re;
	public List<Data> allrep(){
		Planning p;
    List<Plat> ppl = new ArrayList<>();
		List<Date> l=new ArrayList<>();
    	//List<RepasPk> s=new ArrayList<>();
    	// List<RepasPk> res=new ArrayList<>();
    		List<Planning> plan =new ArrayList<Planning>();
    		p =planrepo.GetPlByDate(date);
    		System.out.println("takwa");
    		 	dr=repasrepo.Getdate(p.getId_planning());
    			System.out.println("planning : "+dr);
    			for(Date r:dr){
    				System.out.println("fel for : "+r);
    				mydatalist.add(new Data(r));
    			System.out.println("fel for2 : "+mydatalist);}
    			/*s= repasrepo.GetRepasByPlanning(p.getId_planning());
    			idplan=p.getId_planning();}
    			for (RepasPk i :s){
    				System.out.println("takwa2");
    				//re.add(i);
    				System.out.println("takwa3");
    				System.out.println("takwa"+i.getIdplat());
    				System.out.println("takwa"+i.getDate());
    				//dater=i.getDate();
    				this.setDater(i.getDate());
    	
    		
    				//dd=d.get(1);
    				d.add(dater);
    				System.out.println("tes"+dd);
    				System.out.println("affichage date"+i.getDate());
    				System.out.println("planning : "+d);
    				System.out.println(s);
    				
    				//ppl=repasrepo.GetPlatdate(dater);
    					//type=u.getTypeplat();
    				/*Plat pl =platrepo.findById(i.getIdplat()).get();
    					System.out.println("takwa3");
    				pp.add(pl);
    				 nomp=pl.getNom();
    				 type=pl.getTypeplat();
    				 System.out.println("takwa"+nomp);
    				 System.out.println("takwa"+i.getIdplanning());*/
    				
    				
    			
    			return mydatalist;
    	
    }

public void process(ActionEvent event) {
  for (Data data : mydatalist) {
    System.out.println("value1=" + data.getValue1() );
  }
}
	public List<Data> getMydatalist() {
		return mydatalist;
	}



	public void setMydatalist(List<Data> mydatalist) {
		this.mydatalist = mydatalist;
	}



	public List<Date> getDr() {
		return dr;
	}



	public void setDr(List<Date> dr) {
		this.dr = dr;
	}



	public List<Plat> getp(Date date){
		 List<Plat> ppl = new ArrayList<>();
		 ppl=repasrepo.GetPlatdate(date);
		 System.out.println("takwa1"+date);
		 for(Plat p:ppl){
			 System.out.println("takwa2");
			// pp.add(p);
			 System.out.println("takwa3");
		 }
		 return ppl;
		
	}
	public List<RepasPk> getRe() {
		return re;
	}



	public void setRe(List<RepasPk> re) {
		this.re = re;
	}



	public List<Plat> getPp() {
		return pp;
	}



	public void setPp(List<Plat> pp) {
		this.pp = pp;
	}



	public String GetByPlanning(Date date){
		allrep();
		
        return "/RepasPlan.xhtml?faces-redirect=true";
		
			
		
	
		
		
		
	}
	/*public String Search(){
		
		GetByPlanning();
		return "/AffichageRepasplanning.xhtml?faces-redirect=true";
		
	}*/







	public String getNomp() {
		return nomp;
	}



	public void setNomp(String nomp) {
		this.nomp = nomp;
	}
/*	public List<Integer> starsVide (int pubId)
	{ 
		List<Integer> list = new ArrayList<Integer>();
		for (int i = (int) repasservice.getRating(pubId) ; i<= 4 ; i++) 
				{
			list.add(1);
				}
		return list;
	}
	public List<Integer> stars (int pubId)
	{ 
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i<= publicityService.getRating(pubId) ; i++) 
				{
			list.add(1);
				}
		return list;
	}
	*/ 
	private float note;
	
		public void addRating(int id,float note){ 
			long i=1;
			//User u=userrepo.findById(i).get();
			System.out.println("debut");
			ratingRestoPk ratepk =new ratingRestoPk();
			System.out.println(id);
		    ratepk.setIdplan(id);
		    ratepk.setIduser(i);
		    System.out.println(i);
		    ratingResto r=new ratingResto();
		    r.setRatingrestopk(ratepk);
		    r.setNote(note);
		    System.out.println(note);
		    ratingresto.addRating(r,id,i);
		    System.out.println("fin");
			
		}



		public float getNote() {
			return note;
		}



		public void setNote(float note) {
			this.note = note;
		}
		private int prix;


		
		public int getPrix() {
			return prix;
		}



		public void setPrix(int prix) {
			this.prix = prix;
		}
		/*private List<Integer> prixtotal =new ArrayList<>();
		public List<Integer> CalculPrix(RepasPk rpk){
			allrepas = repasService.GetAllRepas();
			for(Repas r:allrepas){
			
			Prix=platservice.PrixTotalRepas(r.getRepasPK());
			System.out.println("takwa"+Prix);
			prixtotal.add(Prix);
			}
			return prixtotal;
			
		}*/
		private List<Integer> prixtotal =new ArrayList<>();
		public List<Integer> getPrixtotal() {
			return prixtotal;
		}



		public void setPrixtotal(List<Integer> prixtotal) {
			this.prixtotal = prixtotal;
		}



		
		private String nompp;
		private List<String> listPls =new ArrayList<>();
		public List<String> getListPls() {
			return listPls;
		}
		private String pNormal;
		public String getpNormal() {
			return pNormal;
		}



		public void setpNormal(String pNormal) {
			this.pNormal = pNormal;
		}
		private List<String> listspecial =new ArrayList<>();

		public List<String> getListspecial() {
			return listspecial;
		}

private String pSpecial;

		public String getpSpecial() {
	return pSpecial;
}



public void setpSpecial(String pSpecial) {
	this.pSpecial = pSpecial;
}



		public void setListspecial(List<String> listspecial) {
			this.listspecial = listspecial;
		}
		private List<String> listNormal =new ArrayList<>();
		private List<Plat> affnormal =new ArrayList<>();
		private List<Plat> affspecial =new ArrayList<>();


		public List<Plat> getAffnormal() {
			return affnormal;
		}



		public void setAffnormal(List<Plat> affnormal) {
			this.affnormal = affnormal;
		}



		public List<Plat> getAffspecial() {
			return affspecial;
		}



		public void setAffspecial(List<Plat> affspecial) {
			this.affspecial = affspecial;
		}



		public List<String> getListNormal() {
			return listNormal;
		}



		public void setListNormal(List<String> listNormal) {
			this.listNormal = listNormal;
		}



		public void setListPls(List<String> listPls) {
			this.listPls = listPls;
		}



		public String getNompp() {
			return nompp;
		}



		public void setNompp(String nompp) {
			this.nompp = nompp;
		}
		

       public List<String> GetPlatsNormal(){
    	  
    	   List<Plat> pn=new ArrayList<>();
    	  pn= platrepo.GetPlatByType(TypePlat.Plat_Normal);
    	  for(Plat p:pn){
    		  pNormal=p.getNom();
    		  listNormal.add(pNormal);
    		  
    		  
    	  }
    	  return listNormal;
    	   	   
       }
       public List<Plat> GetNormal(){
     	  
    	   List<Plat> pn=new ArrayList<>();
    	  pn= platrepo.GetPlatByType(TypePlat.Plat_Normal);
    	  for(Plat p:pn){
    		 
    		  affnormal.add(p);
    		  
    		  
    	  }
    	  return affnormal;
    	   	   
       }
       public List<Plat> GetSpecial(){
      	  
    	   List<Plat> pn=new ArrayList<>();
    	  pn= platrepo.GetPlatByType(TypePlat.Plat_Special);
    	  for(Plat p:pn){
    		 
    		  affspecial.add(p);
    		  
    		  
    	  }
    	  return affspecial;
    	   	   
       }
       public List<String> GetPlatsSpecial(){
     	  
    	   List<Plat> pn=new ArrayList<>();
    	  pn= platrepo.GetPlatByType(TypePlat.Plat_Special);
    	  for(Plat p:pn){
    		  pSpecial=p.getNom();
    		  listspecial.add(pSpecial);
    		  
    		  
    	  }
    	  return listspecial;
    	   	   
       }

		public List<String> GetAllPlat(){
			List<Plat> pl=new ArrayList<>();
			 pl = platservice.AllPlats();
			 for (Plat p:pl){
				 nompp=p.getNom();
				 listPls.add(nompp);
				 System.out.println("Takwa" +listPls);
				 
			 }
			 return listPls;

		 }
		public String addRep(){
			
			List<Enfant>enfants=enfantrepo.GetEnfantabonnée();
			
			enfants.forEach(e->{if(e.getEtat().equals(Etat.Normal))
			{int n =repasService.nbenfantnormal();
			RepasPk rp=new RepasPk();
			rp.setDate(date);
			platrepo.GetId(pNormal);
			rp.setIdplat(platrepo.GetId(pNormal));
			int id=planservice.GetIDPlan(date);
			rp.setIdplanning(id);
			Repas r=new Repas();
			r.setRepasPK(rp);
			r.setQuantity(n);
			
			repasrepo.save(r);}
			else if (e.getEtat().equals(Etat.Special)){
				int s=repasService.nbenfantspeacial();
				RepasPk rp=new RepasPk();
				rp.setDate(date);
				platrepo.GetId(pSpecial);
				rp.setIdplat(platrepo.GetId(pSpecial));
				int id=planservice.GetIDPlan(date);
				rp.setIdplanning(id);
				Repas r=new Repas();
				r.setRepasPK(rp);
				r.setQuantity(s);
				repasrepo.save(r);
				
				
			}
			});
			return "/AffichageRepas.xhtml?faces-redirect=true";
		}
		public  String GoToFormAdd(){
			return "/AddRepas.xhtml?faces-redirect=true";
		}
		public void badRepas(){
			ratingresto.badrepad(2);
		}
		public  String GoBackRepas(){
			return "/AffichageRepas.xhtml?faces-redirect=true";
		}
		
	}
	

