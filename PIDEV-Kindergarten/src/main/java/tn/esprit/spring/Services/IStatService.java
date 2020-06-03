package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.LikeUser;



public interface IStatService {
	public List<?> retrieveAllUser();
	public List<?> retrieveAllUserMois();
	public List<?> retrieveEnfantParJardin();
	public List<?> retrieveEnfantParNiveau();
	public void updateScore();
	public List<?> BestUser();
	void addnbEnfantParJardin();
	
	

}
