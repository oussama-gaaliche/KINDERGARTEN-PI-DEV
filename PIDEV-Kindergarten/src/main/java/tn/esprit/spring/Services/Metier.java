package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import tn.esprit.spring.Repository.CreneauRepository;
import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.RvRepository;
import tn.esprit.spring.Repository.TeacherRepository;
import tn.esprit.spring.domain.AgendaTeacherJour;
import tn.esprit.spring.domain.CreneauTeacherJour;
import tn.esprit.spring.entity.Creneau;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Rv;
import tn.esprit.spring.entity.Teacher;
import tn.esprit.spring.entity.reclamation;

@Service

public class Metier implements IMetier {
	@Autowired
	private CreneauRepository creneauRepository;
	@Autowired
	private RvRepository rvRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private EnfantRepository enfantRepository;

	@Override
	public List<Creneau> getAllCreneaux(long idTeacher) {
		return Lists.newArrayList(creneauRepository.getAllCreneaux(idTeacher));
	}

	@Override
	public List<Rv> getRvTeacherJour(long idTeacher, Date jour) {
		return Lists.newArrayList(rvRepository.getRvTeacherJour(idTeacher, jour));
	}

	@Override
	public Rv getRvById(long id) {
		return rvRepository.getRvById(id);
	}

	@Override
	public Creneau getCreneauById(long id) {
		return creneauRepository.getCreneauById(id);
	}





	@Override
	public AgendaTeacherJour getAgendaTeacherJour(long idTeacher, Date jour) {
		// liste des créneaux horaires du teacher
		List<Creneau> creneauxHoraires = getAllCreneaux(idTeacher);
		// liste des réservations de ce même teacher pour ce même jour
		List<Rv> reservations = getRvTeacherJour(idTeacher, jour);
		// on crée un dictionnaire à partir des Rv pris
		Map<Long, Rv> hReservations = new Hashtable<Long, Rv>();
		for (Rv resa : reservations) {
 		hReservations.put(resa.getCreneau().getId(), resa);
		}
		// on crée l'agenda pour le jour demandé
		AgendaTeacherJour agenda = new AgendaTeacherJour();
		// le teacher
		Teacher teacher = teacherRepository.getTeacherById(idTeacher);
		agenda.setTeacher(teacher);
		// le jour
		agenda.setJour(jour);
		// les créneaux de réservation
		CreneauTeacherJour[] creneauxTeacherJour = new CreneauTeacherJour[creneauxHoraires.size()];
		agenda.setCreneauxTeacherJour(creneauxTeacherJour);
		// remplissage des créneaux de réservation
		for (int i = 0; i < creneauxHoraires.size(); i++) {
			// ligne i agenda
			creneauxTeacherJour[i] = new CreneauTeacherJour();
			// créneau horaire
			Creneau créneau = creneauxHoraires.get(i);
			long idCreneau = créneau.getId();
		creneauxTeacherJour[i].setCreneau(créneau);
	// le créneau est-il libre ou réservé ?
			if (hReservations.containsKey(idCreneau)) {
				// le créneau est occupé - on note la résa
			Rv resa = hReservations.get(idCreneau);
			creneauxTeacherJour[i].setRv(resa);
		}
		}
		// on rend le résultat
		return agenda;

	}

	@Override
	public List<Enfant> getAllEnfants() {
		return Lists.newArrayList(enfantRepository.findAll());
	}

	@Override
	public Enfant getEnfantById(long id) {
		return enfantRepository.getOne(id);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return Lists.newArrayList(teacherRepository.findAll());
	}

	@Override
	public Teacher getTeacherById(long id) {
		return teacherRepository.getTeacherById(id);

	}

	@Override
	public void supprimerRv(Rv rv) {
		rvRepository.deleteById(rv.getId());
		
	}
	@Override
	public Rv ajouterRv(Rv rv) {
        return rvRepository.save(rv);

	}

	@Override
	public Rv ajouterRdv(Date jour, Creneau créneau, Enfant enfant) {
		// TODO Auto-generated method stub

		return rvRepository.save(new Rv (jour, créneau, enfant));
	}
	
	@Override
	public void deleteRv(Long idRv) {
		rvRepository.deleteById(idRv);
	}

	@Override
	public Creneau ajouterCreneau(Creneau creneau) {
		// TODO Auto-generated method stub
		return creneauRepository.save(creneau);
	}
	@Override
	public Long addOrUpdateCreneau(Creneau creneau) {
		creneauRepository.save(creneau);
		return creneau.getId();
	}
	@Override
	public void supprimerCreneau(long id) {
		creneauRepository.deleteById(id);
		
	}


	
}
