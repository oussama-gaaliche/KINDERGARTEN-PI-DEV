package tn.esprit.spring.Controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Repository.ArticleRepository;
import tn.esprit.spring.Repository.CommandeRepository;
import tn.esprit.spring.Repository.FactureRepository;
import tn.esprit.spring.Repository.NotifRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Repository.VillesRepository;
import tn.esprit.spring.Services.ArticleServiceImpl;
import tn.esprit.spring.Services.CommandeServiceImpl;
import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.EtatArticle;
import tn.esprit.spring.entity.EtatCommande;
import tn.esprit.spring.entity.EtatNotif;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.FamilleArticles;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.TypePaiement;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VillesLivraison;

@Scope(value = "session")
@Controller(value = "CommandeJsfController")
@ELBeanName(value = "CommandeJsfController")
@Join(path = "/homevente", to = "/HomeVente.jsf")
//@Join(path = "/panier", to = "/Panier.jsf")
public class CommandeJsfController {
	@Autowired
	ArticleServiceImpl as;
	@Autowired
	CommandeServiceImpl cs;
	@Autowired
	VillesRepository vr;
	@Autowired
	FactureRepository fr;
	@Autowired
	CommandeRepository cr;
	@Autowired
	ArticleRepository ar;
	@Autowired
	UserRepository ur;
	@Autowired
	NotifRepository nr;
	private List<Article> listarticles ;
	private List<Article> listArticlesFamille;
	private Long id_article;
	private FamilleArticles famille;
	private String desc;
	private EtatArticle etat;
	private double remise;
	private double venteTTC;
	private String nom;
	private int qteStock;
	private String image;
	private String reference;
	private List<Article> listePanier;
	private int quantite_cmd;
	private List<Commande> commandespanier;
	private Long id_user=2L;
	private double totalttc;
	private double totalht;
	private String entry ;
	private double promo;
	private double livraison;
	private String ville; 
	private List<VillesLivraison> listvilles;
	private double ordertotal=0;
	private String usernom;
	private String userprenom;
	private Long tel;
	private String email;
	private String adresse;
	private TypePaiement paiement;
	private Long idfacture;
	private double montantfacture;
	private Long codepostal;
	private String mess;
	

	
	
	
	public List<Article> getListarticles() {
		listarticles = as.retrieveAllArticlesByStock() ;
		return listarticles;
	}
	
	
	public List<VillesLivraison> getListvilles() {
		listvilles=vr.findAll();
		return listvilles;
	}


	public void setListvilles(List<VillesLivraison> listvilles) {
		this.listvilles = listvilles;
	}


	public List<Article> getListArticlesFamille() {
		listArticlesFamille = as.retrieveArticlesByFamille(famille);
		return listArticlesFamille;
	}

	public boolean verifierListe(){
		if (as.retrieveAllArticlesByStock().size()==0)
			return false;
		else return true;
	}
	public void setListArticlesFamille(List<Article> listArticlesFamille) {
		this.listArticlesFamille = listArticlesFamille;
	}
	
	
    public List<Commande> getCommandespanier() {
		commandespanier = cs.retrieveCommandById( id_user);

		return commandespanier;
	}
	
	
    public double getTotalttc() { 
		List<Commande> panier = cs.retrieveCommandById(id_user);
		totalttc=0;
		for(Commande p: panier ){
			totalttc=totalttc+p.getMontant_ttc();
		}
		BigDecimal bd = new BigDecimal(totalttc);
		bd= bd.setScale(3,BigDecimal.ROUND_DOWN);
		totalttc = bd.doubleValue();
		return totalttc;
	}

    public void promoo(){
    	List<Commande> panier = cs.retrieveCommandById(id_user);
		totalttc=0;
		for(Commande p: panier ){
			totalttc=totalttc+p.getMontant_ttc();
		}
		promo=cs.verifierCodePromo(entry,totalttc);
		
		
    }


	public void setTotalttc(double totalttc) {
		this.totalttc = totalttc;
	}


	public double getTotalht() {
		return totalht;
	}


	public void setTotalht(double totalht) {
		this.totalht = totalht;
	}


	public void setCommandespanier(List<Commande> commandespanier) {
		this.commandespanier = commandespanier;
	}

