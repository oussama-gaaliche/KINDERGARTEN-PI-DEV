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
@Table(name = "rating")
public class Rating implements Serializable {
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
	private Date dateRating;
	
	private float note;
	
	private String review;

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
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

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	

	public Rating() {
		super();
	}

	public Date getDateRating() {
		return dateRating;
	}

	public void setDateRating(Date dateRating) {
		this.dateRating = dateRating;
	}

	public Rating(User user, Publicity publicity, Date dateRating, float note, String review) {
		super();
		this.user = user;
		this.publicity = publicity;
		this.dateRating = dateRating;
		this.note = note;
		this.review = review;
	}

	public Rating(int id, User user, Publicity publicity, Date dateRating, float note, String review) {
		super();
		this.id = id;
		this.user = user;
		this.publicity = publicity;
		this.dateRating = dateRating;
		this.note = note;
		this.review = review;
	}



	
	
	
	
	
	
	
	
}
