package com.ensa.e_banking.client.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ensa.dao.ClientRepository;
import com.ensa.entities.Client;
@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("load");
		Client client = clientRepository.findByUsername(username);
		if(client==null) throw new UsernameNotFoundException(username);
System.out.println(client.toString());
		return new User(client.getUsername(),client.getPassword(),new ArrayList<>());
	}

}
