package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Classe;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.User;
@Repository
public interface EnfantRepository extends JpaRepository<Enfant, Long> {
	List<Enfant> findByUser(User long1);
	@Query("select count(e) from Enfant e where e.classe=:co")
    int findsizeofclasse(@Param("co")Classe classe);

}
