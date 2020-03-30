package tn.esprit.spring.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Configuration.MyUserDetail;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entity.User;



@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("Not found :" + username));
		return user.map(MyUserDetail::new).get();
	}
	
	

}