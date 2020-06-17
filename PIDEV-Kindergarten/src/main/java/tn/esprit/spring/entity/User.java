

package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username",unique= true)
	@NotEmpty(message = "Please provide your first name")
	private String username;
	@Column(name = "nom")
	@NotEmpty(message = "Please provide your first name")
	private String nom;
	@Column(name = "prenom")
	@NotEmpty(message = "Please provide your last name")
	private String prenom;
	@Column(name = "password")
	private String password;
	@Column(name = "email", nullable=false, unique= true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message="Please provide an e-mail")
	private String email;
	private Long numtel;
	@Column(name = "status")
	private String status;
	private int nbrsig;
	@Temporal (TemporalType.DATE)
	private Date dateInscription;
	@JsonIgnore
	@Column(name = "score")
	private float score;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Userseventmaker")
	private List<Event> eventm;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user_participation")
	private  List<Participation> participations;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user_evaluation")
	private  List<Evaluation> evaluations;
//	@OneToMany(mappedBy="userReciver",cascade = CascadeType.ALL)
//	private List<Follow> follows;
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@OneToMany(mappedBy="userReciver",cascade = CascadeType.ALL)
	private List<Message> messages;
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Enfant> enfant;
	@OneToMany(mappedBy="User",cascade = CascadeType.ALL)
	private List<Publicity> publicity;
	@Transient
	private String passwordConfirm;
	private String roles;
	private boolean active;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Facture> factures;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Post> post;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private Set<Reaction> like;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private Set<Comment> comment;
	@OneToMany(mappedBy="user")
	private Set<PostReport> postreport;
	public User() {
		super();
	}
	public User(Long id, String username, String nom,String prenom,String password,String email,Long numtel, String status,String passwordConfirm, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.numtel = numtel;
		this.status = status;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
	}
	public User(String username,String nom,String prenom,String password,String email,Long numtel, String status,
			String roles) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.numtel = numtel;
		this.status = status;
		this.roles = roles;
	}
	public User(@NotEmpty(message = "Please provide your first name") String username,
			@NotEmpty(message = "Please provide your first name") String nom,
			@NotEmpty(message = "Please provide your last name") String prenom, String password,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			Long numtel, String status, int nbrsig, List<Message> messages, String passwordConfirm, String roles,
			boolean active) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.numtel = numtel;
		this.status = status;
		this.nbrsig = nbrsig;
		this.messages = messages;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
		this.active = active;
	}
	public User(String username,String password,String email,String roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	public User(String username,String nom,String prenom,String password, String email,Long numtel, String status,String passwordConfirm, String roles) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.numtel = numtel;
		this.status = status;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getNumtel() {
		return numtel;
	}
	public void setNumtel(Long numtel) {
		this.numtel = numtel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public int getNbrsig() {
		return nbrsig;
	}
	public void setNbrsig(int nbrsig) {
		this.nbrsig = nbrsig;
	}
	@Lob
	@Column(length = 2125635)
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User(Long id, @NotEmpty(message = "Please provide your first name") String username,
			@NotEmpty(message = "Please provide your first name") String nom,
			@NotEmpty(message = "Please provide your last name") String prenom, String password,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			Long numtel, String status, int nbrsig, Date dateInscription, float score, List<Event> eventm,
			List<Participation> participations, List<Evaluation> evaluations, List<Message> messages,
			List<Enfant> enfant, List<Publicity> publicity, String passwordConfirm, String roles, boolean active,
			Set<Facture> factures, String image) {
		super();
		this.id = id;
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.numtel = numtel;
		this.status = status;
		this.nbrsig = nbrsig;
		this.dateInscription = dateInscription;
		this.score = score;
		this.eventm = eventm;
		this.participations = participations;
		this.evaluations = evaluations;
		this.messages = messages;
		this.enfant = enfant;
		this.publicity = publicity;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
		this.active = active;
		this.factures = factures;
		this.image = image;
	}
	public List<Participation> getParticipations() {
		return participations;
	}
	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
	
	

}