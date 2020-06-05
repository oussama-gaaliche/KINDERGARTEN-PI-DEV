package tn.esprit.spring.entity;




public class StatNombeInscri {
	
	private Long nombre;
	private String date;
	
	public Long getNombre() {
		return nombre;
	}
	public void setNombre(Long nombre) {
		this.nombre = nombre;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public StatNombeInscri(Long nombre, String date) {
		super();
		this.nombre = nombre;
		this.date = date;
	}
	public StatNombeInscri() {
		super();
	}
	
	
	
	

}
