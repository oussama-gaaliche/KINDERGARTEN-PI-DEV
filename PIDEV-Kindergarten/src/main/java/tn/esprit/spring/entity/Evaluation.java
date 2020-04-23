package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="EVALUATION")
public class Evaluation implements Serializable  {
	
	
	private static final long serialVersionUID = 1L;
	

	@EmbeddedId
	private EvaluationPK evaluationpk ;
	
	
	@Column(name="Evaluation_value")
	private int evaluation_value;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Evaluation_Date")
	private Date Evaluation_date;
	
	@ManyToOne
	@JoinColumn(name = "idEvent", referencedColumnName = "Event_id", insertable=false, updatable=false)
	private Event event_evaluation ; 
	
	@ManyToOne
	@JoinColumn(name = "iduser", referencedColumnName = "id", insertable=false, updatable=false)
    private User user_evaluation ;


	public int getEvaluation_value() {
		return evaluation_value;
	}

	public void setEvaluation_value(int evaluation_value) {
		this.evaluation_value = evaluation_value;
	}

	public Date getEvaluation_date() {
		return Evaluation_date;
	}

	public void setEvaluation_date(Date evaluation_date) {
		Evaluation_date = evaluation_date;
	}

	public Event getEvent_evaluation() {
		return event_evaluation;
	}

	public void setEvent_evaluation(Event event_evaluation) {
		this.event_evaluation = event_evaluation;
	}

	

	public User getUser_evaluation() {
		return user_evaluation;
	}

	public void setUser_evaluation(User user_evaluation) {
		this.user_evaluation = user_evaluation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EvaluationPK getEvaluationpk() {
		return evaluationpk;
	}

	public void setEvaluationpk(EvaluationPK evaluationpk) {
		this.evaluationpk = evaluationpk;
	}

	
	
	
	
	
	
	}
