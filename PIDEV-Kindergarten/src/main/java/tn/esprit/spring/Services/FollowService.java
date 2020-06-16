
package tn.esprit.spring.Services;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Controller.HomeController;
import tn.esprit.spring.Controller.UserControllerfront;
import tn.esprit.spring.Repository.FollowRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.Follow;
import tn.esprit.spring.entity.User;

@Service
public class FollowService  {
	@Autowired
	FollowRepository FollowRepository;
	@Autowired
	UserRepository userRepository;

	
	public void SendDemande(String username,String connectedUserName)
	{
		User reciver = new User();
		reciver = userRepository.findByUsername(username).get();
		User sender = new User();
		sender=userRepository.findByUsername(connectedUserName).get();
		Long id_sender ;
		id_sender=sender.getId();
		
		
	    Follow follow = new Follow(false,id_sender,"NULL",new Date(),reciver);
	   FollowRepository.save(follow);
	  
		
	}
	public List<Follow> allFollows()
	{
		List<Follow> follows = new ArrayList<>();
		FollowRepository.findAll().forEach(follows::add);
		return follows;
	}
	public List<Follow> myReivedDemandes(String userName)
	{
		
		return allFollows().stream().filter(d->d.getUserReciver().getUsername().equals(userName)).collect(Collectors.toList());		
		 
	}
	public List<String> userssendedtome(String userName){
		List<String> Users=new ArrayList();
		for (Follow f : myReivedDemandes(userName)) {
			Users.add(userRepository.findById(f.getId_Sender()).get().getUsername());
			
		
		}
		return Users;
		
		
	}
	public List<Follow> MySendedDemandes(String userName)
	{	
		return  allFollows().stream().filter(d->d.getId_Sender()==userRepository.findByUsername(userName).get().getId()).collect(Collectors.toList());		
	}
	
	
	public void  changeStatus(Follow follow , int id )
	{
		Follow selected = allFollows().stream().filter(d->d.getId()==id).findFirst().get();
		
		selected.setEtat(follow.getEtat());
		selected.setDate(new Date());
		
		FollowRepository.save(selected);	
	
	}
	public void DeleteFollow(Follow follow )
	{
		FollowRepository.delete(follow);
	}
	public User userconnecter(){
		return userRepository.userconnect(HomeController.connectedUser);
	}
	public void DeleteFollow1(long id )
	{
		Follow selected = allFollows().stream().filter(d->(d.getId_Sender()==userconnecter().getId() && d.getUserReciver().getId()==id)).findFirst().get();
		FollowRepository.delete(selected);
	}
	public void DeleteFollow2(long id )
	{
		Follow selected = allFollows().stream().filter(d->(d.getId_Sender()==id && d.getUserReciver().getId()==userconnecter().getId())).findFirst().get();
		FollowRepository.delete(selected);
	}
	public void DeleteFollowAuto()
	{
		
		for(Follow f :allFollows()){
			if(!(f.getEtat().equals("Accepted")))
		FollowRepository.delete(f);
		}
	}

}

