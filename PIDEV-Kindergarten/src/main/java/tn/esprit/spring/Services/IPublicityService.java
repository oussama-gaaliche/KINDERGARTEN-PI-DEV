package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Publicity;


public interface IPublicityService {
	List<Publicity> retrieveAllPublicities();
	Publicity addPublicity(Publicity p);
	void deletePublicity(int i);
	Publicity updatePublicity(Publicity p);
	Publicity retrievePublicity(int id);

}
