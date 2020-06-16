package tn.esprit.spring.domain;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class ReclamationPost implements Serializable{

	@NotNull
	private Long sender;

	@NotNull
	private Long recipient;

	@NotEmpty
	@Size(min = 1, max = 1000)
	private String body;

	public Long getSender() {
		return sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

	public Long getRecipient() {
		return recipient;
	}

	public void setRecipient(Long recipient) {
		this.recipient = recipient;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	

}
