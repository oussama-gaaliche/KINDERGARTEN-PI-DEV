package tn.esprit.spring.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;





@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled= true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailService;
	@Autowired
	Securityhandler authenticationSuccessHandler;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailService).passwordEncoder(encodePWD());
		/*auth.inMemoryAuthentication()
		.withUser("oussama")
		.password("oussama")
		.roles("ADMIN")
		.and()
		.withUser("ahmed")
		.password("ahmed")
		.roles("PARENT");*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		//.antMatchers("/admin").hasRole("ADMIN")
		
		//.antMatchers("/parent").hasAnyRole("ADMIN","PARENT")
//		.antMatchers("/responsable").authenticated()
//		.antMatchers("/enseignant").authenticated()
//		.hasRole("PARENT")
//		.hasRole("RESPONSABLE")
//		.hasRole("ENSEIGNANT")
		.antMatchers("/").authenticated().anyRequest().permitAll().and().formLogin().successHandler(authenticationSuccessHandler);	
		
		
		 // http.sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry());
		/*http.sessionManagement()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.expiredUrl("/login?error=You are already logged in from somewhere");*/
	}
		@Bean 
	public PasswordEncoder getPasswordEncoder(){return NoOpPasswordEncoder.getInstance();}
	@Bean 
	public BCryptPasswordEncoder encodePWD(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public ActiveUserStore activeUserStore(){
	    return new ActiveUserStore();
	}
	   

//	    @Bean
//	    public SessionRegistry sessionRegistry() {
//	        return new SessionRegistryImpl();
//	    }
//
//	    @Bean
//	    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
//	        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
//	    }
	
}
