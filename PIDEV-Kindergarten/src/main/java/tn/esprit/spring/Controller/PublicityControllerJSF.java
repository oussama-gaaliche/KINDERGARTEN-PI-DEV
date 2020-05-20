package tn.esprit.spring.Controller;




import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.Repository.PublicityRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.PubLikeService;
import tn.esprit.spring.Services.PublicityServiceImpl;
import tn.esprit.spring.Services.RatingService;
import tn.esprit.spring.entity.LikePub;
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
	private UploadedFile file;
	private StreamedContent productImage;
	
	
	
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
		
		//nb review par user
		
		public int getNbReview(int id)
		{
			return ratingservice.nbReview(id);
		
		}
	public List<Rating> listReviwes(int id) {
			
			System.out.println("manel");
			return ratingservice.retrieveAllReviews(id);
			

	}
		
	
}