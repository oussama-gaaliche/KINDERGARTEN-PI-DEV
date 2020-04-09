package tn.esprit.spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ArticleRepository;
import tn.esprit.spring.entity.Article;

@Service
public class ArticleService implements IArticleService {

	@Autowired
	ArticleRepository articlerepo;
	
	@Override
	public int addArticle(Article a) {
		articlerepo.save(a);
		return 1;
	}

	

	@Override
	public void deleteArticle(int id) {
		articlerepo.deleteById((long) id);
		
		
	}

}
