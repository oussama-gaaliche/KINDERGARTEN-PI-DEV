package tn.esprit.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Repository.CommandeRepository;
import tn.esprit.spring.Repository.FactureRepository;
import tn.esprit.spring.Repository.NotifRepository;
import tn.esprit.spring.Services.ArticleServiceImpl;
import tn.esprit.spring.Services.CommandeServiceImpl;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.EtatNotif;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Notification;

@Scope(value = "session")
@Controller(value = "DashJsfController")
@ELBeanName(value = "DashJsfController")
@Join(path = "/dashvente", to = "/dashvente.jsf")
public class DashJsfController {
	@Autowired
	ArticleServiceImpl as;
	@Autowired
	CommandeServiceImpl cs;
	@Autowired
	NotifRepository nr;
	@Autowired
	FactureRepository fr;
	@Autowired
	CommandeRepository cr;
	private List<Notification> notifications;
	private int nombrenotifs;
	private String numsaisi;
	private Long idfact;
	private List<Commande> list;
	public List<Notification> getNotifications() {
		notifications=as.retrieveNotifs();
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	public int getNombrenotifs() {
		List<Notification> ln=nr.retrieveNotifByEtat(EtatNotif.enAttente);
		nombrenotifs=ln.size();
		return nombrenotifs;
	}
	
	public void setNombrenotifs(int nombrenotifs) {
		this.nombrenotifs = nombrenotifs;
	}
		
	public void chercherFacture()
	{
		Optional<Facture> f=fr.retrieveFactureByNum(numsaisi);
		idfact=f.get().getId();
		
		
		
	}
	public List<Commande> getList() {
		List<Commande> list=cr.retrieveCommandByfact(idfact);
		return list;
	}
	public void setList(List<Commande> list) {
		this.list = list;
	}
	
	
}
