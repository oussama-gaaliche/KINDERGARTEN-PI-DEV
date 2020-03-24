package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Repas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private RepasPk RepasPK;
	@ManyToOne
    @JoinColumn(name = "idplanning", referencedColumnName = "id_planning", insertable=false, updatable=false)
	private Planning planning;
	@ManyToOne
    @JoinColumn(name = "idplat", referencedColumnName = "id_Plat", insertable=false, updatable=false)
	private Plat plat;
	private int Quantity;
	public RepasPk getRepasPK() {
		return RepasPK;
	}
	public void setRepasPK(RepasPk repasPK) {
		RepasPK = repasPK;
	}
	public Planning getPlanning() {
		return planning;
	}
	public void setPlanning(Planning planning) {
		this.planning = planning;
	}
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Repas() {
		super();
	}
	
	
	

}
