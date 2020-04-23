package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SALLE")
public class Salle implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Salle_id")
    private int id;
	
	@Column(name="Salle_numero")
	private int numero_salle;
	
	@Column(name="Salle_capacité")
	private int capacité_salle;
	
	@Column(name="Salle_disponibilité")
	@Enumerated(EnumType.STRING)
	private Disponibilité_salle disponibilité;

	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_salle() {
		return numero_salle;
	}

	public void setNumero_salle(int numero_salle) {
		this.numero_salle = numero_salle;
	}

	public int getCapacité_salle() {
		return capacité_salle;
	}

	public void setCapacité_salle(int capacité_salle) {
		this.capacité_salle = capacité_salle;
	}

	public Disponibilité_salle getDisponibilité() {
		return disponibilité;
	}

	public void setDisponibilité(Disponibilité_salle disponibilité) {
		this.disponibilité = disponibilité;
	}
	
	
}
