package tn.esprit.spring.Controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Permission;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.view.ViewScoped;
import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;

import org.apache.myfaces.util.FilenameUtils;
import org.apache.tomcat.util.security.PermissionCheck;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.PieChartModel;
import tn.esprit.spring.Repository.LikePlatRepository;
import tn.esprit.spring.Repository.PlatRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Services.IngredientService;
import tn.esprit.spring.Services.IngredientServiceImpl;
import tn.esprit.spring.Services.IngretientPlatService;
import tn.esprit.spring.Services.LikePlatServiceImpl;
import tn.esprit.spring.Services.PlatService;
import tn.esprit.spring.Services.PlatServiceImpl;

import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.LikePlat;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.TypePlat;
import tn.esprit.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;










@Scope(value = "session")
@Controller(value ="plaController")
@ELBeanName(value = "plaController")
@Join(path = "/", to = "testPlat.jsf")
@MultipartConfig

@RequestScoped

public class PlatControllerJSF  {
	@Autowired
	PlatServiceImpl platservice;
	@Autowired
    LikePlatServiceImpl likeplat;
	@Autowired 
	PlatRepository platrepo;
	@Autowired 
	UserRepository userrepo;
	@Autowired
    LikePlatRepository likerepo;
	@Autowired
	IngretientPlatService ingpservice;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	private LikePlat likep;
	private Part  cinf;
	


	







public Part getCinf() {
		return cinf;
	}
	public void setCinf(Part cinf) {
		this.cinf = cinf;
	}
public LikePlat getLikep() {
		return likep;
	}
	public void setLikep(LikePlat likep) {
		this.likep = likep;
	}
public List<Plat> getPlats() {
	return plats;
}



private String image;
private MultipartFile file;
	
	


public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}



public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}



