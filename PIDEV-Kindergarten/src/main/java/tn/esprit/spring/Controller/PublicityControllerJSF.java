package tn.esprit.spring.Controller;




import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.chartistjsf.model.chart.PieChartModel;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.Repository.PubLikeRepository;
import tn.esprit.spring.Repository.PublicityRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.PubLikeService;
import tn.esprit.spring.Services.PubVuService;
import tn.esprit.spring.Services.PublicityServiceImpl;
import tn.esprit.spring.Services.RatingService;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.LikePub;
import tn.esprit.spring.entity.PubVu;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.User;


@Scope(value = "session")
@Controller(value ="PublicityController")
@ELBeanName(value = "PublicityController")
@Join(path = "/", to = "/PubAffich.jsf")
public class PublicityControllerJSF {
	@Autowired
	PublicityServiceImpl publicityService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	PubLikeService publikeservice;
	@Autowired
	RatingService ratingservice;
	@Autowired
	PubVuService pubVuService;
	@Autowired
    private PubLikeRepository PubLikeRepository;
	@Autowired
	private JardinRepository jardinRepository;
	
	
	

	@Autowired
	private PublicityRepository publicityRepository;
	
	@Autowired
	PubLikeService pubLikeService;
	
	
	private List<Publicity> publicities;
	private String productName;
	private String marque;
	private String category;
	private float priceSponsoring;
	private byte[] image;
	
	private String productNameEdit;
	private String marqueEdit;
	private String categoryEdit;
	private float priceSponsoringEdit;
	private Publicity publicity;
	private UploadedFile file;
	private StreamedContent productImage;
	
	
	private float note;
	private String review;
	
	private PieChartModel pieModel2;
    private PieChartModel pieChartModel;

	
	  public PieChartModel getPieModel2() {
	        return pieModel2;
	    }

	private int pubIdToBeUpdated;
	
	
	/*public void setProductImage(StreamedContent productImage) {
		this.productImage = productImage;
	}*/
	
	/*public String addPub() {
		System.out.println("manel");
		publicityService.addPublicity(new Publicity (productName, category, marque , priceSponsoring ));
		return "/PubAffich.xhtml?faces-redirect=true";
		
		}*/
	
