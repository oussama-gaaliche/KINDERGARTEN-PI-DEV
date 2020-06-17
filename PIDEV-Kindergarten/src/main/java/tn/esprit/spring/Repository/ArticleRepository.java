package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.FamilleArticles;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	@Query("select a FROM Article a where (a.qteStock>a.qteMin)")
	List<Article> retrieveAllArticlesByStock();
	@Modifying
	@Query("update Article a set a.qteStock = a.qteStock- :stock where a.id_article = :id")
	int updateArticleQteById( @Param("stock") int stock,@Param("id") Long long1);
	@Query("select a FROM Article a where a.id_article.id = :id")
	List<Article> retrieveArticlesByCommand(@Param("id") Long long1);
	@Query("select a FROM Article a where a.famille = :f and a.qteStock>a.qteMin")
	List<Article> retrieveArticlesByFamille(@Param("f") FamilleArticles f1);
	
}
