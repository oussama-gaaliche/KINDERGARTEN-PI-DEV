package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Classe;


@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
	  

}
