package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Repository.ArticleRepository;
import tn.esprit.spring.Repository.CommandeRepository;
import tn.esprit.spring.Repository.CouponRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Repository.VillesRepository;
import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.CommandePk;
import tn.esprit.spring.entity.Coupon;
import tn.esprit.spring.entity.EtatCommande;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VillesLivraison;

@Service
@Transactional
public class CommandeServiceImpl implements ICommandeService {
	@Autowired
	CommandeRepository cr;
	@Autowired
	CouponRepository couponr;
	@Autowired
	UserRepository ur;
	@Autowired
	VillesRepository vr;
	@Autowired
	ArticleRepository ar;
	@Autowired
	ArticleServiceImpl as;
	@Override
	public int addCommand(Commande c) {
		cr.save(c);
		return 1;
	}
	
	private static final Logger l=LogManager.getLogger(CommandeServiceImpl.class);
	@Override
	public List<Commande> retrieveAllCommands(){
		List<Commande> commandes = (List<Commande>) cr.findAll();
		for (Commande c : commandes){
			l.info("commande +++"+c);
		}
		return commandes;
	}
	
	/*@Override
	public Commande updateCommand(Commande c) {
		cr.save(c);
		 return c; 
	}
	
	@Override
	public void deleteCommand(int id) {
		cr.deleteById((long) id);		
	} */
	
	/*@Override
	public void addToPanier(Commande c,Article a){
		c.setEtat_cmd(EtatCommande.EnAttente);
		
		cr.addToPanier(c.getEtat_cmd(), c.getMontant_ht(), c.getMontant_ttc(), c.getQte_cmd(), c.getTotal_tva(),a);
		 
	}*/
	/*@Override
	public void command(Commande c){
		//cr.updateCommandeById(EtatCommande.Validee, c.getId());
		//List<Article> list=as.retrieveArticlesByCommand(c.getId());
		for (Article a : list){
			ar.updateArticleQteById(c.getQte_cmd(),a.getId_article());
		}
		
	}  */
	public void ajouterCommande(Long idArticle,int qte){
		Date date=new Date();
		Optional<Article> article= ar.findById(idArticle);
		User user = ur.findById(2L).get();
		CommandePk commandepk = new CommandePk();
		commandepk.setArticleid(idArticle);
		commandepk.setUserid(2L);
		commandepk.setEtat_cmd(EtatCommande.EnAttente);
		Commande commande = new Commande();
		commande.setCommandepk(commandepk);
		commande.setQte_cmd(qte);
		commande.setMontant_ht(article.get().getVenteHT()*qte);
		commande.setMontant_ttc(article.get().getVenteTTC()*qte);
		commande.setDate_cmd(date);
		commande.setTotal_tva(as.calculTva(article.get())*qte);
		article.get().setQteStock(article.get().getQteStock()-qte);
		cr.save(commande);
	}
	public List<Commande> retrieveCommandById(Long idu){
		List<Commande> commandes = (List<Commande>) cr.retrieveCommandById(EtatCommande.EnAttente, idu);
		return commandes;
		
	}
	public double calculLivraison(String ville) {
		List<VillesLivraison> villes=vr.findAll();
		double livraison=0;
		for(VillesLivraison v:villes)
		{if(v.getVille().equals(ville))
		    {
			if(v.getDistance()<=100)
		    	livraison=5;
		    else if(v.getDistance()>100 & v.getDistance()<=200 )
		    	livraison=6;
		    else if(v.getDistance()>200 & v.getDistance()<=300 )
		    	livraison=7;
		    else if(v.getDistance()>300 & v.getDistance()<=400 )
		    	livraison=8;
		    else if(v.getDistance()>400 & v.getDistance()<=500 )
		    	livraison=9;
		    else if(v.getDistance()>500 & v.getDistance()<=600 )
		    	livraison=10;
		    }
		}
		return livraison;
	}
	
	public void deleteCommande(Long idArticle){
		User user = ur.findById(2L).get();
		Commande c = cr.retrieveCommandByIds(idArticle, user.getId(),EtatCommande.EnAttente);
		Optional<Article> article = ar.findById(idArticle);
		article.get().setQteStock(article.get().getQteStock()+c.getQte_cmd());

		cr.deleteCommandeByPk(idArticle, user.getId(),EtatCommande.EnAttente);
	}
	 public List<Coupon> retrieveAllCoupons(){
		 List<Coupon> coupons=couponr.findAll();
		return coupons;
		 
	 	}
	 public double verifierCodePromo(String entry,double totalttc){
			List<Coupon> coupons=retrieveAllCoupons();
			double promo=0;
			for(Coupon c: coupons){
				if(entry==null){
					break;
				}
				else if(entry.contains(c.getCode())){
					promo=c.getPromo();}
			}
			return promo;
			
			}
		
	
	
}
