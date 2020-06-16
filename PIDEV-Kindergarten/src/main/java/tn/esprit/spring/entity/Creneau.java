package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "creneaux")

public class Creneau  { 
	
	private static final long serialVersionUID = 1L;

	/*
	 * Fields
	 * =========================================================================
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	private int hdebut;
	private int mdebut;
	private int hfin;
	private int mfin;

	/** a timeslot is linked to one teacher */
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_teacher")
	private Teacher teacher;
   
	/*
	 * foreign keys
	 * =========================================================================
	 * used to add object directly : Creneau is not owner of releationship
	 */
	
	@Column(name = "id_teacher", nullable = false, insertable = false, updatable = false)
	private Long idTeacher;
	
	public Long getIdTeacher() {
		return idTeacher;
	}

	
	public Creneau() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHdebut() {
		return hdebut;
	}

	public void setHdebut(int hdebut) {
		this.hdebut = hdebut;
	}

	public int getMdebut() {
		return mdebut;
	}

	public void setMdebut(int mdebut) {
		this.mdebut = mdebut;
	}

	public int getHfin() {
		return hfin;
	}

	public void setHfin(int hfin) {
		this.hfin = hfin;
	}

	public int getMfin() {
		return mfin;
	}

	public void setMfin(int mfin) {
		this.mfin = mfin;
	}

	
	


	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public void setIdTeacher(Long idTeacher) {
		this.idTeacher = idTeacher;
	}










	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hdebut;
		result = prime * result + hfin;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idTeacher == null) ? 0 : idTeacher.hashCode());
		result = prime * result + mdebut;
		result = prime * result + mfin;

		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
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
		Creneau other = (Creneau) obj;
		if (hdebut != other.hdebut)
			return false;
		if (hfin != other.hfin)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idTeacher == null) {
			if (other.idTeacher != null)
				return false;
		} else if (!idTeacher.equals(other.idTeacher))
			return false;
		if (mdebut != other.mdebut)
			return false;
		if (mfin != other.mfin)
			return false;
		
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Creneau [id=" + id + ", hdebut=" + hdebut + ", mdebut=" + mdebut + ", hfin=" + hfin + ", mfin=" + mfin
				+ ", teacher=" + teacher + ", idTeacher=" + idTeacher + "]";
	}

	public Creneau( int hdebut, int mdebut, int hfin, int mfin, Teacher teacher) {
		super();
		
		this.hdebut = hdebut;
		this.mdebut = mdebut;
		this.hfin = hfin;
		this.mfin = mfin;
		this.teacher = teacher;
	
	}
	public Creneau(Long id, int hdebut, int mdebut, int hfin, int mfin, Teacher teacher) {
		super();
		this.id = id;
		this.hdebut = hdebut;
		this.mdebut = mdebut;
		this.hfin = hfin;
		this.mfin = mfin;
		this.teacher = teacher;
	}

	}