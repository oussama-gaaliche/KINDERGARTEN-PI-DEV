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
@Table(name="T_PostVu")
public class PostVu implements Serializable {
	
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
	Post post;
	
	@Temporal (TemporalType.DATE)
	private Date dateVu;

	public PostVu(int id, User user, Post post, Date dateVu) {
		super();
		this.id = id;
		this.user = user;
		this.post = post;
		this.dateVu = dateVu;
	}

	public PostVu() {
		super();
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Date getDateVu() {
		return dateVu;
	}

	public void setDateVu(Date dateVu) {
		this.dateVu = dateVu;
	}

	

	

	
}
