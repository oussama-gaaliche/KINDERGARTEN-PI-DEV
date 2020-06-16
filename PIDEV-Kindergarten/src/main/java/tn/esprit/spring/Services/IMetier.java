package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.domain.AgendaTeacherJour;
import tn.esprit.spring.entity.Creneau;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Rv;
import tn.esprit.spring.entity.Teacher;
import tn.esprit.spring.entity.reclamation;

public interface IMetier {
	public List<Enfant> getAllEnfants();

	public List<Teacher> getAllTeachers();

	public List<Creneau> getAllCreneaux(long idTeacher);

	public List<Rv> getRvTeacherJour(long idTeacher, Date jour);

	public Enfant getEnfantById(long id);

	public Teacher getTeacherById(long id);

	public Rv getRvById(long id);

	public Creneau getCreneauById(long id);

	public Rv ajouterRv(Rv rv);
	
	public Rv ajouterRdv(Date jour,  Creneau créneau, Enfant enfant); 
	public Creneau ajouterCreneau(Creneau creneau); 

	public void supprimerRv(Rv rv);

	public AgendaTeacherJour getAgendaTeacherJour(long idTeacher, Date jour);

	public void deleteRv(Long idRv) ;
	
	public Long addOrUpdateCreneau(Creneau creneau);
	public void supprimerCreneau(long id);


}
