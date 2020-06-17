package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_notification;
	private Date date_notif;
	private String message;
	   @Enumerated(EnumType.STRING)

	private EtatNotif etat;
	public Long getId_notification() {
		return id_notification;
	}
	public void setId_notification(Long id_notification) {
		this.id_notification = id_notification;
	}
	public Date getDate_notif() {
		return date_notif;
	}
	public void setDate_notif(Date date_notif) {
		this.date_notif = date_notif;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EtatNotif getEtat() {
		return etat;
	}
	public void setEtat(EtatNotif etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Notification [id_notification=" + id_notification + ", date_notif=" + date_notif + ", message="
				+ message + ", etat=" + etat + "]";
	}
	public Notification() {
		super();
	}
	
	
	

}
