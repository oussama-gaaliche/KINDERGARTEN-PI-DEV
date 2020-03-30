package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.User;
@RunWith(SpringRunner.class)

@SpringBootTest
class PidevKindergartenApplicationTests {
	UserRepository userRepository;
	@Test
	public void contextLoads() {
		User user=new User("oussama1","oussamas","gaaliche","123","oussama.gaaliche@gmail.com",(long) 92374131,"0","ADMIN");
		
		
		userRepository.save(user);
	}

}
