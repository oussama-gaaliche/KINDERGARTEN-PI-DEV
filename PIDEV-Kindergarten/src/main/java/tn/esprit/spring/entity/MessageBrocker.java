package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MessageBrocker {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String userSender;
	private String userReciver;
	private Date sendDate;
	private String messageContent;
	private boolean status ;
	
	
	public MessageBrocker() {
		super();
	}


	public MessageBrocker(Long id, String userSender, String userReciver, Date sendDate, String messageContent,
			boolean status) {
		super();
		this.id = id;
		this.userSender = userSender;
		this.userReciver = userReciver;
		this.sendDate = sendDate;
		this.messageContent = messageContent;
		this.status = status;
	}


	public MessageBrocker(String userSender, String userReciver, Date sendDate, String messageContent, boolean status) {
		super();
		this.userSender = userSender;
		this.userReciver = userReciver;
		this.sendDate = sendDate;
		this.messageContent = messageContent;
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserSender() {
		return userSender;
	}


	public void setUserSender(String userSender) {
		this.userSender = userSender;
	}


	public String getUserReciver() {
		return userReciver;
	}


	public void setUserReciver(String userReciver) {
		this.userReciver = userReciver;
	}


	public Date getSendDate() {
		return sendDate;
	}


	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}


	public String getMessageContent() {
		return messageContent;
	}


	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
