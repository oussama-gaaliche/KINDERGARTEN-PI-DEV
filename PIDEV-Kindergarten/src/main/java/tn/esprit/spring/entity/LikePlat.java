package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TLikeplat")
public class LikePlat implements Serializable {
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int id;
		
		@ManyToOne
		User user;
		
		public LikePlat() {
			super();
		}

		public LikePlat(User user, Plat plat, boolean etat) {
			super();
			this.user = user;
			this.plat = plat;
			this.etat = etat;
		}

		public LikePlat(int id, User user, Plat plat, boolean etat) {
			super();
			this.id = id;
			this.user = user;
			this.plat = plat;
			this.etat = etat;
		}

		public Plat getPlat() {
			return plat;
		}

		public void setPlat(Plat plat) {
			this.plat = plat;
		}

		@ManyToOne
				
		 Plat plat;
		
		private boolean etat;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		
		public boolean isEtat() {
			return etat;
		}

		public void setEtat(boolean etat) {
			this.etat = etat;
		}

		

	}



