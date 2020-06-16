package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Message {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id ;
	private Date date;
	private String messageContenu;
	private boolean notification ;
	private String sender;
	
	@JsonIgnore
	@ManyToOne()
	private User userReciver;

	public Message(Long id, Date date, String messageContenu, boolean notification, String sender, User userReciver) {
		super();
		this.id = id;
		this.date = date;
		this.messageContenu = messageContenu;
		this.notification = notification;
		this.sender = sender;
		this.userReciver = userReciver;
	}

	public Message(Date date, String messageContenu, boolean notification, String sender, User userReciver) {
		super();
		this.date = date;
		this.messageContenu = messageContenu;
		this.notification = notification;
		this.sender = sender;
		this.userReciver = userReciver;
	}

	public Message(Date date, String messageContenu, String sender, User userReciver) {
		super();
		this.date = date;
		this.messageContenu = messageContenu;
		this.sender = sender;
		this.userReciver = userReciver;
	}

	public Message() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessageContenu() {
		return messageContenu;
	}

	public void setMessageContenu(String messageContenu) {
		this.messageContenu = messageContenu;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public User getUserReciver() {
		return userReciver;
	}

	public void setUserReciver(User userReciver) {
		this.userReciver = userReciver;
	}
	
	

}
