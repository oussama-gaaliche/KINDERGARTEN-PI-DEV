package tn.esprit.spring.Controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.JardinRepository;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.User;

@RestController
public class JardinController {
	@Autowired
	JardinRepository jardinRepository;
	
	
	
	@PostMapping("/addJardin")
	public String addUser(@RequestBody Jardin jardin){
//		String connectedUser;
//		connectedUser = authentication.getUsername;
//		jardin.setUser(user);
		jardinRepository.save(jardin);
		return " added user succes";
	}

}
