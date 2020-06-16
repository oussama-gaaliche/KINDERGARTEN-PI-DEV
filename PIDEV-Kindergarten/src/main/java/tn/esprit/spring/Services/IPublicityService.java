package tn.esprit.spring.Services;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Publicity;


public interface IPublicityService {
	List<Publicity> retrieveAllPublicities(Long id);
	List<Publicity> retrieveAllPublicitiesPub();
	String addPublicity(Publicity p) ;
	void deletePublicity(int i);
    public void updatePublicity();
	Publicity retrievePublicity(int idUser);
    void updateRating();
    int addOrUpdatePub(Publicity pub);
    byte[] findImage(int imageId);
	float getRating(int id);
	List<Publicity> searchPub(String msg);
	


}
