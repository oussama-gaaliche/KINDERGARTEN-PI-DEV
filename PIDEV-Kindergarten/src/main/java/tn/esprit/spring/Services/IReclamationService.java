package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.data.repository.query.Param;


import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.TypeReclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.reclamation;

public interface IReclamationService {
	public List<reclamation> getAllReclamations();

	public reclamation getReclamationById(long id);

	public reclamation ajouterReclamation(reclamation rec);
	public reclamation addReclamation(String body , TypeReclamation typeReclamation);

	public void supprimerReclamation(long id);
	public List<reclamation> getLastReclamations(User user) ;
	public List<reclamation> findByTypeReclamationOrderByPostedDesc( TypeReclamation typeReclamation);
	public List<reclamation> findReclamationsBySender(User sender);
	public Long addOrUpdateReclamation(reclamation rec) ;
	
	public List<reclamation> searchRec(String msg);
	



}
