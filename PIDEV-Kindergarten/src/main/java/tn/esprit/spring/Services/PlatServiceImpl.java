package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.Repository.PlatRepository;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Planning;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlatServiceImpl implements PlatService {
	@Autowired
	PlatRepository platrepo;

	@Override
	public int AddPlat(Plat p) {
		platrepo.save(p);
		return 1;
	}

	@Override
	public Plat updatePlat(Plat p) {
		platrepo.save(p);
		return p;
	}

	@Override
	public void DeletePlat(int id) {
		platrepo.deleteById(id);
		
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
		return platrepo.GetRepasByPlat();
	}

	@Override
	public double PrixTotalRepas() {
		double m=0;
		double q;
		List<Plat>plat=platrepo.GetRepasByPlat();
         for(Plat p:plat){
        	 q=platrepo.getQuntityByPlat(p.getId());
        	 m=m+p.getPrix()*q;  
        	  }
        	  return m;
        	   
           }

	@Override
	public double getQuntityByPlat(int p) {
		return platrepo.getQuntityByPlat(p);
	}
		
	}


