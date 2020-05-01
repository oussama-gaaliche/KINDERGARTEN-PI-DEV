package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;

import tn.esprit.spring.entity.Publicity;


public interface IPublicityService {
	List<Publicity> retrieveAllPublicities(Long id);
	List<Publicity> retrieveAllPublicitiesPub();
	String addPublicity(Publicity p);
	void deletePublicity(int i);
    public void updatePublicity();
	Publicity retrievePublicity(int idUser);
    void updateRating();
 

}
