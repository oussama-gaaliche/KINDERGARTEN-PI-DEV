package tn.esprit.spring.entity;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Participation")
public class Participation implements Serializable {
private static final long serialVersionUID = 1L;
	

	@EmbeddedId
	private ParticipationPK participationpk ;
	
	@Column(name="Type_Participation")
		private  String etat ;
	
	@Temporal (TemporalType.DATE)
    @Column(name="Date_participation")
	private Date date_participation;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idEventt", referencedColumnName = "Event_id", insertable=false, updatable=false)
	private Event event_participation ; 
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "iduserr", referencedColumnName = "id", insertable=false, updatable=false)
    private User user_participation ;

	public ParticipationPK getParticipationpk() {
		return participationpk;
	}

	public void setParticipationpk(ParticipationPK participationpk) {
		this.participationpk = participationpk;
	}


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getDate_participation() {
		return date_participation;
	}

	public void setDate_participation(Date date_participation) {
		this.date_participation = date_participation;
	}

	public Event getEvent_participation() {
		return event_participation;
	}

	public void setEvent_participation(Event event_participation) {
		this.event_participation = event_participation;
	}

	public User getUser_participation() {
		return user_participation;
	}

	public void setUser_participation(User user_participation) {
		this.user_participation = user_participation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Participation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_participation == null) ? 0 : date_participation.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((event_participation == null) ? 0 : event_participation.hashCode());
		result = prime * result + ((participationpk == null) ? 0 : participationpk.hashCode());
		result = prime * result + ((user_participation == null) ? 0 : user_participation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participation other = (Participation) obj;
		if (date_participation == null) {
			if (other.date_participation != null)
				return false;
		} else if (!date_participation.equals(other.date_participation))
			return false;
		if (etat != other.etat)
			return false;
		if (event_participation == null) {
			if (other.event_participation != null)
				return false;
		} else if (!event_participation.equals(other.event_participation))
			return false;
		if (participationpk == null) {
			if (other.participationpk != null)
				return false;
		} else if (!participationpk.equals(other.participationpk))
			return false;
		if (user_participation == null) {
			if (other.user_participation != null)
				return false;
		} else if (!user_participation.equals(other.user_participation))
			return false;
		return true;
	}

	
}
