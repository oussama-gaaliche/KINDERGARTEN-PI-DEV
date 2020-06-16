package tn.esprit.spring.Services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.Repository.PlatRepository;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.IngredientPlatPk;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.RepasPk;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class PlatServiceImpl implements PlatService {
	@Autowired
	PlatRepository platrepo;

	@Override
	public Plat AddPlat(Plat p) {
		platrepo.save(p);
		return p;
	}

	@Override
	public Plat updatePlat(Plat p) {
		platrepo.save(p);
		return p;
	}

	@Override
	public void DeletePlat(int id) {
		Plat plat= platrepo.findById(id).get();
		platrepo.delete(plat);
		
	}

	@Override
	public List<Plat> GetPlatByType(TypePlat tp) {
		 return platrepo.GetPlatByType(tp);
		
	}
	
		

	@Override
	public List<Plat> AllPlats() {
		return platrepo.findAll();
		
	}

	@Override
	public List<Plat> GetRepasByPlat() {
		Date date=null;
		return platrepo.GetRepasByPlat(date);
	}

	
	@Override
	public double getQuntityByPlat(int p) {
		return platrepo.getQuntityByPlat(p);
	}
	public String getAlphaNumericString(int n) 
	  { 

	      // chose a Character random from this String 
	      String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                  + "0123456789"
	                                  + "abcdefghijklmnopqrstuvxyz"; 

	      // create StringBuffer size of AlphaNumericString 
	      StringBuilder sb = new StringBuilder(n); 

	      for (int i = 0; i < n; i++) { 

	          // generate a random number between 
	          // 0 to AlphaNumericString variable length 
	          int index 
	              = (int)(AlphaNumericString.length() 
	                      * Math.random()); 

	          // add Character one by one in end of sb 
	          sb.append(AlphaNumericString 
	                        .charAt(index)); 
	      } 

	      return sb.toString(); 
	  }

	
	@Override
	public int PrixTotalRepas(RepasPk rpk) {
		int m=0;
		double q;
		//List<Plat>plat=platrepo.GetRepasByPlat();
        // for(Plat p:plat){
        	// q=platrepo.getQuntityByPlat(p.getId_plat());
        	//m=m+p.getPrix()*q;  
        	  //}
        	  return m;
        	   
	}

	
		
	}


