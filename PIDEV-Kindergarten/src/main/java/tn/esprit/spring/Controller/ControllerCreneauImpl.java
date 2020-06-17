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

import tn.esprit.spring.Repository.CreneauRepository;
import tn.esprit.spring.Repository.TeacherRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.IMetier;
import tn.esprit.spring.Services.IReclamationService;
import tn.esprit.spring.Services.RestrictWordService;
import tn.esprit.spring.Services.UserService;
import tn.esprit.spring.entity.Creneau;
import tn.esprit.spring.entity.RestrictWord;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.Teacher;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.reclamation;
import tn.esprit.spring.entity.TypeReclamation;

@Scope(value = "session")
@Controller(value = "ControllerCreneauImpl")
@ELBeanName(value = "ControllerCreneauImpl")
@Join(path = "/creneauTeacher", to = "/creneauTeacher.jsf")

public class ControllerCreneauImpl {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userrepository;
	@Autowired
	CreneauRepository creneauRepository;
	@Autowired
	IMetier metier;
	@Autowired
	TeacherRepository teacherRepository;

	private int hdebut;
	private int mdebut;
	private int hfin;
	private int mfin;
	private List<Creneau> creneaux;
	private Long creneauIdToBeUpdate;
	Teacher teach;
	
	public void addCreneau() throws Exception{
		
		   User  teacher = userrepository.findUserByUsername(HomeController.connectedUser);
			
			if (teacher.getRoles().equals("ENSEIGNANT")) {
				Long idTeacher = teacher.getId();
				
			
			
			if (((hfin-hdebut)==0)&&(((mfin-mdebut)<20)||((mfin-mdebut)>40))) {
				 FacesContext context = FacesContext.getCurrentInstance();			         
			     context.addMessage("somekey11", new FacesMessage( FacesMessage.SEVERITY_ERROR, "le creneau horaire doit durer au minimum 20 minutes  et au maximum 40 minutes", "CONTEXT INVALIDE"));
				
			} else if ((hfin-hdebut)<0){ 
				FacesContext context = FacesContext.getCurrentInstance();			         
			     context.addMessage("somekey12", new FacesMessage( FacesMessage.SEVERITY_ERROR, "heure fin doit etre supérieure a heure debut", "CONTEXT INVALIDE"));
			
			}else if (((hfin-hdebut)==1)&&((((mfin+60)-mdebut)<20)||(((mfin+60)-mdebut)>40))){
				 FacesContext context = FacesContext.getCurrentInstance();			         
			     context.addMessage("somekey13", new FacesMessage( FacesMessage.SEVERITY_ERROR, "le creneau horaire doit durer au minimum 20 minutes  et au maximum 40 minutes", "CONTEXT INVALIDE"));
			}
			else if ((hfin==hdebut)&&(mfin==mdebut)){
				 FacesContext context = FacesContext.getCurrentInstance();			         
			     context.addMessage("somekey14", new FacesMessage( FacesMessage.SEVERITY_ERROR, "Ce creneau horaire existe déjà", "CONTEXT INVALIDE"));
			}else if ((hdebut<8)||(hfin>17)){
				 FacesContext context = FacesContext.getCurrentInstance();			         
			     context.addMessage("somekey15", new FacesMessage( FacesMessage.SEVERITY_ERROR, "Ce creneau horaire est hors les horaires de travail du jardin d'enfants de 8h à 18h", "CONTEXT INVALIDE"));
			} else {
		
		      
				Teacher teach = teacherRepository.getTeacherByIdUser(idTeacher);
			
			   metier.ajouterCreneau(new Creneau( hdebut, mdebut, hfin, mfin, teach));
		
			 }}
			}
	
	public List<Creneau> getCreneaux() {
		
		User teacher = userrepository.findUserByUsername(HomeController.connectedUser);
		if (teacher.getRoles().equals("ENSEIGNANT")) {
		Long idTeacher = teacher.getId(); 
		 teach = teacherRepository.getTeacherByIdUser(idTeacher);}
		List<Creneau> Creneaux =  metier.getAllCreneaux(teach.getId());
		
		return Creneaux;
	}


	public Teacher getTeach() {
		return teach;
	}

	public void setTeach(Teacher teach) {
		this.teach = teach;
	}

	public void displayCreneau(Creneau  creneau) {
		
		this.setTeach(creneau.getTeacher());
		this.setHdebut(creneau.getHdebut());
		this.setMdebut(creneau.getMdebut());
		this.setHfin(creneau.getHfin());
		this.setMfin(creneau.getMfin());
		this.setCreneauIdToBeUpdate(creneau.getId());

		
	}
	


	public int getHdebut() {
		return hdebut;
	}
	public void setHdebut(int hdebut) {
		this.hdebut = hdebut;
	}
	public int getMdebut() {
		return mdebut;
	}
	public void setMdebut(int mdebut) {
		this.mdebut = mdebut;
	}
	public int getHfin() {
		return hfin;
	}
	public void setHfin(int hfin) {
		this.hfin = hfin;
	}
	public int getMfin() {
		return mfin;
	}
	public void setMfin(int mfin) {
		this.mfin = mfin;
	}
	public void removeCreneau(Long  id) {
		metier.supprimerCreneau(id);
	}
	
	

	public Long updateCreneau() {
		User  teacher = userrepository.findUserByUsername(HomeController.connectedUser);
		
		if (teacher.getRoles().equals("ENSEIGNANT")) {
			Long idTeacher = teacher.getId();
		 teach = teacherRepository.getTeacherByIdUser(idTeacher);
	         }
		
	
		 
		

		return metier.addOrUpdateCreneau(new Creneau(creneauIdToBeUpdate ,hdebut, mdebut, hfin, mfin, teach));
	}

	


	

	

	

	

	public ControllerCreneauImpl() {
		super();
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

	public void setUserrepository(UserRepository userrepository) {
		this.userrepository = userrepository;
	}

	public CreneauRepository getCreneauRepository() {
		return creneauRepository;
	}

	public void setCreneauRepository(CreneauRepository creneauRepository) {
		this.creneauRepository = creneauRepository;
	}

	public IMetier getMetier() {
		return metier;
	}

	public void setMetier(IMetier metier) {
		this.metier = metier;
	}

	

	public Long getCreneauIdToBeUpdate() {
		return creneauIdToBeUpdate;
	}

	public void setCreneauIdToBeUpdate(Long creneauIdToBeUpdate) {
		this.creneauIdToBeUpdate = creneauIdToBeUpdate;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

	
	


	

}