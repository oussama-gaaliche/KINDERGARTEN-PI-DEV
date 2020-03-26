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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;





@Entity
@Table(name = "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//@NotNull(message="First name is compulsory")
	@Column(name = "username")
	@NotEmpty(message = "Please provide your first name")
	private String username;

	//@NotNull(message="First name is compulsory")
	@Column(name = "nom")
	@NotEmpty(message = "Please provide your first name")
	private String nom;
	//@NotNull(message="Last name is compulsory")
	@Column(name = "prenom")
	@NotEmpty(message = "Please provide your last name")
	private String prenom;
	//@NotNull(message="Password is compulsory")
	@Column(name = "password")
	@Size(min=5, max=16, message="Password should be at least 5 characters")

	private String password;
	//@NotNull(message="Email is compulsory")
	@Column(name = "email", nullable=false, unique= true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message="Please provide an e-mail")
	private String email;
	@Pattern(regexp="(^$|[0-9]{8}",message="Mobile number must be 8 digits")
	private Long numtel;
	@Column(name = "status")
	private String status;
	
	


	@Transient
	private String passwordConfirm;
	@Enumerated(EnumType.STRING)
	Role role;
	public User(Long id, @NotEmpty(message = "Please provide your first name") String username,
			@NotEmpty(message = "Please provide your first name") String nom,
			@NotEmpty(message = "Please provide your last name") String prenom,
			@Size(min = 5, max = 16, message = "Password should be at least 5 characters") String password,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			@Pattern(regexp = "(^$|[0-9]{8}", message = "Mobile number must be 8 digits") Long numtel, String status,
			String passwordConfirm, Role role) {
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
		this.role = role;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public User(@NotEmpty(message = "Please provide your first name") String username,
			@NotEmpty(message = "Please provide your first name") String nom,
			@NotEmpty(message = "Please provide your last name") String prenom,
			@Size(min = 5, max = 16, message = "Password should be at least 5 characters") String password,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			@Pattern(regexp = "(^$|[0-9]{8}", message = "Mobile number must be 8 digits") Long numtel, String status,
			String passwordConfirm, Role role) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.numtel = numtel;
		this.status = status;
		this.passwordConfirm = passwordConfirm;
		this.role = role;
	}
	public User() {
		super();
	}



	
	
	
	
	
	
	
}
