package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Oppor implements Serializable {
	private Long count;
	private Long username;
	public Oppor(Long count, Long username) {
		super();
		this.count = count;
		this.username = username;
	}
	public Oppor() {
		super();
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getUsername() {
		return username;
	}
	public void setUsername(Long username) {
		this.username = username;
	}
	
	
}
