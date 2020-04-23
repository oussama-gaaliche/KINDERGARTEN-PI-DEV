package tn.esprit.spring.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
	
	@GetMapping("/")
	
	public String home(){
		
		return("Welcome");
	}
@GetMapping("/parent")
	
	public String homeUser()
	{
	return ("welcome Parents");
	}
	
	@GetMapping("/admin")
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	public String homeAdmin()
	{
	return ("welcome Admin");
	}
	@GetMapping("/responsable")
	
	public String homeResponsable()
	{
	return ("welcome to your KinderGarten");
	}
@GetMapping("/enseignant")
	
	public String homeEnsignant()
	{
	return ("welcome Ensignant");
	}
	

}
