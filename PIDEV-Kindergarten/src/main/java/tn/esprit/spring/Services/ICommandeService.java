package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Commande;

public interface ICommandeService {

	int addCommand(Commande f);

	List<Commande> retrieveAllCommands();
	
	public void ajouterCommande(Long idArticle,int qte);

	//Commande updateCommand(Commande f);

	//void deleteCommand(int id);


	//void command(Commande c);

	//void addToPanier(Commande c, Article a);

}