	public void deleteCommande(Long idarticle){
		cs.deleteCommande(idarticle);
	}
	public String detailArticle(Article a){
		String navigateTo ="null";
		this.setDesc(a.getDescription());
		this.setEtat(a.getEtat());
		this.setImage(a.getImage());  
		this.setNom(a.getNom());
		this.setRemise(a.getRemise());
		this.setReference(a.getReference());
		this.setId_article(a.getId_article());
		this.setVenteTTC(a.getVenteTTC());
		this.setFamille(a.getFamille());
		navigateTo = "/ArticleDetail.xhtml?faces-redirect=true";
		
		return navigateTo;
	}
	//ajout au panier en verifiant la quantitée commandée
	public String ajouterAuPanier(){
		String navigateTo ="null";
		Optional<Article> a=ar.findById(id_article);
		
		if(a.get().getQteStock()>quantite_cmd)
		cs.ajouterCommande(id_article,quantite_cmd);
		else{ 
		cs.ajouterCommande(id_article,a.get().getQteStock());
		
		}
		navigateTo = "/Paniers.xhtml?faces-redirect=true";
		return navigateTo;
	}
	public String passerFacture(){
		String navigateTo ="null";
		Date d=new Date();
		Facture f=new Facture();
		
		montantfacture=ordertotal+0.6;
		BigDecimal bd = new BigDecimal(montantfacture);
		bd= bd.setScale(3,BigDecimal.ROUND_DOWN);
		montantfacture = bd.doubleValue();
		f.setMontant(ordertotal+f.getTimbre_fiscal());
		fr.save(f);
		f.setNum_fact(d.getYear()+"-"+d.getMonth()+"-"+d.getDay()+f.getId().toString());
		fr.save(f);
		setIdfacture(f.getId());
		
		Optional<User> u=ur.findById(id_user);
		this.setEmail(u.get().getEmail());
		this.setUsernom(u.get().getNom());
		this.setUserprenom(u.get().getPrenom());
		this.setTel(u.get().getNumtel());
		navigateTo = "/checkout.xhtml?faces-redirect=true";
		return navigateTo;
	}
	public String retourAcheter(){
		String navigateTo ="null";
		navigateTo = "/HomeVente.xhtml?faces-redirect=true";
		return navigateTo;
	}
	public String retourPanier(){
		String navigateTo ="null";
		navigateTo = "/paniers.xhtml?faces-redirect=true";
		return navigateTo;
	}
	public String validercommande(){
		String navigateTo ="null";
		Date d=new Date();
		Optional<User> u=ur.findById(id_user);

		Notification n=new Notification();
		Optional<Facture> f=fr.findById(idfacture);
		for(Commande c:commandespanier){
			c.setFacture(f.get());
			c.getCommandepk().setEtat_cmd(EtatCommande.EnPreparation);
			System.out.println("im here"+paiement);
			cr.save(c);
			cs.deleteCommande(c.getCommandepk().getArticleid());
			as.controleStock(c.getArticle_commande());
		}	
		n.setDate_notif(d);
		n.setEtat(EtatNotif.enAttente);
		n.setMessage("le client "+u.get().getNom()+" "+u.get().getPrenom()+" a creé une nouvelle commande avec un N° de facture= "+f.get().getNum_fact()+". Veuillez preparer cette commande et l'expedier à:"+ville);
		nr.save(n);
		setMess("Mme/Mr "+u.get().getNom()+" "+u.get().getPrenom()+" votre commande est validée avec succés sous un numero de facture = "+f.get().getNum_fact()+" nous sommes en cours de la preparer, vous recevrerez une information dés que la commande passe à l'expedition, merci.");
		navigateTo = "/validationfacture.xhtml?faces-redirect=true";

		return navigateTo;
	}
	
	public String annulercommande(){
		String navigateTo ="null";

		for(Commande c:commandespanier){
			
			cs.deleteCommande(c.getArticle_commande().getId_article());
			as.controleStock(c.getArticle_commande());
		}
		navigateTo = "/HomeVente.xhtml?faces-redirect=true";

		return navigateTo;

	}
	
	
	public FamilleArticles[] getFamilleArticles(){
		return FamilleArticles.values();
	}
	
	public FamilleArticles getFamille() {
		return famille;
	}
	
	
	public List<Article> articlesParFamille() {
		
		return listArticlesFamille;
	}


	public int getQuantite_cmd() {
		return quantite_cmd;
	}


	public void setQuantite_cmd(int quantite_cmd) {
		this.quantite_cmd = quantite_cmd;
	}


	public void setFamille(FamilleArticles famille) {
		this.famille = famille;
	}


	public void setListarticles(List<Article> listarticles) {
		this.listarticles = listarticles;
	}
	

	public String getEntry() {
		return entry;
	}


	public void setEntry(String entry) {
		this.entry = entry;
	}


	public Long getId_article() {
		return id_article;
	}

	public void setId_article(Long id_article) {
		this.id_article = id_article;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public EtatArticle getEtat() {
		return etat;
	}
	


	public void setEtat(EtatArticle etat) {
		this.etat = etat;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getVenteTTC() {
		return venteTTC;
	}

	public void setVenteTTC(double venteTTC) {
		this.venteTTC = venteTTC;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public List<Article> getListePanier() {
		return listePanier;
	}


	public void setListePanier(List<Article> listePanier) {
		this.listePanier = listePanier;
	}


	public double getPromo() {
		return promo;
	}


	public void setPromo(double promo) {
		this.promo = promo;
	}


	public double getLivraison() {
		

		return livraison;
	}

	public void calculLivraison(){
		if (totalttc > 2000)
			livraison = 0;
		else {
			if (ville == null)
				livraison = 0;
			else
				livraison = cs.calculLivraison(ville);
		}
		
	}

	public String getVille() {
		
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
		
	}


	public void setLivraison(double livraison) {
		this.livraison = livraison;
	}

	public double getOrdertotal() {
		ordertotal=livraison-promo+totalttc;
		BigDecimal bd = new BigDecimal(ordertotal);
		bd= bd.setScale(3,BigDecimal.ROUND_DOWN);
		ordertotal = bd.doubleValue();
		return ordertotal;
	}


	public void setOrdertotal(double ordertotal) {
		this.ordertotal = ordertotal;
	}

	public String getUsernom() {
		return usernom;
	}

	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}

	public String getUserprenom() {
		return userprenom;
	}

	public void setUserprenom(String userprenom) {
		this.userprenom = userprenom;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public TypePaiement[] getTypePaiement(){
		return TypePaiement.values();
	}
	
	public TypePaiement getPaiement() {
		return paiement;
	}


	public void setPaiement(TypePaiement paiement) {
		this.paiement = paiement;
	}


	public Long getIdfacture() {
		return idfacture;
	}


	public void setIdfacture(Long idfacture) {
		this.idfacture = idfacture;
	}


	public double getMontantfacture() {
		return montantfacture;
	}


	public void setMontantfacture(double montantfacture) {
		this.montantfacture = montantfacture;
	}


	public String getMess() {
		return mess;
	}


	public void setMess(String mess) {
		this.mess = mess;
	}

	

	
}
