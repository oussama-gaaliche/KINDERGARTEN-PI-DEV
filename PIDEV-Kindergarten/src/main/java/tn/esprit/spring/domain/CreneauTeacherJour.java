package tn.esprit.spring.domain;

import java.io.Serializable;

import tn.esprit.spring.entity.Creneau;
import tn.esprit.spring.entity.Rv;



/**
 * L'entité [CreneauTeacherJour] est une entité métier 
 * il associe un créneau horaire et le rendez-vous éventuel pris dans ce créneau :
 * 
 */
public class CreneauTeacherJour implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// champs
	private Creneau creneau;
	private Rv rv;

	// constructeurs
	public CreneauTeacherJour() {

	}





	// getters et setters

	@Override
	public String toString() {
		return String.format("[%s %s]", creneau, rv);
	}
	

	public CreneauTeacherJour(Creneau creneau, Rv rv) {
		this.creneau = creneau;
		this.rv = rv;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public Rv getRv() {
		return rv;
	}

	public void setRv(Rv rv) {
		this.rv = rv;
	}

}
