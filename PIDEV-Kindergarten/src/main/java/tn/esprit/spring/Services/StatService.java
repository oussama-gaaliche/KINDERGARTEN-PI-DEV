package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.Repository.StatistcRepository;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.LikeUser;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.StatNombeInscri;
import tn.esprit.spring.entity.User;

@EnableScheduling
@Service
public class StatService implements IStatService {
	
	@Autowired
    private StatistcRepository StatisticRepository;
	@Autowired
	private JardinRepository jardinRepository;
  
	private static final Logger L =(Logger) LogManager.getLogger(StatService.class);
	
	@Override
	public List<?> retrieveAllUser() {

		
		return StatisticRepository.listUser();
		}
	@Override
	public List<?> retrieveAllUserMois() {

		
		return StatisticRepository.listMois1();
		}
	
	@Override
	public List<?> retrieveEnfantParJardin() {

		
		return StatisticRepository.listEnfantParJardin();
		
		}
	
	@Override
	public List<?> retrieveEnfantParNiveau() {

		
		return StatisticRepository.listEnfantParNiveau();
		
		}
	


	
	@Override
	@Transactional
	public void updateScore() {
		//System.out.println("manel");
		List<User> user =new ArrayList<User>();
	user=StatisticRepository.findAll();

	
	for( User u : user){
	
			u.setScore( (float) ( 0.1 *(StatisticRepository.bLikeParUser(u.getId())) + 0.2 *(StatisticRepository.nbComParUser(u.getId())) 
					+ 0.4* (StatisticRepository.nbPostParUser(u.getId())) + 0.3*(StatisticRepository.nbParticipationParUser(u.getId()))) );
			
			StatisticRepository.save(u);
	
		}
	}
	@Override
	@Transactional
	public void addnbEnfantParJardin() {

		List<Jardin> jardin =new ArrayList<Jardin>();
	jardin=jardinRepository.findAll();

	
	for( Jardin j : jardin){
	
			j.setNombreEnfant(StatisticRepository.nbEnfantParJardin(j.getId()));
			jardinRepository.save(j);
	
		}
	
	
	}
	
	
	
	
	
	@Override
	public List<?> BestUser() {

		
		return StatisticRepository.BestUser();
		
		}
	
	
		
		
}
	
	
	


