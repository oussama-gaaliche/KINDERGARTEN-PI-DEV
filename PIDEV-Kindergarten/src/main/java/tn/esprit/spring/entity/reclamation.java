package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "reclamation")
public class reclamation  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name="body", nullable=false)
	private String body;
	@Temporal(TemporalType.TIMESTAMP)
	private Date posted = Calendar.getInstance().getTime();

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sender_id")
	private User sender;
	
	@Enumerated(EnumType.STRING)

	private TypeReclamation typeReclamation ;
	

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "recipient_id")
	private User recipient;

	public reclamation(Long id, String body, TypeReclamation typeReclamation) {
		super();
		this.id = id;
		this.body = body;
		this.typeReclamation = typeReclamation;
	}




	public Long getId() {
		return id;
	}
	

	

	public reclamation(String body, TypeReclamation typeReclamation) {
		super();
		this.body = body;
		this.typeReclamation = typeReclamation;
	}




	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((posted == null) ? 0 : posted.hashCode());
		result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
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
		reclamation other = (reclamation) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (posted == null) {
			if (other.posted != null)
				return false;
		} else if (!posted.equals(other.posted))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		return true;
	}



	public reclamation(Long id, String body, User sender,
			User recipient) {
		super();
		this.id = id;
		this.body = body;
		this.sender = sender;
		this.recipient = recipient;
	}

	public reclamation(String body,
			Date posted, User sender, User recipient) {
		super();
		this.body = body;
		this.posted = posted;
		this.sender = sender;
		this.recipient = recipient;
	}


	
	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public reclamation() {
		super();
	}




	public TypeReclamation getTypeReclamation() {
		return typeReclamation;
	}




	public void setTypeReclamation(TypeReclamation typeReclamation) {
		this.typeReclamation = typeReclamation;
	}




	public reclamation(Long id,  String body, Date posted, User sender,
			TypeReclamation typeReclamation, User recipient) {
		super();
		this.id = id;
		this.body = body;
		this.posted = posted;
		this.sender = sender;
		this.typeReclamation = typeReclamation;
		this.recipient = recipient;
	}




	public reclamation( String body, Date posted, User sender,
			TypeReclamation typeReclamation, User recipient) {
		super();
		this.body = body;
		this.posted = posted;
		this.sender = sender;
		this.typeReclamation = typeReclamation;
		this.recipient = recipient;
	}




	
	
	

	

	
}