	public StreamedContent getProductImage() throws IOException, SQLException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}

		else {

		

			byte[] image = new PublicityServiceImpl().findImage(1);
            productImage = new  DefaultStreamedContent(new ByteArrayInputStream(image));
			return productImage;

		}
	

		
	
	}


	public void setProductImage(StreamedContent productImage) {
		this.productImage = productImage;
	}


	public String addPub() throws IOException {
		
	
		User us=userRepository.findUserByUsername(HomeController.connectedUser);
		Publicity p = new Publicity();
		p.setUser(us);
		p.setCategory(category);
		p.setMarque(marque);
		p.setProductName(productName);
		p.setPriceSponsoring(priceSponsoring);
		
		File file = new File("src/main/resources/image/test.png");
		
		byte[] picInBytes = new byte[(int) file.length()];
		
		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(picInBytes);
		fileInputStream.close();
		
		p.setImage(picInBytes);
		
		
		
		publicityService.addPublicity(p);
		
		return "/PubAffich.xhtml?faces-redirect=true";
		
		}
	

	public List<Publicity> getPublicities() {
		return publicities;
	}

	

	public PublicityControllerJSF() {
		super();
	}


	
	
	
	

	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public float getPriceSponsoring() {
		return priceSponsoring;
	}



	public void setPriceSponsoring(float priceSponsoring) {
		this.priceSponsoring = priceSponsoring;
	}



	public String getProductNameEdit() {
		return productNameEdit;
	}


	public void setProductNameEdit(String productNameEdit) {
		this.productNameEdit = productNameEdit;
	}


	public String getMarqueEdit() {
		return marqueEdit;
	}


	public void setMarqueEdit(String marqueEdit) {
		this.marqueEdit = marqueEdit;
	}


	public String getCategoryEdit() {
		return categoryEdit;
	}


	public void setCategoryEdit(String categoryEdit) {
		this.categoryEdit = categoryEdit;
	}


	public float getPriceSponsoringEdit() {
		return priceSponsoringEdit;
	}


	public void setPriceSponsoringEdit(float priceSponsoringEdit) {
		this.priceSponsoringEdit = priceSponsoringEdit;
	}


	


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public int getPubIdToBeUpdated() {
		return pubIdToBeUpdated;
	}
	
	


	


	public void setPubIdToBeUpdated(int pubIdToBeUpdated) {
		this.pubIdToBeUpdated = pubIdToBeUpdated;
	}


	public float getNote() {
		return note;
	}


	public void setNote(float note) {
		this.note = note;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public Publicity getPublicity() {
		return publicity;
	}


	public void setPublicity(Publicity publicity) {
		this.publicity = publicity;
	}
	
	


	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}


	public void setPieChartModel(PieChartModel pieChartModel) {
		this.pieChartModel = pieChartModel;
	}


	public void removePublicity(int id) {
		publicityService.deletePublicity(id);
	}
	

	

	public PublicityServiceImpl getPublicityService() {
		return publicityService;
	}


	public void setPublicityService(PublicityServiceImpl publicityService) {
		this.publicityService = publicityService;
	}


	public void setPublicities(List<Publicity> publicities) {
		this.publicities = listPublicities();
	}
	
	public String goForm() {
	
		return "/addpub.xhtml?faces-redirect=true";
		}
	
	public String goEditForm() {
		
		return "/editpub.xhtml?faces-redirect=true";
		}
	
	public String displayPub(Publicity p)
	{
		
	this.setProductNameEdit(p.getProductName());
	this.setCategoryEdit(p.getCategory());
	this.setMarqueEdit(p.getMarque());
	this.setPriceSponsoringEdit(p.getPriceSponsoring());
	this.setPubIdToBeUpdated(p.getId());
		
		return "/editpub.xhtml?faces-redirect=true";
	}
	//redirection vers details Front
	public String displayPubFront(Publicity p)
	{
		
	this.setProductNameEdit(p.getProductName());
	this.setCategoryEdit(p.getCategory());
	this.setMarqueEdit(p.getMarque());
	this.setPriceSponsoringEdit(p.getPriceSponsoring());
	this.setPubIdToBeUpdated(p.getId());
		
		return "/detailsPub.xhtml?faces-redirect=true";
	}
	
	public String updatePub() 
	{ 
		
		publicityService.addPublicity(new Publicity (pubIdToBeUpdated, productNameEdit, categoryEdit, marqueEdit , priceSponsoringEdit ));
		return "/PubAffich.xhtml?faces-redirect=true";
		}
	
	 /* public StreamedContent getProductImage() throws IOException {
	    
	    	FacesContext context = FacesContext.getCurrentInstance();

			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				return new DefaultStreamedContent();
			} else {


				// Reading image from database assuming that product image (bytes)
				// of product id I1 which is already stored in the database.

				byte[] image = null;
			
					image = new PublicityServiceImpl().findImage(1);
					return new DefaultStreamedContent(new ByteArrayInputStream(image),"image/png");
				}

			
				

			}*/
	//rating etoile replis 
	public List<Integer> stars (int pubId)
	{ 
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i<= publicityService.getRating(pubId) ; i++) 
				{
			list.add(1);
				}
		return list;
	}
	
	//rating etoile vide
	public List<Integer> starsVide (int pubId)
	{ 
		List<Integer> list = new ArrayList<Integer>();
		for (int i = (int) publicityService.getRating(pubId) ; i<= 4 ; i++) 
				{
			list.add(1);
				}
		return list;
	}
	
	//nb like
	
	public int getNbPub(int id)
	{
		return publikeservice.nbLike(id);
	
	}
	
	//affichage sponsoring
		public List<Publicity> listPublicities() {
			
			System.out.println("manel");
			return publicityService.retrieveAllPublicitiesPub();
			

	}
		//affichage categorie
		public List<Publicity> listPublicities2(long id) {
			User us=userRepository.findUserByUsername(HomeController.connectedUser);
			id = us.getId();
			return publicityService.retrieveAllPublicities(id);

		}
		//recuperer l'id du user co
		public long getUserCo()
		{ 
			User us=userRepository.findUserByUsername(HomeController.connectedUser);
			return us.getId();
		}
		
		//like
		
		public void addlike(int  idad){
			
			
			User us=userRepository.findUserByUsername(HomeController.connectedUser);
			
			Publicity pub = publicityRepository.findById(idad).get();
			
			LikePub lp=new LikePub();
			lp.setUser(us);
			lp.setPublicity(pub);
			//v.setDateCreation(new Date());
			lp.setEtat(true);
			
				pubLikeService.addLike(us.getId(), idad, lp);
             }
		
		//nb review par pub
		
		public int getNbReview(int id)
		{
			return ratingservice.nbReview(id);
		
		}
		//list reviews par pub
	public List<Rating> listReviwes(int id) {
			
			System.out.println("manel");
			return ratingservice.retrieveAllReviews(id);
			

	}
	
	//redirection vers details et add nb vu
	public String addvu(Long  iduser,int  idad, Publicity p){
		
		Optional<User> user=userRepository.findById(iduser);
		
		
		Publicity pub = publicityRepository.findById(idad).get();
		
		PubVu pv=new PubVu();
		pv.setUser(user.get());
		pv.setPublicity(pub);
		//v.setDateCreation(new Date());
		//lp.setEtat(etat);
		
		pubVuService.addVu(iduser, idad,pv);
		
		this.setProductNameEdit(p.getProductName());
		this.setCategoryEdit(p.getCategory());
		this.setMarqueEdit(p.getMarque());
		this.setPriceSponsoringEdit(p.getPriceSponsoring());
		this.setPubIdToBeUpdated(p.getId());
		this.setPublicity(p);
			
			return "/detailsPub.xhtml?faces-redirect=true";

			
			
	}
	
	// nb vu par pub
  
       public int getNbVu(int id)
       
	{
		return pubVuService.nbVu(id);
	
	}
	// add rating and review
    
   	public String addRating(int  idad)  {
   	
 
   		
   		User us=userRepository.findUserByUsername(HomeController.connectedUser);
		
		Publicity pub = publicityRepository.findById(idad).get();
		
		Rating rating=new Rating();
		
		rating.setUser(us);
		rating.setPublicity(pub);
		//v.setDateCreation(new Date());
		rating.setReview(review);
		rating.setNote(note);
		
		return ratingservice.addRating(rating);
		
	
		
		}

	public void removeLike(int idpub) 
	{
		User us=userRepository.findUserByUsername(HomeController.connectedUser);
		
		
		pubLikeService.deleteLike(us.getId(),idpub);
	}
	
   
    public boolean isLiked(Long iduser, int idad)
    {
    	
    	LikePub lp= new LikePub();
		lp=PubLikeRepository.likeexist(iduser, idad);
		if (lp==null)
			return false;
		else return true;
    }
    
    /*@PostConstruct
    public void init() {
     
        createPieModels();
      
    }*/

  /*  private void createPieModels() {

        createPieModel2();
       
    }*/
    
  /* public PieChartModel createPieModel2() {
        pieModel2 = new PieChartModel();
 
        pieModel2.set("Brand 1", 540);
        pieModel2.set("Brand 2", 325);
        pieModel2.set("Brand 3", 702);
        pieModel2.set("Brand 4", 421);
 
        pieModel2.setTitle("Custom Pie");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        pieModel2.setShadow(false);
        return pieModel2;
    }*/
   
	
	/*public PieChartModel createPieModels()
	{
		
		pieModel2 = new PieChartModel();
	
		List<Jardin> jardin = jardinRepository.findAll();
		for ( Jardin j : jardin ) 
		{ 
			pieModel2.set(j.getNom(), j.getNombreEnfant());
		
		}
	
		return pieModel2;
	}*/
	
    public PieChartModel createPieChart() {
        pieChartModel = new PieChartModel();
        
        List<Jardin> jardin = jardinRepository.findAll();
		for ( Jardin j : jardin ) 
		{ 
			pieChartModel.addLabel(j.getNom());
			pieChartModel.set(j.getNombreEnfant());
		
		}
        pieChartModel.setShowTooltip(true);
        return pieChartModel;
    }
}