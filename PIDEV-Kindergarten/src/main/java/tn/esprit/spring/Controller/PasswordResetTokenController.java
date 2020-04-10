package tn.esprit.spring.Controller;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tn.esprit.spring.Repository.PasswordTokenRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.GenericResponse;
import tn.esprit.spring.entity.PasswordResetToken;
import tn.esprit.spring.entity.User;

public class PasswordResetTokenController {
//	@Autowired
//	PasswordTokenRepository passwordTokenRepository;
//	
//	@Autowired
//	UserRepository userRepository;
//	public void createPasswordResetTokenForUser(User user, String token) {
//	    PasswordResetToken myToken = new PasswordResetToken(token, user);
//	    passwordTokenRepository.save(myToken);
//	}
//	private SimpleMailMessage constructResetTokenEmail(
//			  String contextPath, Locale locale, String token, User user) {
//			    String url = contextPath + "/user/changePassword?id=" + 
//			      user.getId() + "&token=" + token;
//			    String message = messages.getMessage("message.resetPassword", 
//			      null, locale);
//			    return constructEmail("Reset Password", message + " \r\n" + url, user);
//			}
//			 
//			private SimpleMailMessage constructEmail(String subject, String body, 
//			  User user) {
//			    SimpleMailMessage email = new SimpleMailMessage();
//			    email.setSubject(subject);
//			    email.setText(body);
//			    email.setTo(user.getEmail());
//			    email.setFrom("fffff");
//			    return email;
//			}
//	@PostMapping("/user/resetPassword/{mail}")
//	public GenericResponse resetPassword(HttpServletRequest request, 
//	  @RequestParam("email") String userEmail) {
//	    User user = userRepository.findByEmail(userEmail);
//	    if (user == null) {
//	        throw new UserNotFoundException();
//	    }
//	    String token = UUID.randomUUID().toString();
//	    createPasswordResetTokenForUser(user, token);
//	    token.send(constructResetTokenEmail("fd", 
//	      request.getLocale(), token, user));
//	    return new GenericResponse(
//	      messages.getMessage("message.resetPasswordEmail", null, 
//	      request.getLocale()));
//	}
//	

}
