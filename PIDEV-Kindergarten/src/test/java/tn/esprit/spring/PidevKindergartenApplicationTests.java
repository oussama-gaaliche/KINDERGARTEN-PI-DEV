package tn.esprit.spring;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.Services.ArticleServiceImpl;
import tn.esprit.spring.Services.PublicityServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PidevKindergartenApplicationTests {

	@Autowired 
	PublicityServiceImpl ps; 
	@Autowired 

	ArticleServiceImpl as;

	@Test
	public void contextLoads() throws ParseException {

		as.retrieveAllArticles();
		
		
		

	}

}
