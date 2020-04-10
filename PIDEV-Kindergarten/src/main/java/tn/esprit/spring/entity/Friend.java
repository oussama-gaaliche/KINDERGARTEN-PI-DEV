package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Friend implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Long user1;
	private Long user2;
	private boolean changesig;
	private boolean status;
	private boolean sigblock;
	private Long idsign;
	private boolean verifsig;
	
	
	public boolean isVerifsig() {
		return verifsig;
	}




	public void setVerifsig(boolean verifsig) {
		this.verifsig = verifsig;
	}




	public Friend() {
		super();
	}


	

	public Long getIdsign() {
		return idsign;
	}




	public void setIdsign(Long idsign) {
		this.idsign = idsign;
	}




	public Friend(Long user1, Long user2, boolean changesig, boolean status, boolean sigblock, Long idsign) {
		super();
		this.user1 = user1;
		this.user2 = user2;
		this.changesig = changesig;
		this.status = status;
		this.sigblock = sigblock;
		this.idsign = idsign;
	}




	public Friend(Long user1, Long user2, boolean changesig, boolean status) {
		super();
		this.user1 = user1;
		this.user2 = user2;
		this.changesig = changesig;
		this.status = status;
	}


	public Friend(int id, Long user1, Long user2, boolean changesig, boolean status) {
		super();
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
		this.changesig = changesig;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Long getUser1() {
		return user1;
	}


	public void setUser1(Long user1) {
		this.user1 = user1;
	}


	public Long getUser2() {
		return user2;
	}


	public void setUser2(Long user2) {
		this.user2 = user2;
	}


	public boolean isChangesig() {
		return changesig;
	}


	public void setChangesig(boolean changesig) {
		this.changesig = changesig;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public boolean isSigblock() {
		return sigblock;
	}


	public void setSigblock(boolean sigblock) {
		this.sigblock = sigblock;
	}
	
	
	
	
	
	
}
