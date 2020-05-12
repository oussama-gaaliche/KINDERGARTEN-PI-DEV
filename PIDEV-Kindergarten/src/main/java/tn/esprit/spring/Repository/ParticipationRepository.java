package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Participation;
@Repository
public interface ParticipationRepository extends CrudRepository<Participation, Integer>{
@Query(value="select p.etat from Participation p where p.user_participation.id=:iduser and p.event_participation.id=:idevent")
	
	public String getEtat_participationByParticipation(@Param("iduser")long iduser, @Param("idevent")int idevent)  ;

@Query(value="select p from Participation p where p.user_participation.id=:iduser and p.event_participation.id=:idevent")

public  Participation getParticipationByeventAnduser(@Param("iduser")long iduser, @Param("idevent")int idevent);

@Query(value="select p.etat from Participation p where p.user_participation.id=:iduser and p.event_participation.id=:idevent ")

public String getEtat_participationByParticipatio(@Param("iduser")long iduser, @Param("idevent")int idevent);


@Modifying
@Transactional
@Query("DELETE FROM  Participation p where p.user_participation.id=:iduser and p.event_participation.id=:idevent") 

public void deleteParticipationByiduserandIdevent(@Param("iduser")long iduser, @Param("idevent")int idevent);


}
