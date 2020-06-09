package tn.esprit.spring.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import tn.esprit.spring.entity.Teacher;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * L'entité [AgendaTeacherJour] est un entité métier il est l'agenda d'un
 * enseignant pour un jour donné, ç-à-d la liste de ses rendez-vous
 */
public class AgendaTeacherJour implements Serializable {

	private static final long serialVersionUID = 1L;

	// champs
	private Teacher teacher;
	private Date jour;
	private CreneauTeacherJour[] creneauxTeacherJour;

	// constructeurs
	public AgendaTeacherJour() {

	}

	public AgendaTeacherJour(Teacher teacher, Date jour, CreneauTeacherJour[] creneauxTeacherJour) {
		this.teacher = teacher;
		this.jour = jour;
		this.creneauxTeacherJour = creneauxTeacherJour;
	}

	public String toString() {
		StringBuffer str = new StringBuffer("");
		for (CreneauTeacherJour cr : creneauxTeacherJour) {
			str.append(" ");
			str.append(cr.toString());
		}
		return String.format("Agenda[%s,%s,%s]", teacher, new SimpleDateFormat("dd/MM/yyyy").format(jour),
				str.toString());
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date  getJour() {
		return jour;
	}

	public void setJour(Date  jour) {
		this.jour = jour;
	}

	public CreneauTeacherJour[] getCreneauxTeacherJour() {
		return creneauxTeacherJour;
	}

	public void setCreneauxTeacherJour(CreneauTeacherJour[] creneauxTeacherJour) {
		this.creneauxTeacherJour = creneauxTeacherJour;
	}



}
