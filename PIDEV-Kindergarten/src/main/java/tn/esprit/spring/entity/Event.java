package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="EVENT")
public class Event implements Serializable {
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Event_id")
	private int id;
	
	@Column(name="Event_title")
	private String title;
	
	@Column(name="Event_location")
	private String location;
	
	
	@Column(name="Event_description")
	private String description;
	
	@Column(name="Event_Nbr_Participants")
	private int Nbr_participants;

	@Column(name="Event_Nbr_Interessants")
	private int Nbr_interessants;
	@Column(name="Event_Nbr_Place")
	private int Nbr_place;


	@Enumerated(EnumType.STRING)
	@Column(name="Event_category")
	private Category category;
	
	/*@Enumerated(EnumType.STRING)
	@Column(name="Event_type")
	private Type type;*/
	
	@Column(name="Event_photo")
	private String photo;
	@Column(name="Event_budget")
	private String event_budget;
	@Column(name="event_start_heure")
	private java.sql.Time start_heure;
	@Column(name="event_end_heure")
	private java.sql.Time end_heure;
	

	
	@Column(name="Event_start_date")
	@Temporal(TemporalType.DATE)
	private Date start_date;
	
	@Column(name="Event_end_date")
	@Temporal(TemporalType.DATE)
	private Date end_date;
	
	@Column(name="Event_date_final_resrvation")
	@Temporal(TemporalType.DATE)
	private Date date_final_reservation;

	@Enumerated(EnumType.STRING)
	private StateEvent stateevent;

       @JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="event")
	private List<Participation> participations;
       @JsonIgnore
	@ManyToOne
	private User user;
	public Event(int id, String title, String location, String description, int nbr_participants, int nbr_interessants,
			int nbr_place, Category category, String photo, String event_budget, Time start_heure, Time end_heure,
			Date start_date, Date end_date, Date date_final_reservation, StateEvent stateevent,
			List<Participation> participations, User user) {
		super();
		this.id = id;
		this.title = title;
		this.location = location;
		this.description = description;
		Nbr_participants = nbr_participants;
		Nbr_interessants = nbr_interessants;
		Nbr_place = nbr_place;
		this.category = category;
		this.photo = photo;
		this.event_budget = event_budget;
		this.start_heure = start_heure;
		this.end_heure = end_heure;
		this.start_date = start_date;
		this.end_date = end_date;
		this.date_final_reservation = date_final_reservation;
		this.stateevent = stateevent;
		this.participations = participations;
		this.user = user;
	}
	public Event(String title, String location, String description, int nbr_participants, int nbr_interessants,
			int nbr_place, Category category, String photo, String event_budget, Time start_heure, Time end_heure,
			Date start_date, Date end_date, Date date_final_reservation, StateEvent stateevent,
			List<Participation> participations, User user) {
		super();
		this.title = title;
		this.location = location;
		this.description = description;
		Nbr_participants = nbr_participants;
		Nbr_interessants = nbr_interessants;
		Nbr_place = nbr_place;
		this.category = category;
		this.photo = photo;
		this.event_budget = event_budget;
		this.start_heure = start_heure;
		this.end_heure = end_heure;
		this.start_date = start_date;
		this.end_date = end_date;
		this.date_final_reservation = date_final_reservation;
		this.stateevent = stateevent;
		this.participations = participations;
		this.user = user;
	}
       
       
	

}
