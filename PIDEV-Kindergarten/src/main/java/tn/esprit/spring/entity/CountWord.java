package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountWord {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column (name="word")
	private String word;
	@Column (name="numberOfRepitition")
	private int NbrRepi;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getNbrRepi() {
		return NbrRepi;
	}
	public void setNbrRepi(int nbrRepi) {
		this.NbrRepi = nbrRepi;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CountWord() {
		super();
	}
	
	
}
