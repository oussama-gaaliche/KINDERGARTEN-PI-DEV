package tn.esprit.spring.Controller;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.UserRepository;

import tn.esprit.spring.entity.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
@RestController
@RequestMapping("/secure/rest")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
  private BCryptPasswordEncoder passwordEncoder;
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user){
		String pwd=user.getPassword();
		String encryptpwd= passwordEncoder.encode(pwd);
		user.setPassword(encryptpwd);
		user.setActive(false);
		userRepository.save(user);
		return " added user succes";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/edit/{id}")
	public String ValidateuserwithAdmin(@PathVariable("id") long id, Model model) {
		String a;
	    User user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    if(user.getRoles().equals("RESPONSABLE")||user.getRoles().equals("ADMIN")){
	    model.addAttribute("user", user);
	    user.setActive(true);
	    userRepository.save(user);
	    a="update-user";
	    }
	    else a="you cannot validate user that had role as "+ user.getRoles();
	    return a;
	    
	}
	//@PreAuthorize("hasRole('PARENT'")
	public String ValidateuserwithResponsable(@PathVariable("id") long id, Model model) {
		String a;
	    User user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    if(user.getRoles().equals("PARENT")||user.getRoles().equals("RESPONSABLE")){
	    model.addAttribute("user", user);
	    user.setActive(true);
	    userRepository.save(user);
	    a="update-user";
	    }
	    else a="you cannot validate user that had role as "+ user.getRoles();
	    return a;
	    
	}
}