
package tn.esprit.spring.Configuration;
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import tn.esprit.spring.Controller.HomeController;
import tn.esprit.spring.Services.UserService;
@Component
public class Securityhandler implements AuthenticationSuccessHandler {
	@Autowired 
	UserService userservice;
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ADMIN")) {
        	HomeController.connectedUser=userservice.userconnect();
            response.sendRedirect("/AllUser.jsf");
        }
        if (roles.contains("PARENT")) {
        	HomeController.connectedUser=userservice.userconnect();
            response.sendRedirect("/AllUser.jsf");
        }
        if (roles.contains("RESPONSABLE")) {
        	HomeController.connectedUser=userservice.userconnect();
            response.sendRedirect("/AllUser.jsf");
        }
        if (roles.contains("ENSEIGNANT")) {
        	HomeController.connectedUser=userservice.userconnect();
            response.sendRedirect("/AllUser.jsf");
        }
    }
}
