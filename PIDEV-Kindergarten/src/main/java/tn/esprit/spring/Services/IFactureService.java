package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Facture;

public interface IFactureService {

	int addFacture(Facture f);

	List<Facture> retrieveAllFacture();

	Facture updateFacture(Facture f);

	void deleteFacture(int id);

}
