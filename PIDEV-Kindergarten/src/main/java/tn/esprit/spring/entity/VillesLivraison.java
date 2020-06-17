package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "villes")
public class VillesLivraison {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ville;
	private String ville;
	private Long distance;
	public Long getId_ville() {
		return id_ville;
	}
	public void setId_ville(Long id_ville) {
		this.id_ville = id_ville;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Long getDistance() {
		return distance;
	}
	public void setDistance(Long distance) {
		this.distance = distance;
	}

	
}
