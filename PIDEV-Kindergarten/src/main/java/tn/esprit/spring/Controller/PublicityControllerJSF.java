package tn.esprit.spring.Controller;

import java.io.ByteArrayInputStream;
import java.io.File;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

import org.chartistjsf.model.chart.PieChartModel;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;

import tn.esprit.spring.Repository.PubLikeRepository;
import tn.esprit.spring.Repository.PublicityRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.PubLikeService;
import tn.esprit.spring.Services.PubVuService;
import tn.esprit.spring.Services.PublicityServiceImpl;
import tn.esprit.spring.Services.RatingService;
import tn.esprit.spring.entity.LikePub;
import tn.esprit.spring.entity.PubVu;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.User;

@Scope(value = "session")
@Controller(value = "PublicityController")
@ELBeanName(value = "PublicityController")
@Join(path = "/", to = "/PubAffich.jsf")
@MultipartConfig
@WebServlet
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
	private PublicityRepository publicityRepository;

	@Autowired
	PubLikeService pubLikeService;

	private List<Publicity> publicities;
	private int id;
	private String productName;
	private String marque;
	private String category;
	private float priceSponsoring;
	private String image;

	private String productNameEdit;
	private String marqueEdit;
	private String categoryEdit;
	private float priceSponsoringEdit;
	private String imageEdit;
	private Publicity publicity;
	// private StreamedContent productImage;

	private float note;
	private String review;

	private PieChartModel pieModel2;
	private PieChartModel pieChartModel;

	private Integer rating;

	private boolean pub_exist = false;

	

	private String folder = "c:\\files";

	private Part productImage;

	private String msg = "";

	private boolean all_reviews = false;

	private boolean champs = false;
	
	

	public Part getProductImage() {
		return productImage;
	}

	public void setProductImage(Part productImage) {
		this.productImage = productImage;
	}

	public boolean isChamps() {
		return champs;
	}

	public void setChamps(boolean champs) {
		this.champs = champs;
	}

	public boolean isAll_reviews() {
		return all_reviews;
	}

	public void setAll_reviews(boolean all_reviews) {
		this.all_reviews = all_reviews;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isPub_exist() {
		return pub_exist;
	}

	public void setPub_exist(boolean pub_exist) {
		this.pub_exist = pub_exist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	private int pubIdToBeUpdated;

	/*
	 * public String addPub() throws IOException, ParseException {
	 * 
	 * 
	 * if ( this.productName.equals("") ) { this.champs = true; return
	 * "/addpub.xhtml?faces-redirect=true";
	 * 
	 * } else { this.champs = false; User us =
	 * userRepository.findUserByUsername(HomeController.connectedUser);
	 * 
	 * publicityService.addPublicity(new Publicity(productName, marque,
	 * category, priceSponsoring, us));
	 * 
	 * 
	 * return "/PubAffich.xhtml?faces-redirect=true"; }
	 * 
	 * }
	 */

	public List<Publicity> getPublicities() {
		return publicities;
	}

	public String getImageEdit() {
		return imageEdit;
	}

	public void setImageEdit(String imageEdit) {
		this.imageEdit = imageEdit;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
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

	public String displayPub(Publicity p) {

		this.setProductNameEdit(p.getProductName());
		this.setCategoryEdit(p.getCategory());
		this.setMarqueEdit(p.getMarque());
		this.setPriceSponsoringEdit(p.getPriceSponsoring());
		this.setPubIdToBeUpdated(p.getId());

		return "/editpub.xhtml?faces-redirect=true";
	}

	// redirection vers details Front
	public String displayPubFront(Publicity p) {

		this.setProductNameEdit(p.getProductName());
		this.setCategoryEdit(p.getCategory());
		this.setMarqueEdit(p.getMarque());
		this.setPriceSponsoringEdit(p.getPriceSponsoring());
		this.setPubIdToBeUpdated(p.getId());

		return "/detailsPub.xhtml?faces-redirect=true";
	}

	public String updatePub() {

		publicityService.addPublicity(
				new Publicity(pubIdToBeUpdated, productNameEdit, categoryEdit, marqueEdit, priceSponsoringEdit));
		return "/PubAffich.xhtml?faces-redirect=true";
	}

	/*
	 * public StreamedContent getProductImage() throws IOException {
	 * 
	 * FacesContext context = FacesContext.getCurrentInstance();
	 * 
	 * if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) { return new
	 * DefaultStreamedContent(); } else {
	 * 
	 * 
	 * // Reading image from database assuming that product image (bytes) // of
	 * product id I1 which is already stored in the database.
	 * 
	 * byte[] image = null;
	 * 
	 * image = new PublicityServiceImpl().findImage(1); return new
	 * DefaultStreamedContent(new ByteArrayInputStream(image),"image/png"); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	// rating etoile replis
	public List<Integer> stars(int pubId) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= publicityService.getRating(pubId); i++) {
			list.add(1);
		}
		return list;
	}

	// rating etoile vide
	public List<Integer> starsVide(int pubId) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = (int) publicityService.getRating(pubId); i <= 4; i++) {
			list.add(1);
		}
		return list;
	}

	// nb like

	public int getNbPub(int id) {
		return publikeservice.nbLike(id);

	}

	// affichage sponsoring
	public List<Publicity> listPublicities() {

		System.out.println("manel");
		return publicityService.retrieveAllPublicitiesPub();

	}

	// affichage categorie
	public List<Publicity> listPublicities2(long id) {
		User us = userRepository.findUserByUsername(HomeController.connectedUser);
		id = us.getId();
		return publicityService.retrieveAllPublicities(id);

	}

	// recuperer l'id du user co
	public long getUserCo() {
		User us = userRepository.findUserByUsername(HomeController.connectedUser);
		return us.getId();
	}

	// like

	public void addlike(int idad) {

		User us = userRepository.findUserByUsername(HomeController.connectedUser);

		Publicity pub = publicityRepository.findById(idad).get();

		LikePub lp = new LikePub();
		lp.setUser(us);
		lp.setPublicity(pub);
		// v.setDateCreation(new Date());
		lp.setEtat(true);

		pubLikeService.addLike(us.getId(), idad, lp);
	}

	// nb review par pub

	public int getNbReview(int id) {
		return ratingservice.nbReview(id);

	}

	// redirection vers details et add nb vu
	public String addvu(Long iduser, int idad, Publicity p) {

		Optional<User> user = userRepository.findById(iduser);

		Publicity pub = publicityRepository.findById(idad).get();

		PubVu pv = new PubVu();
		pv.setUser(user.get());
		pv.setPublicity(pub);
		// v.setDateCreation(new Date());
		// lp.setEtat(etat);

		pubVuService.addVu(iduser, idad, pv);

		this.setProductNameEdit(p.getProductName());
		this.setCategoryEdit(p.getCategory());
		this.setMarqueEdit(p.getMarque());
		this.setPriceSponsoringEdit(p.getPriceSponsoring());
		this.setImageEdit(p.getImage());
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
	
	

	public String addRating(int idad) {

		User us = userRepository.findUserByUsername(HomeController.connectedUser);

		Publicity pub = publicityRepository.findById(idad).get();

		Rating rating1 = new Rating();

		rating1.setUser(us);
		rating1.setPublicity(pub);
		// v.setDateCreation(new Date());
		rating1.setReview(review);
		rating1.setNote(rating);

		return ratingservice.addRating(rating1);
	}

	public void removeLike(int idpub) {
		User us = userRepository.findUserByUsername(HomeController.connectedUser);

		pubLikeService.deleteLike(us.getId(), idpub);
	}

	public boolean isLiked(Long iduser, int idad) {

		LikePub lp = new LikePub();
		lp = PubLikeRepository.likeexist(iduser, idad);
		if (lp == null)
			return false;
		else
			return true;
	}

	public void pubExists() {

		System.out.println(this.productName);

		List<Publicity> publicity = new ArrayList<Publicity>();
		publicity = publicityRepository.findAll();

		for (Publicity pub : publicity) {
			if (pub.getProductName().equals(this.productName))

			{
				this.pub_exist = true;
				return;
			}

		}
		this.pub_exist = false;
	}

	public void champVide() {
		if (this.productName.equals(null) || this.marque.equals(null) || this.marque.equals(null))

			this.champs = true;
		else
			this.champs = false;
	}

	// affichage avec recherche
	public List<Publicity> getAllPub() {

		if (this.msg.length() == 0)
			return publicityService.retrieveAllPublicitiesPub();
		else
			return publicityService.searchPub(msg);
	}

	// list reviews par pub
	public List<Rating> listReviwes(int id) {
		if (all_reviews == false) {
			System.out.println("sa7louba");
			return ratingservice.listLastReviews(id);

		}

		else
			return ratingservice.retrieveAllReviews(id);

	}

	// load more reviews
	public void loadReviews() {

		this.all_reviews = true;

	}

	public String addPub() throws IOException, ParseException {

		// C:\Users\manel\git\KINDERGARTEN-PI-DEV\PIDEV-Kindergarten\src\main\webapp\img

		

		if (this.productName.equals("")) {
			this.champs = true;
			return "/addpub.xhtml?faces-redirect=true";

		} else {
			this.champs = false;

			User us = userRepository.findUserByUsername(HomeController.connectedUser);

			publicityService.addPublicity(new Publicity(productName, marque, category, priceSponsoring, us));

			return "/PubAffich.xhtml?faces-redirect=true";
		}

	}
	public String addimage()
	{ 
	String navigateTo = "null";
	System.out.println(productImage.getSubmittedFileName());
	try {
		productImage.write("C:\\Users\\manel\\git\\KINDERGARTEN-PI-DEV\\PIDEV-Kindergarten\\src\\main\\webapp\\img\\"+productImage.getSubmittedFileName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("mzamra");
	}        
    File oldFile=new File("C:\\Users\\manel\\git\\KINDERGARTEN-PI-DEV\\PIDEV-Kindergarten\\src\\main\\webapp\\img\\"+productImage.getSubmittedFileName());
    String img= publicityService.getAlphaNumericString(7)+productImage.getSubmittedFileName();
    System.out.println(img);
    File newfile =new File("C:\\Users\\manel\\git\\KINDERGARTEN-PI-DEV\\PIDEV-Kindergarten\\src\\main\\webapp\\img\\"+img);
    oldFile.renameTo(newfile);
		System.out.println("ka3boufiboura mmm");
		User us = userRepository.findUserByUsername(HomeController.connectedUser);
		publicityService.addPublicity(new Publicity(productName, marque, category, priceSponsoring,img, us));
    return navigateTo ;
	}
	
	public String goStat() {

		return "/stat.xhtml?faces-redirect=true";
	}
	
	public String goPub() {

		return "/PubAffichFront.xhtml?faces-redirect=true";
	}
	
}