package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "rating")
public class ratingResto implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ratingRestoPk ratingrestopk;
	@ManyToOne
	@JoinColumn(name = "idplan", referencedColumnName = "id_planning", insertable=false, updatable=false)
	private Planning planning_rating ; 
	@ManyToOne
	@JoinColumn(name = "iduser", referencedColumnName = "id", insertable=false, updatable=false)
    private User userrating ;

	public ratingResto() {
		super();
	}

	public ratingResto(ratingRestoPk ratingrestopk, Planning planning_rating, tn.esprit.spring.entity.User user_rating,
			Date dateRating, float note) {
		super();
		this.ratingrestopk = ratingrestopk;
		this.planning_rating = planning_rating;
		this.userrating = user_rating;
		this.dateRating = dateRating;
		this.note = note;
	}

	public ratingRestoPk getRatingrestopk() {
		return ratingrestopk;
	}

	public void setRatingrestopk(ratingRestoPk ratingrestopk) {
		this.ratingrestopk = ratingrestopk;
	}

	public Planning getPlanning_rating() {
		return planning_rating;
	}

	public void setPlanning_rating(Planning planning_rating) {
		this.planning_rating = planning_rating;
	}

	

	public User getUserrating() {
		return userrating;
	}

	public void setUserrating(User userrating) {
		this.userrating = userrating;
	}

	public Date getDateRating() {
		return dateRating;
	}

	public void setDateRating(Date dateRating) {
		this.dateRating = dateRating;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	@Temporal(TemporalType.DATE)
	private Date dateRating;
	
	private float note;
	
	


	
	
	
	
}



