package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Repository.ArticleRepository;
import tn.esprit.spring.Repository.NotifRepository;
import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.EtatArticle;
import tn.esprit.spring.entity.EtatNotif;
import tn.esprit.spring.entity.FamilleArticles;
import tn.esprit.spring.entity.Notification;



@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	ArticleRepository articlerepo;
	@Autowired
	NotifRepository nr;
	
	@Override
	public int addArticle(Article a) {
		a.setAchatTTC(a.getAchatHT()+a.getAchatHT()*a.getTva().getCode()/100);
		a.setVenteTTC((a.getVenteHT()+a.getVenteHT()*a.getTva().getCode()/100)*(1-a.getRemise()/100));

		if(a.getQteStock()==0){
			a.setEtat(EtatArticle.Epuisé);
		}
		if(a.getQteStock()==15){
			a.setEtat(EtatArticle.Bientot_epuisé);
		}
		else a.setEtat(EtatArticle.Disponible);
		articlerepo.save(a);
		return 1;
	}
	 @Override
	 public double calculTva(Article a){
		 return a.getVenteHT()*a.getTva().getCode()/100;
	 }
	
	private static final Logger l=LogManager.getLogger(ArticleServiceImpl.class);
	@Override
	public void controleStock(Article a){
		String message=new String();
		Date d=new Date();
		int x=0;
		if(a.getQteStock()==0){
			a.setEtat(EtatArticle.Epuisé);
			message="Attention ! l'article "+a.getNom()+" qui a la reference "+a.getReference()+" est epuisé.";
			x=1;
			
		}
		if(a.getQteStock()<=15){
			a.setEtat(EtatArticle.Bientot_epuisé);
			message="Attention ! l'article "+a.getNom()+" qui a la reference "+a.getReference()+" est bientot epuisé avec une quantité de stock="+a.getQteStock();
			x=1;
		}
		else a.setEtat(EtatArticle.Disponible);
		if(x==1)
		{
			Notification n=new Notification();
			n.setMessage(message);
			n.setDate_notif(d);
			n.setEtat(EtatNotif.enAttente);
			nr.save(n);
		}
		articlerepo.save(a);
		
		
	} 
	@Override
	public List<Article> retrieveAllArticles(){
		List<Article> articles = (List<Article>) articlerepo.findAll();
		for (Article a : articles){
			l.info("article +++"+a);
		}
		return articles;
	}
	
	public List<Notification> retrieveNotifs(){
		List<Notification> notifs = (List<Notification>) nr.findAll();
		return notifs;
	}
	
	@Override
	public void deleteArticle(int id) {
		articlerepo.deleteById((long) id);		
	}
	
	@Override
	public Article updateArticle(Article a) {
		articlerepo.save(a);
		 return a;
	}
	@Override
	public List<Article> retrieveAllArticlesByStock(){
		List<Article> articles = (List<Article>) articlerepo.retrieveAllArticlesByStock();
		for (Article a : articles){
			l.info("article +++"+a);
		}
		return articles;
		
	}
	@Override
	public List<Article> retrieveArticlesByCommand(Long id_cmd){
		List<Article> articles = (List<Article>) articlerepo.retrieveArticlesByCommand(id_cmd);
		for (Article a : articles){
			l.info("article +++"+a);
		}
		return articles;
	}
	@Override
	public List<Article> retrieveArticlesByFamille(FamilleArticles f1){
		List<Article> articles = (List<Article>) articlerepo.retrieveArticlesByFamille(f1);
		for (Article a : articles){
			l.info("article +++"+a);
		}
		return articles;
	}
	
	

}
