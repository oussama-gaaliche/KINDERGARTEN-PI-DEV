package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.Services.PublicityServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PidevKindergartenApplicationTests {

	@Autowired 
	PublicityServiceImpl ps; 
	

	@Test
	public void contextLoads() {

		//User u = new User( (long) 6 , "mma", "aa", new Date (2020-03-24) );
		
				//us.addUser(u);
				//us.retrieveAllUsers();
				ps.deletePublicity(1);
				//us.updateUser(u);
		
		
		

	}

}
