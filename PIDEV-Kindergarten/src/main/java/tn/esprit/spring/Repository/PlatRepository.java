package tn.esprit.spring.Repository;

import java.util.List;

import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.TypePlat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PlatRepository extends JpaRepository<Plat, Integer> {
	 @Query("SELECT p FROM Plat p  where p.typeplat =:tp")
	    public List<Plat> GetPlatByType( @Param("tp") TypePlat tp);

}
