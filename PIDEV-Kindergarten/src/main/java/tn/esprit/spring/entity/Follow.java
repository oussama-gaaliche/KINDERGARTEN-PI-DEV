package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Follow implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean Notification;
	private Long id_Sender;
	private String  etat;
	private Date date;
	
	@ManyToOne
	private User userReciver;

	
	public Follow() {
		super();
	}

	public Follow(boolean notification, Long id_Sender, String etat, User userReciver) {
		super();
		Notification = notification;
		this.id_Sender = id_Sender;
		this.etat = etat;
		this.userReciver = userReciver;
	}

	public Follow(int id, boolean notification, Long id_Sender, String etat, Date date, User userReciver) {
		super();
		this.id = id;
		Notification = notification;
		this.id_Sender = id_Sender;
		this.etat = etat;
		this.date = date;
		this.userReciver = userReciver;
	}

	public Follow(boolean notification, Long id_Sender, String etat, Date date, User userReciver) {
		super();
		Notification = notification;
		this.id_Sender = id_Sender;
		this.etat = etat;
		this.date = date;
		this.userReciver = userReciver;
	}

	public Follow(boolean notification) {
		super();
		Notification = notification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isNotification() {
		return Notification;
	}

	public void setNotification(boolean notification) {
		Notification = notification;
	}

	public Long getId_Sender() {
		return id_Sender;
	}

	public void setId_Sender(Long id_Sender) {
		this.id_Sender = id_Sender;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUserReciver() {
		return userReciver;
	}

	public void setUserReciver(User userReciver) {
		this.userReciver = userReciver;
	}
	
	

}
