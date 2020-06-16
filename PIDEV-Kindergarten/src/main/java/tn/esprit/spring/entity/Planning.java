package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_Planning")
public class Planning implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_planning;
	@Temporal (TemporalType.DATE)
	private Date date_debut; 
	@Temporal (TemporalType.DATE)
	private Date date_fin;
	@OneToMany(mappedBy="planning")
	private  List<Repas> repas;
	public int getId_planning() {
		return id_planning;
	}
	public void setId_planning(int id_planning) {
		this.id_planning = id_planning;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	@Override
	public String toString() {
		return "Planning [id_planning=" + id_planning + ", date_debut=" + date_debut + ", date_fin=" + date_fin + "]";
	}
	public Planning(Date date_debut, Date date_fin) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Planning() {
		super();
	}
	public Planning(int id_planning, Date date_debut, Date date_fin) {
		super();
		this.id_planning = id_planning;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	

}
