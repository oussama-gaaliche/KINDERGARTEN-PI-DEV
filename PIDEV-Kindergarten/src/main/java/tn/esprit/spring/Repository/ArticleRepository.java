package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
