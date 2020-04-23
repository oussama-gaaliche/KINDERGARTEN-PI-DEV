package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="T_PublicityView")
public class PubVu implements Serializable {
	
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
	
	@Temporal (TemporalType.DATE)
	private Date dateVu;

	public PubVu(int id, User user, Publicity publicity, Date dateVu) {
		super();
		this.id = id;
		this.user = user;
		this.publicity = publicity;
		this.dateVu = dateVu;
	}

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

	public Date getDateVu() {
		return dateVu;
	}

	public void setDateVu(Date dateVu) {
		this.dateVu = dateVu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PubVu(User user, Publicity publicity, Date dateVu) {
		super();
		this.user = user;
		this.publicity = publicity;
		this.dateVu = dateVu;
	}

	public PubVu() {
		super();
	}

	

	
}
