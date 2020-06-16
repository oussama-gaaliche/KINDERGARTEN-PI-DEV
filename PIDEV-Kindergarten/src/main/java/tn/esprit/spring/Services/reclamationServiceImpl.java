package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import tn.esprit.spring.Repository.reclamationRepository;
import tn.esprit.spring.entity.TypeReclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.reclamation;

@Service
public class reclamationServiceImpl implements IReclamationService {
	@Autowired
	reclamationRepository reclamationrepository ;

	@Override
	public List<reclamation> getAllReclamations() {
		return Lists.newArrayList(reclamationrepository.findAll());
	}

	@Override
	public reclamation getReclamationById(long id) {
		return reclamationrepository.getReclamationById(id);
	}

	@Override
	public reclamation ajouterReclamation(reclamation rec) {
		  return reclamationrepository.save(rec);
	}

	@Override
	public void supprimerReclamation(long id) {
		reclamationrepository.deleteById(id);
		
	}

	@Override
	public List<reclamation> getLastReclamations(User user) {
		return reclamationrepository.findLastReclamationsByUser(user);
	}

	

	@Override
	public reclamation addReclamation(String body, TypeReclamation typeReclamation) {
		// TODO Auto-generated method stub
		return reclamationrepository.save(new reclamation (body,typeReclamation));
	}

	@Override
	public List<reclamation> findReclamationsBySender(User sender) {
		// TODO Auto-generated method stub
		return reclamationrepository.findReclamationsBySender(sender);
	}
	@Override
	public Long addOrUpdateReclamation(reclamation rec) {
		reclamationrepository.save(rec);
		return rec.getId();
	}

	@Override
	public List<reclamation> findByTypeReclamationOrderByPostedDesc(TypeReclamation typeReclamation) {
		// TODO Auto-generated method stub
		return reclamationrepository.findByTypeReclamationOrderByPostedDesc(typeReclamation);
	}
	@Override
	public List<reclamation> searchRec(String msg) {

		return reclamationrepository.searchReclamation(msg);
	}

	

	

}