private int id_Plat;

	public int getId_Plat() {
	return id_Plat;
}
public void setId_Plat(int id_Plat) {
	this.id_Plat = id_Plat;
}
	private List<Plat> plats;
	private TypePlat typeplat;
	

	private String nom;
	private double prix;
	private String noming;
	

	
	
	
	public String getNoming() {
		return noming;
	}
	public void setNoming(String noming) {
		this.noming = noming;
	}
	public List<Plat> getAllPlats() {
		return plats;
	}
	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}
	public StreamedContent getPlatImage() {
		return platImage;
	}
	public void setPlatImage(StreamedContent platImage) {
		this.platImage = platImage;
	}
	
	

	
	private StreamedContent platImage;
	public TypePlat[] gettypeplats(){
	 return TypePlat.values(); }
	public TypePlat getTypeplat() {
		return typeplat;
	}
	
	public void setTypeplat(TypePlat typeplat) {
		this.typeplat = typeplat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
/*	public StreamedContent getplatImage() throws IOException, SQLException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}

		else {

			byte[] image =new PlatServiceImpl().findImage(1);
            platImage = new  DefaultStreamedContent(new ByteArrayInputStream(image));
			return platImage;

		}}
public byte[] uploadToDB(MultipartFile file) throws IOException {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String fileBasePath = "C:/Work/sts_bundle/Pi-Spring/src/main/webapp/files/myImage/";
	
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path(fileBasePath)
				.path(fileName)
				.toUriString();
		return file.getBytes() ;
	}*/
private Part uploadedFile;
	
	public Part getUploadedFile() {
	return uploadedFile;
}
public void setUploadedFile(Part uploadedFile) {
	this.uploadedFile = uploadedFile;
}
	public void addPlat() throws Exception {
		cinf.write("C:\\Work\\sts_bundle\\Pi-Spring\\src\\main\\webapp\\resources\\image\\"+cinf.getSubmittedFileName());        
	    File oldFile=new File("C:\\Work\\sts_bundle\\Pi-Spring\\src\\main\\webapp\\resources\\image\\"+cinf.getSubmittedFileName());
	    String img= platservice.getAlphaNumericString(7)+cinf.getSubmittedFileName();
	    File newfile =new File("C:\\Work\\sts_bundle\\Pi-Spring\\src\\main\\webapp\\resources\\image\\"+img);
	    oldFile.renameTo(newfile);
		Plat p=new Plat();
		
			p.setNom(nom);
			p.setPrix(prix);
			p.setTypeplat(typeplat);
			//byte[] picInBytes = new byte[(int) uploadedFile.getSize()];
		//p.setImage(img);
			platservice.AddPlat(p);
			
	        
		//p.setNom(nom);
		//p.setPrix(prix);
		
		//String Path="C:/Work/sts_bundle/Pi-Spring/src/main/webapp/files/myImage/";
	//	p.setTypeplat(typeplat);
		//BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream("C:/Work/sts_bundle/Pi-Spring/src/main/webapp/files/myImage/"));
		//File file = new File(Path);
		//file.canRead();
		//file.canExecute();
		//byte[] picInBytes = new byte[(int) file.length()];
		
	//FileInputStream fileInputStream = new FileInputStream(file);
	//	fileInputStream.read(picInBytes);
		//fileInputStream.close();
		
		//p.setImage(picInBytes);
	
		/*String fileName = StringUtils.cleanPath(file.getSubmittedFileName());
		String fileBasePath ="C:/Work/sts_bundle/Pi-Spring/src/main/webapp/files/myImage/"+fileName; 
		byte[] picInBytes = new byte[(int) file.getSize()];
		p.setImage(picInBytes);
			platservice.AddPlat(p);
		
	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path(fileBasePath)
				.path(fileName)
				.toUriString();*/
		}
	public List<Plat> listPlats() {
		
		System.out.println("takwa");
		return platservice.AllPlats();
		

}
	
	//Affichage de tous les plats.
	public List<Plat> getallPlats() {
		plats = platservice.AllPlats();
		return plats;
		} 
	
	public void removePlat(int id)
	{
		platservice.DeletePlat(id);	}
	private UploadedFile file1;
	
	public void upload() throws IOException{
		
	         /*  try {  
	                String fileName = FilenameUtils.getName(file1.getFileName());  
	                System.out.println(FilenameUtils.getExtension(fileName));  
	                System.out.println(file1.getFileName());  
	                String contentType = FacesContext.getCurrentInstance()  
	                          .getExternalContext().getMimeType(fileName);  
	                byte[] bytes = file1.getContents();  
	                Plat p= new Plat();  
	                p.setNom(nom);
	    			p.setPrix(prix);
	    			p.setTypeplat(typeplat);
	               p.setImage(bytes);
	               
	               platservice.AddPlat(p) ; 
	               // employeeBean.AddImgtoEmployee(SelectedEmployee, img);  
	             /*   displayInfoMessageToUser(String.format(  
	                          "File '%s' of type '%s' successfully uploaded!", fileName,  
	                          contentType));  */
	         /*  } catch (Exception e) {  
	        	   System.out.println("File upload failed with error.");  
	                // Always log stacktraces (with a real logger).  
	                e.printStackTrace();  
	           }  */
	}
			
		
		
		
	public UploadedFile getFile1() {
		return file1;
	}
	private Plat p;
	public void setFile1(UploadedFile file1) {
		this.file1 = file1;
	}
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PieChartModel getPieModel1() {
		return pieModel1;
	}
	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}
	public void Like(int id){
		System.out.println("takwa" +id);
		long iduser=1;
		long o=1;
		//User u=new User(4,"username","hello","takwa.chnab@gmail.com",Role.PARENT);
		User u=userrepo.findById(iduser).get();
		System.out.println(u);
		//User u= userrepo.findUserByUsername(HomeController.connectedUser);
		//int us=4;
		
		Plat pp = platrepo.findById(id).get();
		System.out.println("takwa" +pp);
		
		//System.out.println(id);
		LikePlat lp=new LikePlat();
		lp.setPlat(pp);
		lp.setEtat(true);
		lp.setUser(u);
		//likerepo.save(lp);
		likeplat.addLike(iduser,id,lp);
		
		
	
		
		
	}
	 
    public void onReturnFromLevel1(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("success"));
    }
	public Plat getP() {
		return p;
	}
	public void setP(Plat p) {
		this.p = p;
	}
	
	public String Gottodetail(int pid) {
		System.out.println("test");
		String navigateTo ="DetailPlat.xhtml?faces-redirect=true";
		List <Ingredient> ing = ingpservice.AllIngredientByPlat(pid);
		for (Ingredient i:ing){
			noming=i.getNom();
			System.out.println(noming);
			}
		Plat pp = platrepo.findById(pid).get();
		this.setId_Plat(pp.getId_plat());
		System.out.println(pp.getId_plat());
    	this.setNom(pp.getNom());
    	System.out.println(pp.getNom());
		this.setPrix(pp.getPrix());
		System.out.println(pp.getPrix());
		this.setTypeplat(pp.getTypeplat());
		System.out.println(pp.getTypeplat());
		
		
		
return navigateTo;
		
		
	}
	public List<Ingredient> listing(int id){
		 return ingpservice.AllIngredientByPlat(id);
		
	}
	public int getNbFavories(int id)
	{ System.out.println("takwa");
		
		return likeplat.nbLike(id);
	
	}
	private PieChartModel pieModel1;
	  public  void createPieModel1() {
		 List<Plat> pp=new ArrayList<>();
		  System.out.println("test");
	        pieModel1 = new PieChartModel();
	       //pp= likeplat.Platjm();
	       for(Plat p:pp){
	     
	    	   pieModel1.set(p.getNom(),1);
	       
	    	   
	    	   //pieModel1.set(pp.toString(), 1);
	       
	        
	 
	  
	        pieModel1.setTitle("Simple Pie");
	        pieModel1.setLegendPosition("w");
	        pieModel1.setShadow(false);}
	    }
	
	
	  public void addpllp(){
			Plat p=new Plat();
			p.setNom(nom);
			System.out.println("test1"+nom);
			p.setPrix(prix);
			System.out.println("test2"+prix);
			p.setTypeplat(typeplat);
			System.out.println("test3"+typeplat);
			
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			image=fileName;
			System.out.println("test4" +image);
			String fileBasePath = "C:/Work/sts_bundle/Pi-Spring/src/main/webapp/files/myImage/"+image;
		//	p.setImage(image);
			System.out.println("test5"+fileName);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path(fileBasePath)
					.path(fileName)
					.toUriString();
			System.out.println("test6"+fileDownloadUri);
			platservice.AddPlat(p);
			System.out.println("testfinal");
			
		  
	  }
	  public void AddRepas(){
		  
		  
		  
	  }
	  public List<Plat> ListFvaoris(){
			List<Plat> pl=new ArrayList<>();
			int id=1;
			pl=likerepo.listfavoris(id);
			return pl;
			
			
			
		}
	  public void RemoveFavoris(int idp){
		int idl=  likerepo.idlikep(1,idp);
		likerepo.deleteById(idl);
	  }
	  private byte[] img;
	  public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public void  afficheimage(int id){
		  List<Plat> all=new ArrayList<>();
		  all=platservice.AllPlats();
		  for(Plat p:all){
			 img=platrepo.GETImage(p.getId_plat());
			
			  
			  
		  }
		  
	  }
	public List<Plat> PopularPlats(){
		List<Plat> p=new ArrayList<>();
		List<Plat> pl=new ArrayList<>();
		p=likerepo.Platplopulaire();
		for(Plat u:p){
			pl.add(u);
			
		}
		return pl;
		
		
	}
	public String GoAlplat(){
		return "/PlatFront.xhtml?faces-redirect=true";
	}
	public String viewmyfavourites(){
		return "/ListFavoris.xhtml?faces-redirect=true";
		
	}
	public String GoSpecial(){
		return "/platspecial.xhtml?faces-redirect=true";
		
	}
	public String GoNormal(){
		return "/platnormal.xhtml?faces-redirect=true";
		
	}
	public String GoAcceuil(){
		return "/AcceuilResto.xhtml?faces-redirect=true";
		
	}
	public String GoBackPlat(){
		return "/AffichagePlat.xhtml?faces-redirect=true";
		
	}
	public int ToBeUpdated;
	public int getToBeUpdated() {
		return ToBeUpdated;
	}
	public void setToBeUpdated(int toBeUpdated) {
		ToBeUpdated = toBeUpdated;
	}
	public String displayPlat(Plat p)
	{ this.setNom(p.getNom());
	this.setPrix(p.getPrix());
	this.setTypeplat(p.getTypeplat());
	this.setToBeUpdated(p.getId_plat());
	
	return "/editPlat.xhtml?faces-redirect=true";
	}
	public String UpdatePlat(){
		platservice.AddPlat(new Plat(ToBeUpdated,typeplat, nom,  prix));
		return "/AffichagePlat.xhtml?faces-redirect=true";
		
	}


}
