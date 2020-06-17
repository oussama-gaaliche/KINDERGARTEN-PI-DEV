package tn.esprit.spring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>{
	@Query("select f FROM Facture f where f.num_fact = :num")
	Optional<Facture> retrieveFactureByNum(@Param("num") String num);
}
