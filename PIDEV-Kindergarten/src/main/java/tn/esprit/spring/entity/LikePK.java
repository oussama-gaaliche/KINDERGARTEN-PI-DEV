package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LikePK  implements Serializable {
	
	
	private static final long serialVersionUID = 5377539445871317492L;	
   
	private long idUser;
	
	private long idPost;


	public LikePK() {
		super();
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPost ^ (idPost >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
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
		LikePK other = (LikePK) obj;
		if (idPost != other.idPost)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}


	public long getIdUser() {
		return idUser;
	}


	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}


	public long getIdPost() {
		return idPost;
	}


	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}


	@Override
	public String toString() {
		return "LikePK [idUser=" + idUser + ", idPost=" + idPost + "]";
	}

	

}
