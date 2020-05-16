<<<<<<< HEAD
package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Reservation_Stock_Interne;

@Repository
public interface Reservation_Stock_InterneRepository extends CrudRepository<Reservation_Stock_Interne, Integer> {

	
	@Query(value="Select r from Reservation_Stock_Interne r where r.event.id= :eventId")
    public List<Reservation_Stock_Interne> Selectreservationbyidevent(@Param("eventId")int eventId);
 	
    @Modifying
    @Transactional
    @Query("DELETE FROM  Reservation_Stock_Interne r where r.event.id=:idevent ") 

    public void deleteReservationByIdevent(@Param("idevent")int idevent);

    	
}
=======
package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Reservation_Stock_Interne;

@Repository
public interface Reservation_Stock_InterneRepository extends CrudRepository<Reservation_Stock_Interne, Integer> {

	
	@Query(value="Select r from Reservation_Stock_Interne r where r.event.id= :eventId")
    public List<Reservation_Stock_Interne> Selectreservationbyidevent(@Param("eventId")int eventId);
 	
    @Modifying
    @Transactional
    @Query("DELETE FROM  Reservation_Stock_Interne r where r.event.id=:idevent ") 

    public void deleteReservationByIdevent(@Param("idevent")int idevent);

    	
}
>>>>>>> branch 'master' of https://github.com/gaaliche22/KINDERGARTEN-PI-DEV.git
