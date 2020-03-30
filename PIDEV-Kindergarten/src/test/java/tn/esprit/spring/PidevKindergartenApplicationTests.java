package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.Services.PublicityServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class PidevKindergartenApplicationTests {

	@Autowired 
	PublicityServiceImpl ps; 
	

	@Test
	public void contextLoads() {

		
		
		
		

	}

}
