package tn.esprit.spring.Controller;

import java.util.Date;

public class Data {
	 private Date value1;
	  public Date getValue1() {
		return value1;
	}
	public void setValue1(Date value1) {
		this.value1 = value1;
	}
	public Data(Date value1) {
		super();
		this.value1 = value1;
	}
	@Override
	public String toString() {
		return "Data [value1=" + value1 + "]";
	}
	

}
