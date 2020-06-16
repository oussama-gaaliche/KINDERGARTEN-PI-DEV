package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "rv")

public class Rv extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	/*
	 * Fields
	 * =========================================================================
	 */


	@Column(name = "jour", nullable = false)
	  @NotNull

	  @Temporal(TemporalType.DATE)
	private Date jour;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_enfant")
	private Enfant enfant;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_creneau")
	private Creneau creneau;

	/*
	 * foreign keys 
	 * =========================================================================
	 * used to add Rv directly : Rv is not owner of releationship
	 */
	@Column(name = "id_enfant", nullable = false, insertable = false, updatable = false)
	private long idEnfant;
	
	@Column(name = "id_creneau", nullable = false, insertable = false, updatable = false)
	private long idCreneau;
	
	public long getIdEnfant() {
		return idEnfant;
	}







	public void setIdEnfant(long idEnfant) {
		this.idEnfant = idEnfant;
	}







	public void setIdCreneau(long idCreneau) {
		this.idCreneau = idCreneau;
	}







	public long getIdCreneau() {
		return idCreneau;
	}
	
	
	
	
	


	/*
	 * constructors
	 * =========================================================================
	 */

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}


	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rv() {
	}



	public Rv(Long id, @NotNull Date jour, Enfant enfant, Creneau creneau) {
		super();
		this.id = id;
		this.jour = jour;
		this.enfant = enfant;
		this.creneau = creneau;
	}

	
	public Rv(@NotNull Date jour, Enfant enfant, Creneau creneau) {
		super();
		this.jour = jour;
		this.enfant = enfant;
		this.creneau = creneau;
	}
	public Rv(@NotNull Date jour, Creneau creneau, Enfant enfant) {
		super();
		this.jour = jour;
		this.enfant = enfant;
		this.creneau = creneau;
	}

	public Long getId() {
		return id;
	}



	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}


	public Rv(@NotNull Date jour, long idEnfant, long idCreneau) {
		super();
		this.jour = jour;
		this.idEnfant = idEnfant;
		this.idCreneau = idCreneau;
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creneau == null) ? 0 : creneau.hashCode());
		result = prime * result + ((enfant == null) ? 0 : enfant.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
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
		Rv other = (Rv) obj;
		if (creneau == null) {
			if (other.creneau != null)
				return false;
		} else if (!creneau.equals(other.creneau))
			return false;
		if (enfant == null) {
			if (other.enfant != null)
				return false;
		} else if (!enfant.equals(other.enfant))
			return false;
		if (id != other.id)
			return false;
		if (jour == null) {
			if (other.jour != null)
				return false;
		} else if (!jour.equals(other.jour))
			return false;
		return true;
	}



	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Rv [id=" + id + ", jour=" + jour + ", enfant=" + enfant + ", creneau=" + creneau + "]";
	}
	}

