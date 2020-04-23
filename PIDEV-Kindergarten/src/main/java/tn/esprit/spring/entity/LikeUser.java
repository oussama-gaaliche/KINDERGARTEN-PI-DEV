package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LikeUser implements Serializable {
	
	private Long nbLike;
	
	private String user;

	public Long getNbLike() {
		return nbLike;
	}

	public void setNbLike(Long nbLike) {
		this.nbLike = nbLike;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LikeUser(Long nbLike, String user) {
		super();
		this.nbLike = nbLike;
		this.user = user;
	}
	
	

}
