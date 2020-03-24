package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class RepasPk implements Serializable {


	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int idplanning;
		private int idplat;
		@Temporal(TemporalType.DATE)
		private Date date;
		public int getIdplanning() {
			return idplanning;
		}
		public void setIdplanning(int idplanning) {
			this.idplanning = idplanning;
		}
		public int getIdplat() {
			return idplat;
		}
		public void setIdplat(int idplat) {
			this.idplat = idplat;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public RepasPk(int idplanning, int idplat, Date date) {
			super();
			this.idplanning = idplanning;
			this.idplat = idplat;
			this.date = date;
		}
		public RepasPk() {
			super();
		}
		@Override
		public String toString() {
			return "RepasPk [idplanning=" + idplanning + ", idplat=" + idplat + ", date=" + date + "]";
		}
		
		
		

		
		
		


}
