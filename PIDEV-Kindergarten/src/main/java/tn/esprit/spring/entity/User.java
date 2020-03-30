package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;




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
	
	


	@Transient
	private String passwordConfirm;

	private String roles;
	private boolean active;
	
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

	
	
}
