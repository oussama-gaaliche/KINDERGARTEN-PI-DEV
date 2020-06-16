package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "T_POST")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id; 
	@Column(name="CONTAINED")
	private String contained;
	@Column(name="LKESCOUNT")
	private Integer likeCount = 0;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private ZonedDateTime date;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@JsonIgnore
	@OneToMany(mappedBy="post", fetch=FetchType.EAGER)
	private Set<Like> like;
	@JsonIgnore
	@OneToMany(mappedBy="post", fetch=FetchType.EAGER)
	private List<Image> image;
	@JsonIgnore
	@OneToMany(mappedBy="post",fetch=FetchType.EAGER)
	private Set<Comment> comment;
	@JsonIgnore
	@OneToMany(mappedBy="post",fetch=FetchType.EAGER)
	private Set<PostReport> postreport;
	public Post() {
		super();
	}
	public Post(String contained, ZonedDateTime  date, User user, List<Image> image) {
		super();
		this.contained = contained;
		this.date = date;
		this.user = user;
		this.image = image;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContained() {
		return contained;
	}
	public void setContained(String contained) {
		this.contained = contained;
	}
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime  date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Like> getLike() {
		return like;
	}
	public void setLike(Set<Like> like) {
		this.like = like;
	}
	public List<Image> getImage() {
		return image;
	}
	public void setImage(List<Image> image) {
		this.image = image;
	}
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", contained=" + contained + ", date=" + date + ", user=" + user + ", like=" + like
				+ ", image=" + image + ", comment=" + comment + "]";
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	
	
}
