package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.LikePlat;
import tn.esprit.spring.entity.Plat;



public interface LikePlatService {
	public String addLike(LikePlat l);
	public List<LikePlat> retrieveAllLike();
	public String updateLike(int id, boolean etat);
	public int nbLike(int id);
	public int meilleurPlat();

}
