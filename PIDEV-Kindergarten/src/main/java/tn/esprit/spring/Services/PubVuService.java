package tn.esprit.spring.Services;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.PubVuRepository;

import tn.esprit.spring.entity.PubVu;
@Service
public class PubVuService implements IPubVuService {
	@Autowired
    private PubVuRepository pubVuRepository;
    private static final Logger L =(Logger) LogManager.getLogger(PubVuService.class);
	
	public String addVu(Long iduser,int idad, PubVu PubVu){
        PubVu.setDateVu(new Date());
		pubVuRepository.save(PubVu);
	
		return "add with succes";
	

}
	
	public int nbVu(int id)
	{
		return  pubVuRepository.nbVu(id);
	}
}
