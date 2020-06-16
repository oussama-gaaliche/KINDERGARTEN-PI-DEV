package tn.esprit.spring.Services;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Controller.HomeController;
import tn.esprit.spring.Repository.MessageBrockerRepository;
import tn.esprit.spring.Repository.MessageRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.MessageBrocker;
import tn.esprit.spring.entity.Oppor;
import tn.esprit.spring.entity.User;

@Service
@EnableScheduling
public class MessageService {
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	MessageBrockerRepository messageBrokerRepository;
	@Autowired
	UserRepository userRepository;
	
	public List<Message> AllMessages()
	{
		List<Message> listOfMessages = new ArrayList<>();
		messageRepository.findAll().forEach(listOfMessages::add);
		return listOfMessages;
	}
	public List<MessageBrocker> sendedMessages(){
		List <MessageBrocker> listOfSendedMessages = new ArrayList<>();
		 messageBrokerRepository.findAll().forEach(listOfSendedMessages::add);
		return listOfSendedMessages;
	}
	public int nbmessage(String username,String username1){
		int a=0;
		List<MessageBrocker> messages=messageBrokerRepository.nbrmessage(username, username1);
		System.out.println(messages);
		for(MessageBrocker m:messages){
			if(m.getUserSender().equals(username)){ 
				a++;
				if(a==5){
					break;
					
				}
			}
			
		}
		return a;
	}
	public void sendMessage(MessageBrocker message)
	{
		
		messageBrokerRepository.save(message);
		
	}
	public void sendMessageToSpecificUser(MessageBrocker messageBroker)
	{
		Message message = new Message(new Date(),messageBroker.getMessageContent(),messageBroker.getUserSender(),userRepository.findByUsername(messageBroker.getUserReciver()).get());
		messageRepository.save(message);
	}
	
	public List<Message> ourMessages(String myUsername,String username)
	{
		
	List<Message> myMessages =	AllMessages().stream().filter(message-> 
			((message.getSender().equals(myUsername) && message.getUserReciver().getUsername().equals(username))
													||
			( message.getUserReciver().getUsername().equals(myUsername) && message.getSender().equals(username))))
			.collect(Collectors.toList());
	for(Message m :myMessages){
		m.setNotification(true);
		messageRepository.save(m);
	}
	System.out.println("azezaeaze"+myMessages);
	
	return myMessages;
}
	public String deleteMessage(String username, Long id){
		User connect=userRepository.findUserByUsername(username);
		Message message=(Message) AllMessages().stream().filter(m->(m.getSender().equals(connect.getId())&&m.getId().equals(id)));
		if(message.isNotification()==true)
			return "vous ne pouvez pas supprimer ce message";
		messageRepository.delete(message);
		return "supprission de message succes";
	}
	
	public List<User> listactif(){
		List<User> li= messageRepository.lista(HomeController.connectedUser);
		
	
		return li;
}
	
}