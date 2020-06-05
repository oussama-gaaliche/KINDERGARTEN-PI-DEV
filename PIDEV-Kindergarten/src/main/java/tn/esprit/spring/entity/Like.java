package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_LiKE")
public class Like implements Serializable {
private static final long serialVersionUID = 3876346912862238239L;
	
	
	@EmbeddedId
	private LikePK likePK;
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable=false, updatable=false)
	private User user;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idPost", referencedColumnName = "id", insertable=false, updatable=false)
	private Post post;
	
	@Enumerated(EnumType.STRING)
	Etat etat;
	@Column(name="DATE")
	@Temporal (TemporalType.DATE)
	private Date date;
	public Like() {
		super();
	}
	public Like(User user, Post post, Etat etat, Date date) {
		super();
		this.user = user;
		this.post = post;
		this.etat = etat;
		this.date = date;
	}
	public LikePK getLikePK() {
		return likePK;
	}
	public void setLikePK(LikePK likePK) {
		this.likePK = likePK;
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
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Like [likePK=" + likePK + ", user=" + user + ", post=" + post + ", etat=" + etat + ", date=" + date
				+ "]";
	}

}
