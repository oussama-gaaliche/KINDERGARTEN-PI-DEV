package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_COMMENT")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CommentPK commentPK;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable=false, updatable=false)
	private User user;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idPost", referencedColumnName = "id", insertable=false, updatable=false)
	private Post post;
	
	@Column(name="CONTAINED")
	private String contained;
	@Column(name="DATE")
	@Temporal (TemporalType.DATE)
	private Date date;
	public Comment() {
		super();
	}
	public Comment(User user, Post post, String contained, Date date) {
		super();
		this.user = user;
		this.post = post;
		this.contained = contained;
		this.date = date;
	}
	public CommentPK getCommentPK() {
		return commentPK;
	}
	public void setCommentPK(CommentPK commentPK) {
		this.commentPK = commentPK;
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
	public String getContained() {
		return contained;
	}
	public void setContained(String contained) {
		this.contained = contained;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Comment [commentPK=" + commentPK + ", user=" + user + ", post=" + post + ", contained=" + contained
				+ ", date=" + date + "]";
	}
	
}