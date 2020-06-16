package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ratingRestoPk  implements Serializable {
	private static final long serialVersionUID = 5377539445871317492L;
	
    private long iduser;
	
	private int idplan;

	


	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public int getIdplan() {
		return idplan;
	}

	public void setIdplan(int idplan) {
		this.idplan = idplan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idplan;
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
		ratingRestoPk other = (ratingRestoPk) obj;
		if (idplan != other.idplan)
			return false;
		if (iduser != other.iduser)
			return false;
		return true;
	}

	public ratingRestoPk(int iduser, int idplan) {
		super();
		this.iduser = iduser;
		this.idplan = idplan;
	}

	public ratingRestoPk() {
		super();
	}

}
