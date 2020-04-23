package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PublicityLike")
public class LikePub implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	Publicity publicity;
	
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

	public Publicity getPublicity() {
		return publicity;
	}

	public void setPublicity(Publicity publicity) {
		this.publicity = publicity;
	}

	
	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public LikePub(User user, Publicity publicity, boolean etat) {
		super();
		this.user = user;
		this.publicity = publicity;
		this.etat = etat;
	}

	public LikePub(int id, User user, Publicity publicity, boolean etat) {
		super();
		this.id = id;
		this.user = user;
		this.publicity = publicity;
		this.etat = etat;
	}

	public LikePub() {
		super();
	}
	
	
	

}
