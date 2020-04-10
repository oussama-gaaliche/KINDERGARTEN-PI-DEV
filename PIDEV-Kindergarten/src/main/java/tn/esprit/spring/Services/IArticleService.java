package tn.esprit.spring.Services;

import tn.esprit.spring.entity.Article;

public interface IArticleService {

	int addArticle(Article a);

	void deleteArticle(int id);

}
