package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"tn.esprit.spring.Services","tn.esprit.spring.Controller","tn.esprit.spring.Configuration"})
@EntityScan("tn.esprit.spring.entity")
@EnableJpaRepositories("tn.esprit.spring.Repository")
public class PidevKindergartenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PidevKindergartenApplication.class, args);
	}

}
