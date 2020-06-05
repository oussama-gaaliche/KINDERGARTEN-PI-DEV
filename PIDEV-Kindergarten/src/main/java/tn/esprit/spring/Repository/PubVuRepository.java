package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.PubVu;

@Repository
public interface PubVuRepository extends JpaRepository<PubVu, Integer> {
	@Query("SELECT count(*) FROM PubVu pv where (pv.publicity.id =:idPublicity)")
	public int nbVu(@Param ("idPublicity") int idPublicity);
}
