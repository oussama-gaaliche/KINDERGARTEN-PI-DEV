package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class EvaluationPK  implements Serializable{
	

	private static final long serialVersionUID = 5377539445871317492L;
	
    private long iduser;
	
	private int idEvent;

	public EvaluationPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EvaluationPK(long iduser, int idEvent) {
		super();
		this.iduser = iduser;
		this.idEvent = idEvent;
	}

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvent;
		result = prime * result + (int) (iduser ^ (iduser >>> 32));
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
		EvaluationPK other = (EvaluationPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (iduser != other.iduser)
			return false;
		return true;
	}

	




}
