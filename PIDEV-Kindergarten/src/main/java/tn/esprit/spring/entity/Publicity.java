package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Publicity")
public class Publicity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private String category;
	private float priceSponsoring;
	private String image;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPriceSponsoring() {
		return priceSponsoring;
	}

	public void setPriceSponsoring(float priceSponsoring) {
		this.priceSponsoring = priceSponsoring;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Publicity(int id, String productName, String category, float priceSponsoring, String image, User user) {
		super();
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.priceSponsoring = priceSponsoring;
		this.image = image;
		this.user = user;
	}

	public Publicity(String productName, String category, float priceSponsoring, String image, User user) {
		super();
		this.productName = productName;
		this.category = category;
		this.priceSponsoring = priceSponsoring;
		this.image = image;
		this.user = user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
