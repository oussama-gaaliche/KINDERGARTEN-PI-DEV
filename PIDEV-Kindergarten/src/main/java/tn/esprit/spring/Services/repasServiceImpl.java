package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.PlatRepository;
import tn.esprit.spring.Repository.RepasRepository;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Etat;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import tn.esprit.spring.entity.RepasPk;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class repasServiceImpl implements RepasService {
	
	@Autowired
	RepasRepository repasrepo;
	@Autowired
	EnfantRepository enfantrepo;
	@Autowired
	PlatRepository platrepo;

	@Override
	public int addRepas(int Planningid,Date date)
	 {  
		
		List<Enfant>enfants=enfantrepo.GetEnfantabonnée();
		
		enfants.forEach(e->{if(e.getEtat().equals(Etat.Normal)){
			int n=nbenfantnormal();	
			Plat plat=new Plat();
			plat=platrepo.GetByType(TypePlat.Plat_Normal);
			RepasPk rp=new RepasPk();
			rp.setDate(date);
			rp.setIdplanning(Planningid);
			rp.setIdplat(plat.getId_plat());
			Repas repas =new Repas();
			repas.setRepasPK(rp);
			repas.setQuantity(n);
			repasrepo.save(repas);}
		else if (e.getEtat().equals(Etat.Special)){
				 int s=nbenfantspeacial();
				Plat plat=new Plat();
				plat=platrepo.GetByType(TypePlat.Plat_Special);
					RepasPk rp=new RepasPk();
					rp.setDate(date);
					rp.setIdplanning(Planningid);
					rp.setIdplat(plat.getId_plat());
					Repas repas =new Repas();
					repas.setRepasPK(rp);
					repas.setQuantity(s);
					repasrepo.save(repas);
					
					
					 }
					});
		/*for(Enfant e:enfants)
		{
			int s=0;
			int i=0;
			if(e.getEtat().equals(Etat.Normal)){
				s=s+1;
				List<Plat> plats=platrepo.GetPlatByType(TypePlat.Plat_Normal);
				for(Plat p:plats){
				RepasPk rp=new RepasPk();
				rp.setDate(date);
				rp.setIdplanning(Planningid);
				rp.setIdplat(p.getId());
				Repas repas =new Repas();
				repas.setRepasPK(rp);
				repas.setQuantity(s);
				repasrepo.save(repas);
				 return 1;
				
				 }}
			else if (e.getEtat().equals(Etat.Special)){
					
					i=i+1;
					List<Plat> plats=platrepo.GetPlatByType(TypePlat.Plat_Special);
					for(Plat p:plats){
					RepasPk rp=new RepasPk();
					rp.setDate(date);
					rp.setIdplanning(Planningid);
					rp.setIdplat(p.getId());
					Repas repas =new Repas();
					repas.setRepasPK(rp);
					repas.setQuantity(i);
					repasrepo.save(repas);
					 return 1;}
					}
			else 
				return 0 ;
			
	}*/
		return 1;}

	@Override
	public List<Enfant> GetEnfantabonnée() {
		return enfantrepo.GetEnfantabonnée();
		
	}

	@Override
	public int addenfant(Enfant e) {
		enfantrepo.save(e);
		return 1;
	}
	public int nbenfantnormal(){
		int nb=0;
	List<Enfant>enfants=enfantrepo.GetEnfantabonnée();
		for (Enfant enfant:enfants){
			if(enfant.getEtat().equals(Etat.Normal))
				nb=nb+1;	
		
	}return nb;
	}
	public int nbenfantspeacial(){
		int nb=0;
		List<Enfant>enfants=enfantrepo.GetEnfantabonnée();
			for (Enfant enfant:enfants){
				if(enfant.getEtat().equals(Etat.Special))
					nb=nb+1;}
			return nb;
		}

	@Override
	public List<Repas> repastoday(Date date) {
		List <Repas> re=new ArrayList<>();
		List<Repas> repas=repasrepo.findAll();
		for (Repas r:repas)
		if(r.getRepasPK().getDate().equals(date))
			 re.add(r);
           return re;
		
		    }

	@Override
	public List<Repas> GetRepasByDate() {
		Date date=new Date();
		return repasrepo.GetRepasByDate(date);
		
	}

	@Override
	public List<Repas> GetRepasByPlanning(int p) {
		return repasrepo.GetRepasByPlanning(p);
	}
	
	


}


