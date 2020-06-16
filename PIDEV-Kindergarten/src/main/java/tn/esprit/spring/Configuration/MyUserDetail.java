package tn.esprit.spring.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




import tn.esprit.spring.entity.User;

public class MyUserDetail implements UserDetails {
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	public MyUserDetail (User user)
	 {
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.active=user.isActive();
		this.authorities=Arrays.stream(user.getRoles().toString().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	 }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return active;
	}


}
