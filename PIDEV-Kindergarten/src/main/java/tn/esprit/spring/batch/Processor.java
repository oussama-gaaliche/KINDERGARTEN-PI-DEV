package tn.esprit.spring.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Article;
@Component
public class Processor implements ItemProcessor<Article, Article> {
	private Processor(){
		
	}
	@Override
	public Article process(Article article) throws Exception {
		article.getQteStock();
		return null;
	}

}
