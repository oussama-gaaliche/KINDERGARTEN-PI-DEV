package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.FamilleArticles;
import tn.esprit.spring.entity.User;

public interface IArticleService {

	int addArticle(Article a);

	void deleteArticle(int id);

	List<Article> retrieveAllArticles();

	Article updateArticle(Article a);

	List<Article> retrieveAllArticlesByStock();

	List<Article> retrieveArticlesByCommand(Long id);

	List<Article> retrieveArticlesByFamille(FamilleArticles f1);

	double calculTva(Article a);

	void controleStock(Article a);



}
