package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.PublicityRepository;
import tn.esprit.spring.entity.Publicity;





@Service
public class PublicityServiceImpl implements IPublicityService {
	  @Autowired
	    private PublicityRepository PublicityRepository;
		private static final Logger L =(Logger) LogManager.getLogger(PublicityServiceImpl.class);
	@Override
	public List<Publicity> retrieveAllPublicities() {
		List<Publicity> publicities = (List<Publicity>) PublicityRepository.findAll();
		for (Publicity publicity : publicities) {
			L.info("user +++ : " + publicity);
		}
		return publicities;
	}

	@Override
	public Publicity addPublicity(Publicity p) {
		return PublicityRepository.save(p);
	}

	@Override
	public void deletePublicity(int i) {
		PublicityRepository.deleteById(i);
		
	}

	@Override
	public Publicity updatePublicity(Publicity p) {
		return PublicityRepository.save(p);
	}

	@Override
	public Publicity retrievePublicity(int id) {
		Publicity u = PublicityRepository.findById((id)).orElse(null); 
		
		return u;
	}
	

}
