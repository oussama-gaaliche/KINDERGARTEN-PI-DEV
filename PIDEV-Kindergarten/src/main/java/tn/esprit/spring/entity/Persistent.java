package tn.esprit.spring.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * @author icaroafonso
 *
 */

@MappedSuperclass
@Component
public abstract class Persistent implements  Cloneable {
	
	protected Long id;
	
	
	@Transient
	public abstract Long getId();
	
	public void setId(Long id) {
		this.id  = id;
	}

	
	
	public Persistent() {
		super();
	}

	public Persistent(Long id) {
		super();
		this.id = id;
	}
}