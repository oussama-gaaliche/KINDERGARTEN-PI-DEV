package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Stock_interne")
public class Stock_interne implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Stock_id")
    private int id;

	@Column(name="Stock_Name")
	private String Name;
	
	@Column(name="Stock_Description")
	private String description;
	
	@Column(name="Quantity_utilisé")
	private   int quantité;
	
	
	@Column(name="Stock_quantité")
	 private  int firstquantite   ;
	
    
	@Enumerated(EnumType.STRING)
	private StockCategory stockcategory;
	
	@Column(name="Stock_Photo")
    private String photo;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private  List<Reservation_Stock_Interne> reservation_stock_interne;
	
	public Stock_interne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	public int getFirstquantite() {
		return firstquantite;
	}

	public void setFirstquantite(int firstquantite) {
		this.firstquantite = firstquantite;
	}

	public StockCategory getStockcategory() {
		return stockcategory;
	}

	public void setStockcategory(StockCategory stockcategory) {
		this.stockcategory = stockcategory;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Reservation_Stock_Interne> getReservation_stock_interne() {
		return reservation_stock_interne;
	}

	public void setReservation_stock_interne(List<Reservation_Stock_Interne> reservation_stock_interne) {
		this.reservation_stock_interne = reservation_stock_interne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + firstquantite;
		result = prime * result + id;
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + quantité;
		result = prime * result + ((reservation_stock_interne == null) ? 0 : reservation_stock_interne.hashCode());
		result = prime * result + ((stockcategory == null) ? 0 : stockcategory.hashCode());
		return result;
	}

	public Stock_interne(int id, String name, String description, int quantité, int firstquantite,
			StockCategory stockcategory, String photo, List<Reservation_Stock_Interne> reservation_stock_interne) {
		super();
		this.id = id;
		Name = name;
		this.description = description;
		this.quantité = quantité;
		this.firstquantite = firstquantite;
		this.stockcategory = stockcategory;
		this.photo = photo;
		this.reservation_stock_interne = reservation_stock_interne;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock_interne other = (Stock_interne) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (firstquantite != other.firstquantite)
			return false;
		if (id != other.id)
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (quantité != other.quantité)
			return false;
		if (reservation_stock_interne == null) {
			if (other.reservation_stock_interne != null)
				return false;
		} else if (!reservation_stock_interne.equals(other.reservation_stock_interne))
			return false;
		if (stockcategory != other.stockcategory)
			return false;
		return true;
	}
	
    
}
