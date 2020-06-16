package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.poststats;

@Repository
public interface PostStatRepository extends JpaRepository<poststats, Long> {
	@Query("select count (*)  from Post where contained like 'ba3' ")
	public List<?> listPostStat();

	@Query("select contained from Post")
	public String[] selectcontained();

	@Query("select count(e.words) from poststats e " + "where e.words=:word")
	public int calculnbrofreposts(@Param("word") String word);
	
	@Query("Select words, count(*) from poststats GROUP by words ")
	public List<List<String>> countwords();
}
//Select postwotrds, count(*) from poststats GROUP by postwotrds
