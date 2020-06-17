package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_coupon;
	private String code;
	private double promo;
	
	public Coupon() {
		super();
	}
	public Coupon(Long id_coupon, String code, double promo) {
		super();
		this.id_coupon = id_coupon;
		this.code = code;
		this.promo = promo;
	}
	@Override
	public String toString() {
		return "Coupon [id_coupon=" + id_coupon + ", code=" + code + ", promo=" + promo + "]";
	}
	public Long getId_coupon() {
		return id_coupon;
	}
	public void setId_coupon(Long id_coupon) {
		this.id_coupon = id_coupon;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPromo() {
		return promo;
	}
	public void setPromo(double promo) {
		this.promo = promo;
	}

	
}
