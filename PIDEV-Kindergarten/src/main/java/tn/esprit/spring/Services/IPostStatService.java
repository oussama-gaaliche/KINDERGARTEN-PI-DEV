package tn.esprit.spring.Services;

import java.util.List;

public interface IPostStatService {
	public List<?> retrieveWord();
	public String[] seleccontained();
	public int nbrofreposts(String word);
	public void setRepition();
	

}
