package tn.esprit.spring.batch;



import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import tn.esprit.spring.entity.Article;
@Component
public class ArticleItemProcessor implements ItemProcessor<Article, Article> {
	
	@Override
	public Article process(Article article) throws Exception {
		return article;
	}
}
