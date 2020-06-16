package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "T_LiKE")
public class Reaction implements Serializable {
	
	private static final long serialVersionUID = 3876346912862238239L;
	
	
	@EmbeddedId
	private LikePK likePK;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
	private User user;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPost", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
	private Post post;
	
	@Enumerated(EnumType.STRING)
	React React;
	@Column(name="DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private ZonedDateTime date;
	public Reaction() {
		super();
	}
	public Reaction(LikePK likePK, User user, Post post, React react, ZonedDateTime date) {
		super();
		this.likePK = likePK;
		this.user = user;
		this.post = post;
		React = react;
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
	public React getReact() {
		return React;
	}
	public void setReact(React react) {
		React = react;
	}
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}





}