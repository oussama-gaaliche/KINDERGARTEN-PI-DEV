package tn.esprit.spring.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.IReclamationService;
import tn.esprit.spring.Services.RestrictWordService;
import tn.esprit.spring.Services.UserService;
import tn.esprit.spring.entity.RestrictWord;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.reclamation;
import tn.esprit.spring.entity.TypeReclamation;

@Scope(value = "session")
@Controller(value = "ControllerReclamationImpladmin")
@ELBeanName(value = "ControllerReclamationImpladmin")
@Join(path = "/reclamationAdmin", to = "/reclamationAdmin.jsf")

public class ControllerReclamationImpladmin {

	@Autowired
	UserService userService;
	@Autowired
	IReclamationService reclamationService;
	@Autowired
	UserRepository userrepository;
	@Autowired
	RestrictWordService restrictWordService;

	private String body;
	private Date posted = Calendar.getInstance().getTime();
	private TypeReclamation typeReclamation;
	private List<reclamation> reclamations;
	private List<reclamation> reclamationOrderTypes;
	private Long reclamationIdToBeUpdated;
	private TypeReclamation type;

    private String msg = "";


public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



public List<reclamation> getAllRec() {

		if (this.msg.length() == 0)
			return reclamationService.getAllReclamations();
		else
			return reclamationService.searchRec(msg);
	}

	

	public TypeReclamation getType() {
		return type;
	}

	public void setType(TypeReclamation type) {
		this.type = type;
	}

	public String getreclamationOrderTypes( TypeReclamation type){
		this.setTypeReclamation(type);
		
		
		reclamationOrderTypes = reclamationService.findByTypeReclamationOrderByPostedDesc(type);
		return "/reclamationAdminfiltre.xhtml?faces-redirect=true";
	}
	


	public List<reclamation> getReclamationOrderTypes() {
		return reclamationOrderTypes;
	}

	public void setReclamationOrderTypes(List<reclamation> reclamationOrderTypes) {
		this.reclamationOrderTypes = reclamationOrderTypes;
	}

	public User getRecipient(){
	 List<User> users = userrepository.findAll();

		for (User user : users) {
			if (user.getRoles().equals(Role.RESPONSABLE)) {
				recipient = user  ;
			}
			
		}return recipient;
		}

	public void displayReclamation(reclamation rec) {
		 User sender = userrepository.findUserByUsername(HomeController.connectedUser);
		 this.setSender(rec.getSender());
		this.setRecipient(rec.getRecipient());
		this.setBody(rec.getBody());
		this.setPosted(rec.getPosted());
		this.setTypeReclamation(rec.getTypeReclamation());
		this.setReclamationIdToBeUpdated(rec.getId());
	}
	public void removeReclamation(Long  reclamationId) {
		reclamationService.supprimerReclamation(reclamationId);
	}
	
	public List<reclamation> getReclamations() {
		
		reclamations =  reclamationService.getAllReclamations();
		 if ( reclamations.isEmpty()){
			 FacesContext context = FacesContext.getCurrentInstance();			         
		     context.addMessage("somekey3", new FacesMessage( FacesMessage.SEVERITY_ERROR, "Aucune reclamation a afficher ", "CONTEXT INVALIDE"));
		    
		 }
		 
		return reclamations;
	}

	public Long updateReclamation() {
		sender = userrepository.findUserByUsername(HomeController.connectedUser);
		;

		List<User> users = userrepository.findAll();

		for (User user : users) {
			if (user.getRoles().equals("RESPONSABLE")) {
				recipient = user;
			}
		}

		return reclamationService.addOrUpdateReclamation(new reclamation(reclamationIdToBeUpdated ,body, posted, sender, typeReclamation, recipient));
	}

	public IReclamationService getReclamationService() {
		return reclamationService;
	}

	public void setReclamationService(IReclamationService reclamationService) {
		this.reclamationService = reclamationService;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public TypeReclamation[] getTypeReclamations() {
		return TypeReclamation.values();
	}

	

	public void setReclamations(List<reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public ControllerReclamationImpladmin() {
		super();
	}

	public TypeReclamation getTypeReclamation() {
		return typeReclamation;
	}

	public void setTypeReclamation(TypeReclamation typeReclamation) {
		this.typeReclamation = typeReclamation;
	}

	User sender = null;
	User recipient = null;

	public reclamation addReclamation() {
		
		sender = userrepository.findUserByUsername(HomeController.connectedUser);
		;

		List<User> users = userrepository.findAll();

		for (User user : users) {
			if (user.getRoles().equals("RESPONSABLE")) {
				recipient = user;
			}
		}	
		String [] wordsFromText = body.split(" ");	
		 if (body=="") {
			 FacesContext context = FacesContext.getCurrentInstance();			         
		     context.addMessage("somekey1", new FacesMessage( FacesMessage.SEVERITY_ERROR, "Veuillez saisir votre reclamation ", "CONTEXT INVALIDE"));
		   
			 
		 }else  if (typeReclamation==null) {
			 FacesContext context = FacesContext.getCurrentInstance();			         
		     context.addMessage("somekey2", new FacesMessage( FacesMessage.SEVERITY_ERROR, "Veuillez saisir votre type de reclamation ", "CONTEXT INVALIDE"));
		   
			 
		 }
		
		
		
		

			 return reclamationService.ajouterReclamation(new reclamation(body, posted, sender, typeReclamation, recipient));
		
		 

		 }

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserRepository getUserrepository() {
		return userrepository;
	}

	public Long getReclamationIdToBeUpdated() {
		return reclamationIdToBeUpdated;
	}
	public void setReclamationIdToBeUpdated(Long reclamationIdToBeUpdated) {
		this.reclamationIdToBeUpdated = reclamationIdToBeUpdated;
	}
	public void setUserrepository(UserRepository userrepository) {
		this.userrepository = userrepository;
	}

	

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}



	

}