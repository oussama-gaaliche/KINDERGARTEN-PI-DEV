package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="RESERVATION_INTERNE")
public class Reservation_Stock_Interne implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Reservation_Stock_InternePk reservationstockinternepk ;
	
	@Temporal(TemporalType.DATE)
    private Date date_reservation;
	
	private  int quantite ;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idevent", referencedColumnName = "Event_id", insertable=false, updatable=false)
	private Event event; 
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idstock", referencedColumnName = "Stock_id", insertable=false, updatable=false)
	private Stock_interne stock ;
	
	
	
	
	
	
	
	
	
	
	public Reservation_Stock_Interne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation_Stock_InternePk getReservationstockinternepk() {
		return reservationstockinternepk;
	}
	public void setReservationstockinternepk(Reservation_Stock_InternePk reservationstockinternepk) {
		this.reservationstockinternepk = reservationstockinternepk;
	}
	public Date getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	public Stock_interne getStock() {
		return stock;
	}
	public void setStock(Stock_interne stock) {
		this.stock = stock;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
	

}
