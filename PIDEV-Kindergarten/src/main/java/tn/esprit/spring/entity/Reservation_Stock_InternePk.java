package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Reservation_Stock_InternePk implements Serializable {
	
	private static final long serialVersionUID = 5377539445871317492L;
	
	
	private int idevent;
	
	private int idstock;

	public Reservation_Stock_InternePk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdevent() {
		return idevent;
	}

	public void setIdevent(int idevent) {
		this.idevent = idevent;
	}

	public int getIdstock() {
		return idstock;
	}

	public void setIdstock(int idstock) {
		this.idstock = idstock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idevent;
		result = prime * result + idstock;
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
		Reservation_Stock_InternePk other = (Reservation_Stock_InternePk) obj;
		if (idevent != other.idevent)
			return false;
		if (idstock != other.idstock)
			return false;
		return true;
	}

	
	
}
