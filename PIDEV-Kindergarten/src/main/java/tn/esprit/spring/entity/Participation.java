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

@Entity
@Table(name="Participation")
public class Participation implements Serializable  {
	private static final long serialVersionUID = 5377539445871317492L;

	
	
	@Column(name="date_Participation")
	@Temporal(TemporalType.DATE)
	
	private Date date_participation;
	
	@EmbeddedId
	private ParticipationPk participationPK;
	@ManyToOne
	@JoinColumn(name = "eventId", referencedColumnName = "Event_id", insertable=false, updatable=false)
	private Event  event;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "Id", insertable=false, updatable=false)
	private User user;
	
	@Enumerated(EnumType.STRING)
	@Column(name="etat_participant")
	private EtatParticipant etatParticipant;



	public Date getDate_participation() {
		return date_participation;
	}

	public void setDate_participation(Date date_participation) {
		this.date_participation = date_participation;
	}

	public ParticipationPk getParticipationPK() {
		return participationPK;
	}

	public void setParticipationPK(ParticipationPk participationPK) {
		this.participationPK = participationPK;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EtatParticipant getEtatParticipantt() {
		return etatParticipant;
	}

	public void setEtatParticipantt(EtatParticipant etatParticipant) {
		this.etatParticipant = etatParticipant;
	}

	public Participation(Date date_participation, ParticipationPk participationPK, Event event, User user,
			EtatParticipant etatParticipant) {
		super();
		this.date_participation = date_participation;
		this.participationPK = participationPK;
		this.event = event;
		this.user = user;
		this.etatParticipant = etatParticipant;
	}

	



	

	
	
}
