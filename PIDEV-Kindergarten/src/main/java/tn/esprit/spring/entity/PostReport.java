package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

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

@Entity
@Table(name = "T_ReportPOST")
public class PostReport implements Serializable {

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="ID")
		private long id;
		@Column(name="message")
		private String message;
		@ManyToOne(cascade = CascadeType.ALL)
		private Post post;
		@ManyToOne(cascade = CascadeType.ALL)
		private User user;
		public PostReport(String message, Post post, User user) {
			super();
			this.message = message;
			this.post = post;
			this.user = user;
		}
		public PostReport() {
			super();
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Post getPost() {
			return post;
		}
		public void setPost(Post post) {
			this.post = post;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		
		

}
