package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.VillesLivraison;
@Repository
public interface VillesRepository extends JpaRepository<VillesLivraison, Long>{

}
