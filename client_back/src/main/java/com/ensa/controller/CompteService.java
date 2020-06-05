package com.ensa.controller;

import com.ensa.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@CrossOrigin(value = "*",allowedHeaders = "*")
public class CompteService {
	

	@Autowired
	RestTemplate restTemplate;

//	@Autowired
//	private test test;
	private String url = "http://localhost:8081";

	@RequestMapping(value="/compte/CC/client/{id}",method=RequestMethod.GET)
	public Compte getCompteByIdClient(@PathVariable Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Compte compte =  restTemplate.getForObject(url+"/compte/CC/client/"+id, Compte.class);
		return compte;
	}
	

}
