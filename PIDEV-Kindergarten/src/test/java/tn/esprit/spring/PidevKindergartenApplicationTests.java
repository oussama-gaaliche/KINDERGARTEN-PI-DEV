package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
<<<<<<< HEAD

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.User;
@RunWith(SpringRunner.class)
=======
>>>>>>> branch 'master' of https://github.com/gaaliche22/KINDERGARTEN-PI-DEV.git

import tn.esprit.spring.Services.PublicityServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class PidevKindergartenApplicationTests {
<<<<<<< HEAD
	UserRepository userRepository;
=======
	
	@Autowired 
	PublicityServiceImpl ps; 
	
>>>>>>> branch 'master' of https://github.com/gaaliche22/KINDERGARTEN-PI-DEV.git
	@Test
	public void contextLoads() {
<<<<<<< HEAD
		User user=new User("oussama1","oussamas","gaaliche","123","oussama.gaaliche@gmail.com",(long) 92374131,"0","ADMIN");
		
		
		userRepository.save(user);
=======
		//Publicity p = new Publicity(); 
		ps.deletePublicity(1);
>>>>>>> branch 'master' of https://github.com/gaaliche22/KINDERGARTEN-PI-DEV.git
	}

}
