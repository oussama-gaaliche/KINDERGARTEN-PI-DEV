package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "restrict_word")
@Component
public class RestrictWord extends Persistent {

	
	private String word;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "word_seq")
	@SequenceGenerator(name = "word_seq", sequenceName = "word_seq")
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public RestrictWord() {}
	
	public RestrictWord(String word) {
		super();
		this.word = word;
	}

	@Column(name="word", nullable = false)
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
}
