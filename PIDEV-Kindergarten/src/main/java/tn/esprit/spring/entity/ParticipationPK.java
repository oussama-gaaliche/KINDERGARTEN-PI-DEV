package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ParticipationPK  implements Serializable{
	
	private static final long serialVersionUID = 5377539445871317492L;
	
    private long iduserr;
	
	private int idEventt;

	public ParticipationPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParticipationPK(long iduserr, int idEventt) {
		super();
		this.iduserr = iduserr;
		this.idEventt = idEventt;
	}

	public long getIduserr() {
		return iduserr;
	}

	public void setIduserr(long iduserr) {
		this.iduserr = iduserr;
	}

	public int getIdEventt() {
		return idEventt;
	}

	public void setIdEventt(int idEventt) {
		this.idEventt = idEventt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEventt;
		result = prime * result + (int) (iduserr ^ (iduserr >>> 32));
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
		ParticipationPK other = (ParticipationPK) obj;
		if (idEventt != other.idEventt)
			return false;
		if (iduserr != other.iduserr)
			return false;
		return true;
	}

	
	
}
