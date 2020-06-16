package tn.esprit.spring.Repository;


import java.util.List;

import tn.esprit.spring.entity.ratingResto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ratingRestoRepository extends JpaRepository <ratingResto, Integer> {
	
	@Query("SELECT count(*) FROM ratingResto r where (r.ratingrestopk.idplan =:id)")
    public int nbreviews(@Param ("id") int id);
	
	@Query("select r from ratingResto r where r.ratingrestopk.idplan=:id order by r.dateRating desc")
	public List<ratingResto> listReviews(@Param("id") int id);
	
	@Query("select r.ratingrestopk.idplan from ratingResto r where r.ratingrestopk.idplan=:idp ")
	public int planrate(@Param("idp") int idp);
	@Query("select r.ratingrestopk.iduser from ratingResto r where r.ratingrestopk.iduser=:u ")
	public long userrate(@Param("u") long u);
	@Query("SELECT count(*) FROM ratingResto r where (r.ratingrestopk.idplan =:id)")
    public int reviewRepas(@Param ("id") int id);
	@Query("SELECT count(*) From ratingResto r where r.ratingrestopk.idplan =:id and r.note <3")
	public int ratingbadrepas(@Param ("id") int id);
	
	

}
