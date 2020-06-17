package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javassist.SerialVersionUID;

@Embeddable
public class CommandePk implements Serializable {

	
	   private static final long SerialVersionUID = 1L ;
	   
	   private Long userid ;
	   
	   private Long articleid ;
	   @Enumerated(EnumType.STRING)
		private EtatCommande etat_cmd; 
	public CommandePk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandePk(Long userid, Long articleid) {
		super();
		this.userid = userid;
		this.articleid = articleid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleid == null) ? 0 : articleid.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		CommandePk other = (CommandePk) obj;
		if (articleid == null) {
			if (other.articleid != null)
				return false;
		} else if (!articleid.equals(other.articleid))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getArticleid() {
		return articleid;
	}

	public void setArticleid(Long articleid) {
		this.articleid = articleid;
	}

	public EtatCommande getEtat_cmd() {
		return etat_cmd;
	}

	public void setEtat_cmd(EtatCommande etat_cmd) {
		this.etat_cmd = etat_cmd;
	}
	   
	   
	   
}
