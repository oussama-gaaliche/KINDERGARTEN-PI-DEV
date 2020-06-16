package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CountWord;


@Repository
public interface WordCountRepository extends JpaRepository<CountWord, Long> { 
	@Query("select word, NbrRepi from CountWord group by NbrRepi  ")
	public List<?> listcountm();
	

}
