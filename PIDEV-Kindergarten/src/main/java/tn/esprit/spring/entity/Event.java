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

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="EVENT")
public class Event implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Event_id")
    private int id;
	
	@Column(name="Event_title")
	private String title;

	@Column(name="Event_location")
	private String location;
	

	@Column(name="Event_Photo")
    private String photo;

	@Enumerated(EnumType.STRING)
	private Category category;
	
	
	
	@Column(name="Event_Description")
	private String description;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Event_start_Date")
	private Date start_date;
	
	
	@Column(name="Event_start_heure")
	private java.sql.Time event_start_heure ;

	@Temporal (TemporalType.DATE)
	@Column(name="Event_End_Date")
	private Date end_date;
	
	@Column(name="Event_fin_heure")
	private java.sql.Time event_fin_heure ;

	
	@Temporal (TemporalType.DATE)
    @Column(name="Event_Final_reservation")
	private Date date_final_reservation;
	
	
	@Column(name="Event_Nbr_Place")
	private int Nbr_places;
	
	@Column(name="Event_Nbr_Participants")
	private int Nbr_participants;
	
	@Column(name="Event_Nbr_interessants")
	private int Nbr_interssants;
	
	@Column(name="Event_budget")
	private int event_budget;
	
	@Enumerated(EnumType.STRING)
	private Etat_event etat_event;
	@OneToOne
	private Salle salle;
	@OneToOne
	private FactureEvent facture;
	@JsonIgnore
    @ManyToOne
	User Userseventmaker;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="event_participation")
	private  List<Participation> participations;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="event_evaluation")
	private  List<Evaluation> evaluations; 
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="event")
	private  List<Reservation_Stock_Interne> reservation_stock_interne;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int id, String title, String location, String photo, Category category, String description,
			Date start_date, Time event_start_heure, Date end_date, Time event_fin_heure, Date date_final_reservation,
			int nbr_places, int nbr_participants, int nbr_interssants, int event_budget, Etat_event etat_event) {
		super();
		this.id = id;
		this.title = title;
		this.location = location;
		this.photo = photo;
		this.category = category;
		this.description = description;
		this.start_date = start_date;
		this.event_start_heure = event_start_heure;
		this.end_date = end_date;
		this.event_fin_heure = event_fin_heure;
		this.date_final_reservation = date_final_reservation;
		Nbr_places = nbr_places;
		Nbr_participants = nbr_participants;
		Nbr_interssants = nbr_interssants;
		this.event_budget = event_budget;
		this.etat_event = etat_event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public java.sql.Time getEvent_start_heure() {
		return event_start_heure;
	}

	public void setEvent_start_heure(java.sql.Time event_start_heure) {
		this.event_start_heure = event_start_heure;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public java.sql.Time getEvent_fin_heure() {
		return event_fin_heure;
	}

	public void setEvent_fin_heure(java.sql.Time event_fin_heure) {
		this.event_fin_heure = event_fin_heure;
	}

	public Date getDate_final_reservation() {
		return date_final_reservation;
	}

	public void setDate_final_reservation(Date date_final_reservation) {
		this.date_final_reservation = date_final_reservation;
	}

	public int getNbr_places() {
		return Nbr_places;
	}

	public void setNbr_places(int nbr_places) {
		Nbr_places = nbr_places;
	}

	public int getNbr_participants() {
		return Nbr_participants;
	}

	public void setNbr_participants(int nbr_participants) {
		Nbr_participants = nbr_participants;
	}

	public int getNbr_interssants() {
		return Nbr_interssants;
	}

	public void setNbr_interssants(int nbr_interssants) {
		Nbr_interssants = nbr_interssants;
	}

	public int getEvent_budget() {
		return event_budget;
	}

	public void setEvent_budget(int event_budget) {
		this.event_budget = event_budget;
	}

	public Etat_event getEtat_event() {
		return etat_event;
	}

	public void setEtat_event(Etat_event etat_event) {
		this.etat_event = etat_event;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public FactureEvent getFacture() {
		return facture;
	}

	public void setFacture(FactureEvent facture) {
		this.facture = facture;
	}

	public User getUserseventmaker() {
		return Userseventmaker;
	}

	public void setUserseventmaker(User userseventmaker) {
		Userseventmaker = userseventmaker;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public List<Reservation_Stock_Interne> getReservation_stock_interne() {
		return reservation_stock_interne;
	}

	public void setReservation_stock_interne(List<Reservation_Stock_Interne> reservation_stock_interne) {
		this.reservation_stock_interne = reservation_stock_interne;
	}
	

	

}
