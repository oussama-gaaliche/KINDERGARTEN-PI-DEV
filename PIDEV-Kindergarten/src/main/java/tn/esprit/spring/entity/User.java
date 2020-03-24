package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Role roles;
	
	
	
}
