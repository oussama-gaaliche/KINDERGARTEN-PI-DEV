package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Repository.ArticleRepository;
import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Planning;



@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	ArticleRepository articlerepo;
	
	@Override
	public int addArticle(Article a) {
		articlerepo.save(a);
		return 1;
	}
	
	private static final Logger l=LogManager.getLogger(ArticleServiceImpl.class);
	@Override
	public List<Article> retrieveAllArticles(){
		List<Article> articles = (List<Article>) articlerepo.findAll();
		for (Article a : articles){
			l.info("article +++"+a);
		}
		return articles;
	}
	

	@Override
	public void deleteArticle(int id) {
		articlerepo.deleteById((long) id);		
	}
	
	@Override
	public Article updateArticle(Article a) {
		articlerepo.save(a);
		 return a;
	}

}
