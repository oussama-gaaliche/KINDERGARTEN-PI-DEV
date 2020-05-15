package tn.esprit.spring.entity;



import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;






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
	private String marque;
	private String category;
	private float priceSponsoring;
	
	
	@Lob
	@Column(length = 2125635)
	private byte[] image;
	
	private float average;
	
	
	
	
	
	@ManyToOne
	User User;
	
	



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id =  id;
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

	

	

	

	

	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		this.User = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Publicity(int id, String productName, String category, float priceSponsoring, byte[] image, User user) {
		super();
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.priceSponsoring = priceSponsoring;
		this.image = image;
		this.User = user;
	}


	



	public Publicity(int id, String productName, String marque, String category, float priceSponsoring) {
		super();
		this.id = id;
		this.productName = productName;
		this.marque = marque;
		this.category = category;
		this.priceSponsoring = priceSponsoring;
	}

	public Publicity() {
		super();
	}



	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}



	public Float getAverage() {
		return average;
	}



	

	public Publicity(@NotEmpty(message = "Please provide your product name") String productName, String marque,
			String category, Float priceSponsoring, byte[] image, float average, tn.esprit.spring.entity.User user) {
		super();
		this.productName = productName;
		this.marque = marque;
		this.category = category;
		this.priceSponsoring = priceSponsoring;
		this.image = image;
		this.average = average;
		User = user;
	}

	public Publicity(int id, String productName, String marque, String category, float priceSponsoring, byte[] image,
			float average, tn.esprit.spring.entity.User user) {
		super();
		this.id = id;
		this.productName = productName;
		this.marque = marque;
		this.category = category;
		this.priceSponsoring = priceSponsoring;
		this.image = image;
		this.average = average;
		User = user;
	}

	public Publicity(String productName, String marque, String category, float priceSponsoring) {
		super();
		this.productName = productName;
		this.marque = marque;
		this.category = category;
		this.priceSponsoring = priceSponsoring;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	





	
	
	
	
	//
	
	
	
	
	
	
	
	

}
