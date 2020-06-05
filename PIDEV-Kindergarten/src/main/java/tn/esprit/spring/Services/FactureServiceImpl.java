package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Repository.FactureRepository;
import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Facture;

@Service
@Transactional
public class FactureServiceImpl implements IFactureService {
	@Autowired
	FactureRepository fr;
	
	@Override
	public int addFacture(Facture f) {
		fr.save(f);
		return 1;
	}
	
	private static final Logger l=LogManager.getLogger(FactureServiceImpl.class);
	@Override
	public List<Facture> retrieveAllFacture(){
		List<Facture> factures = (List<Facture>) fr.findAll();
		for (Facture f : factures){
			l.info("facture +++"+f);
		}
		return factures;
	}
	
	@Override
	public Facture updateFacture(Facture f) {
		fr.save(f);
		 return f;
	}
	
	@Override
	public void deleteFacture(int id) {
		fr.deleteById((long) id);		
	}
	
}
