package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_IMAGE")
public class Image implements Serializable   {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; 
	@Column(name="IMAGE")
	private String image;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Post post;
	public Image() {
		super();
	}
	public Image(String image, Post post) {
		super();
		this.image = image;
		this.post = post;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", image=" + image + ", post=" + post + "]";
	}
	

}
