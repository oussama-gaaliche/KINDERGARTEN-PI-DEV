package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Controller.HomeController;
import tn.esprit.spring.Repository.FriendRepository;
import tn.esprit.spring.Repository.MessageBrockerRepository;
import tn.esprit.spring.Repository.MessageRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.Friend;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.MessageBrocker;
import tn.esprit.spring.entity.User;

@Service
@EnableScheduling
public class FriendService {
	
	@Autowired
	FriendRepository friendRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	MessageBrockerRepository messageBrockerRepository;
	public void addFriend(Friend friend)
	{
		friendRepository.save(friend);
	}
	public List<Friend> allFriend()
	{
		List<Friend>friends = new ArrayList<>();
		
		friendRepository.findAll().forEach(friends::add);
		return friends;
		
	}
	public List<User> allUser()
	{
		List<User>users = new ArrayList<>();
		
		userRepository.findAll().forEach(users::add);
		return users;
		
	}
	public List<User> myFriends(String username )
	{
		User connected = userRepository.findByUsername(username).get();
		List<Friend> myfriend=allFriend().stream().filter(r->(r.getUser1()== connected.getId() || r.getUser2()== connected.getId())&&r.isStatus()==false).collect(Collectors.toList());
				List<User> MyFriends= new ArrayList<>();
				myfriend.forEach(r->{
			if(r.getUser1() == connected.getId())
			MyFriends.add(userService.getAllUsers().stream().filter(user->user.getId()== r.getUser2()).findFirst().get());
			else 
				MyFriends.add(userService.getAllUsers().stream().filter(user->user.getId()== r.getUser1()).findFirst().get());
				
		});
		return MyFriends;
	}
	
	public List<User> friendNonPreferer(String username){
		User connected = userRepository.findByUsername(username).get();
		List<Friend> myfriend=allFriend().stream().filter(r->(r.getUser1()== connected.getId() || r.getUser2()== connected.getId())&&r.isStatus()==false).collect(Collectors.toList());
				List<User> MyFriends= new ArrayList<>();
				myfriend.forEach(r->{
			if(r.getUser1() == connected.getId())
			MyFriends.add(userService.getAllUsers().stream().filter(user->user.getId()== r.getUser2()).findFirst().get());
			else 
				MyFriends.add(userService.getAllUsers().stream().filter(user->user.getId()== r.getUser1()).findFirst().get());
				
		});
				List<User> friendpreferer=messageRepository.lista(HomeController.connectedUser);
//				for(User f:MyFriends){
//					for(User s:friendpreferer){
//						if(s.equals(f))
//							MyFriends.remove(f);
//							
//					}
//				}
		return MyFriends;
		
	}
	
	public void BlockFriend(Long idfriend,String username){
		User connected = userRepository.findByUsername(username).get();
		
		List<Friend> myfriend=allFriend().stream().filter(r->(r.getUser1()== idfriend || r.getUser2()== idfriend)).collect(Collectors.toList());
		for(Friend f:myfriend){
		if(connected.getId()==f.getUser1()||connected.getId()==f.getUser2()){
		f.setStatus(true);
		friendRepository.save(f);
		break;
		}
		
		}
		
			
		}
	@Transactional
	@Scheduled(cron="*/10 * * * * ?")
	public void SignalFriend(){
		User connected = userRepository.findByUsername(HomeController.connectedUser).get();
		
		List<Friend> myfriend=allFriend().stream().filter(r->(r.getUser1()== connected.getId())).collect(Collectors.toList());
		for(Friend f:myfriend){
	Optional<User> user1=userRepository.findById(f.getUser2());
	if(f.isChangesig()==false){
		f.setChangesig(true);
		friendRepository.save(f);
		MessageBrocker m= new MessageBrocker(user1.get().getUsername(),HomeController.connectedUser,new Date(),"Coucou "+user1.get().getUsername()+" Let's start our conversation ",false);
		messageBrockerRepository.save(m);
		
	}
		}
		
			
		}
	public String BlocksigFriend(Long idfriend,String username){
		
		User connected = userRepository.findByUsername(username).get();
		
		List<Friend> myfriend=allFriend().stream().filter(r->(r.getUser1()== idfriend || r.getUser2()== idfriend)).collect(Collectors.toList());
		for(Friend f:myfriend){
		if(connected.getId()==f.getUser1()||connected.getId()==f.getUser2()){
			if(f.isSigblock()==false){
		f.setStatus(true);
		f.setSigblock(true);
		f.setIdsign(connected.getId());
		friendRepository.save(f);
		return"sgnal friend acces";
			}
		break;
		}
		
		}
		
			return "forbidden  signal ";
		}
	@Transactional
	@Scheduled(cron="*/10 * * * * ?")
	public void bannedCompte(){
		for(User u:allUser()){
			userRepository.BannedUser(u.getId());
			friendRepository.BannedUser(u.getId());
		}
	}
	@Transactional
	@Scheduled(cron="*/60 * * * * ?")
	public void recupComptes(){
		for(User u:allUser()){
			if((u.isActive()==false)&&(u.getNbrsig()<2)&&u.getStatus().equals("yes"))
			{
				u.setActive(true);
				userRepository.save(u);
			}
			
		}
		
	}
	
}
