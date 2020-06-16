package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.User;

public interface IArticleService {

	int addArticle(Article a);

	void deleteArticle(int id);

	List<Article> retrieveAllArticles();

	Article updateArticle(Article a);

}
