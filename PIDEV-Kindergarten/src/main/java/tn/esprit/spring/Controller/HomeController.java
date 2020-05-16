package tn.esprit.spring.Controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Services.UserService;

@RestController
@RequestMapping("")
public class HomeController {
	@Autowired 
	UserService userservice;
	public static  String connectedUser="";
	static  Long connectedUserId;
	@GetMapping("/")
	
	
	public String home(){
		
		connectedUser=userservice.userconnect();
		System.out.println(connectedUser);
		
		return("Welcome");
	}

	
@GetMapping("/parent")
	
	public String homeUser()
	{
	connectedUser=userservice.userconnect();
	System.out.println(connectedUser);
	return ("welcome Parents");
	}
	
	@GetMapping("/admin")
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	public String homeAdmin()
	{
		connectedUser=userservice.userconnect();
		System.out.println(connectedUser);
		
	return ("welcome Admin");
	}
	@GetMapping("/responsable")
	
	public String homeResponsable()
	{
		connectedUser=userservice.userconnect();
		System.out.println(connectedUser);
	return ("welcome to your KinderGarten");
	}
@GetMapping("/enseignant")
	
	public String homeEnsignant()
	{
	connectedUser=userservice.userconnect();
	System.out.println(connectedUser);
	return ("welcome Ensignant");
	}
	

}


