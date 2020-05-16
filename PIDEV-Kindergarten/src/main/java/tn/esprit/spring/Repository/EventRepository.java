<<<<<<< HEAD
package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Event;

import tn.esprit.spring.entity.Salle;
import tn.esprit.spring.entity.User;

public interface EventRepository extends CrudRepository<Event, Integer>{
	
	@Query("select e from Event e where e.category =:category and e.title =:titre ")
	
	public List<Event> getAllEventByCategorieAndNom(@Param("category")Category category, @Param("titre") String titre);
	
@Query("select e from Event e where e.category=:category")
	
	public List<Event> getAllEventByCategorie(@Param("category")Category category);

@Query("select e from Event e where e.title=:titre ")

public List<Event> getAllEventByNom(@Param("titre") String titre);
	
	

@Query("SELECT count(*) FROM Event e where e.Userseventmaker =:iduser")
    public int countevents(@Param("iduser")User user);


@Query("SELECT e from Event e where e.Userseventmaker.id=:iduser order by e.start_date")
  public List<Event> getAllEventOrdonneParDate(@Param("iduser") long iduser );


 @Query("SELECT e from Event e where e.start_date = CURRENT_DATE()")
 public List<Event> getAllEventPourToday();

 @Query("select e.salle from Event e where e.id=:id")
	
	public Salle getsalleeventbyid(@Param("id")int id);



}
=======
package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Event;

import tn.esprit.spring.entity.Salle;
import tn.esprit.spring.entity.User;

public interface EventRepository extends CrudRepository<Event, Integer>{
	
	@Query("select e from Event e where e.category =:category and e.title =:titre ")
	
	public List<Event> getAllEventByCategorieAndNom(@Param("category")Category category, @Param("titre") String titre);
	
@Query("select e from Event e where e.category=:category")
	
	public List<Event> getAllEventByCategorie(@Param("category")Category category);

@Query("select e from Event e where e.title=:titre ")

public List<Event> getAllEventByNom(@Param("titre") String titre);
	
	

@Query("SELECT count(*) FROM Event e where e.Userseventmaker =:iduser")
    public int countevents(@Param("iduser")User user);


@Query("SELECT e from Event e where e.Userseventmaker.id=:iduser order by e.start_date")
  public List<Event> getAllEventOrdonneParDate(@Param("iduser") long iduser );


 @Query("SELECT e from Event e where e.start_date = CURRENT_DATE()")
 public List<Event> getAllEventPourToday();

 @Query("select e.salle from Event e where e.id=:id")
	
	public Salle getsalleeventbyid(@Param("id")int id);



}
>>>>>>> branch 'master' of https://github.com/gaaliche22/KINDERGARTEN-PI-DEV.git
