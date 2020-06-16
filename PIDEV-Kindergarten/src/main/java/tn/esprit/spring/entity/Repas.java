package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

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
	private RepasPk repasPK;
	@ManyToOne
    @JoinColumn(name = "idplanning", referencedColumnName = "id_planning", insertable=false, updatable=false)
	private Planning planning;
	@ManyToOne
    @JoinColumn(name = "idplat", referencedColumnName = "id_Plat", insertable=false, updatable=false)
	private Plat plat;
	private int quantity;
	@ManyToOne
	User User;
	
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public RepasPk getRepasPK() {
		return repasPK;
	}
	public void setRepasPK(RepasPk repasPK) {
		this.repasPK = repasPK;
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
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		public Repas(int pid,Date date) {
		super();
		this.repasPK.setDate(date);
		this.planning.getId_planning();
	}
	@Override
	public String toString() {
		return "Repas [RepasPK=" + repasPK + ", planning=" + planning + ", plat=" + plat + ", Quantity=" + quantity
				+ "]";
	}
	public Repas(RepasPk repasPK, Planning planning, int quantity) {
		super();
		this.repasPK = repasPK;
		this.planning = planning;
		
		this.quantity = quantity;
	}
	public Repas() {
		super();
	}
	
	
	
	

}
