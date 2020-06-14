package com.ensa.controller;

import com.ensa.e_banking.client.security.SecurityConstants;
import com.ensa.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;



@RestController
@CrossOrigin(value = "*",allowedHeaders = "*")
public class CompteService {
	

	@Autowired
	RestTemplate restTemplate;

	HttpHeaders headers=new HttpHeaders();

	private String url = "http://localhost:8081";

	@RequestMapping(value="/compte/CC/client/{id}",method=RequestMethod.GET)
	public Compte getCompteByIdClient(@PathVariable Long id, HttpServletRequest request) {
		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Compte> entity = new HttpEntity<Compte>(headers);
		ResponseEntity<Compte> response = restTemplate.exchange(
				url+"/compte/CC/client/"+id, HttpMethod.GET, entity,Compte.class
		);
		Compte compte = response.getBody();
		return compte;
	}

	@RequestMapping(value="/compte/CC/rib/{rib}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String rib,HttpServletRequest request) {
		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Compte> entity = new HttpEntity<Compte>(headers);

		ResponseEntity<Compte> response = restTemplate.exchange(
				url+"/compte/CC/rib/"+rib, HttpMethod.GET, entity,Compte.class
		);
		Compte compte = response.getBody();
		return compte;
	}
	

}
