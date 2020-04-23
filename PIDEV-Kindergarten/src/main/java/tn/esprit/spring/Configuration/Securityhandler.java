package tn.esprit.spring.Configuration;
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
@Component
public class Securityhandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ADMIN")) {
            response.sendRedirect("/admin");
        }
        if (roles.contains("PARENT")) {
            response.sendRedirect("/parent");
        }
        if (roles.contains("RESPONSABLE")) {
            response.sendRedirect("/responsable");
        }
        if (roles.contains("ENSEIGNANT")) {
            response.sendRedirect("/enseignant");
        }
    }
}