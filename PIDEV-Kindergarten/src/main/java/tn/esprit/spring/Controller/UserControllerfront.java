package tn.esprit.spring.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.Configuration.ActiveUserStore;
import tn.esprit.spring.Repository.EnfantRepository;
import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.FriendService;
import tn.esprit.spring.Services.MessageService;
import tn.esprit.spring.Services.UserService;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.User;

@Scope(value = "session")
@Controller(value ="userControllerfront")
@ELBeanName(value = "userControllerfront")
@Join(path = "/", to = "/Sidebarfriend.jsf")
//@RestController
//@RequestMapping("/secure/rest")
@EnableScheduling
public class UserControllerfront {
	@Autowired
    ActiveUserStore activeUserStore;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JardinRepository jardinRepository;
	
	@Autowired
	private EnfantRepository enfantRepository;
	
	@Autowired
  private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	MessageService messageService;
	@Autowired
	FriendService friendService;
	List<User> friends=new ArrayList<>();
	List<Message> messages=new ArrayList<>();
	List<User> otherfriends=new ArrayList<>();
	
	
public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = lisAmiprefrerer();
	}
	

public List<User> getOtherfriends() {
		return otherfriends;
	}

	public void setOtherfriends(List<User> otherfriends) {
		this.otherfriends = listFNP();
	}

public List<User> lisAmiprefrerer(){
		
		List<User> li= messageService.listactif();
		System.out.println(li);
		
		
		return li;
	}
public List<Message> messagesWithOther(String username)
{	System.out.println("qsdqsdqsd"+HomeController.connectedUser);
messages= messageService.ourMessages(HomeController.connectedUser, username);
return messages;
}

public List<User> listFNP(){
	otherfriends=friendService.friendNonPreferer(HomeController.connectedUser);
	return otherfriends;
}


}
