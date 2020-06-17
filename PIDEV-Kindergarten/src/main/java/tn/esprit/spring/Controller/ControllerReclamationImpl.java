package tn.esprit.spring.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Repository.reclamationRepository;
import tn.esprit.spring.Services.EmailService;
import tn.esprit.spring.Services.IReclamationService;
import tn.esprit.spring.Services.RestrictWordService;
import tn.esprit.spring.Services.UserService;
import tn.esprit.spring.entity.RestrictWord;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.reclamation;
import tn.esprit.spring.entity.TypeReclamation;

@Scope(value = "session")
@Controller(value = "ControllerReclamationImpl")
@ELBeanName(value = "ControllerReclamationImpl")
@Join(path = "/reclamationParent", to = "/reclamationParent.jsf")

public class ControllerReclamationImpl {

	@Autowired
	UserService userService;
	@Autowired
	IReclamationService reclamationService;
	@Autowired
	UserRepository userrepository;
	@Autowired
	RestrictWordService restrictWordService;
	@Autowired
	private EmailService emailService;

	private String body;
	private Date posted = Calendar.getInstance().getTime();
	private TypeReclamation typeReclamation;
	private List<reclamation> reclamations;
	private Long reclamationIdToBeUpdated;
	

	private Boolean badWordsValidation(String [] wordsFromText ) {
		 List<RestrictWord> restrictWords = restrictWordService.findAll();
		 Boolean thatsOk = true;
		 if (!restrictWords.isEmpty())
			 for (int i = 0; i < wordsFromText.length;i++) {
				 String wordFromText = wordsFromText[i];
				 if (restrictWords.stream().filter(word-> word.getWord().equalsIgnoreCase(wordFromText)).count() > 0) {
					 thatsOk = false;
					 FacesContext context = FacesContext.getCurrentInstance();			         
				     context.addMessage("somekey", new FacesMessage( FacesMessage.SEVERITY_ERROR, "Erreur le contexte est invalide ", "CONTEXT INVALIDE"));
				     break;
				 }
			 }		
		return thatsOk;}
	
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

		 User sender = userrepository.findUserByUsername(HomeController.connectedUser);
		reclamations =  reclamationService.findReclamationsBySender(sender);
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

	public ControllerReclamationImpl() {
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
	int j=0;
	 int i = 0 ;
	 

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String addReclamation() throws Exception{
		
		
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
		   
			 
		 }else
		
		
			
		 if (badWordsValidation(wordsFromText)) {
			
			reclamationService.ajouterReclamation(new reclamation(body, posted, sender, typeReclamation, recipient));
			
			for (reclamation recl : reclamations) {
			if (recl.getTypeReclamation().equals(TypeReclamation.LIBRAIRIE)) {
			  i=i+1;	}
			else {
				  j=j+1;}				
			if (i==2){
							
					 try {
				            emailService.sendMail(recipient.getEmail(), "Alert!!!", "Veuillez prendre une décision à propos de la librairie");
				        } catch (MessagingException e) {
				            e.printStackTrace();
				        }
							

					
				}
			else { 
			
			if (j==2){
				
				 try {
			            emailService.sendMail(recipient.getEmail(), "Alert!!!", "Veuillez prendre une décision à propos du restaurant");
			        } catch (MessagingException e) {
			            e.printStackTrace();
			        }
						

				
			}
				}
			}
			}
				
			
		

	
		 body="";
		 return body;
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

	public ControllerReclamationImpl(UserService userService, IReclamationService reclamationService,
			UserRepository userrepository, String body, Date posted, TypeReclamation typeReclamation,
			List<reclamation> reclamations, User sender, User recipient) {
		super();
		this.userService = userService;
		this.reclamationService = reclamationService;
		this.userrepository = userrepository;
		this.body = body;
		this.posted = posted;
		this.typeReclamation = typeReclamation;
		this.reclamations = reclamations;
		this.sender = sender;
		this.recipient = recipient;
	}
	public String goReclam() {

		return "/reclamationParent.xhtml?faces-redirect=true";
	}

}