package com.ensa.e_banking.interfacesImpl;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensa.e_banking.dao.ClientRepository;
import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.interfacesMetier.ClientMetier;

@Service
public class ClientMetierImp implements ClientMetier{
    
	@Autowired
	private ClientRepository clientRepository;
	
	 final String letterLower = "abcdefghijklmnopqrstuvwxyz";
     final String letterUpper= letterLower.toUpperCase();
     final String number = "0123456789";
     final String caractereSpeciaux = "!@#$%&*_?";
     final String passworwdCombinaison= letterLower+ letterUpper + number + caractereSpeciaux;
     
	
	@Override
	public Client saveClient(Client c) {
		
		List<Client> clientList=clientRepository.findAll();
		
		for(Client client : clientList) {
			
			if(c.getCin()==client.getCin()) {
				return c;
			}
		}
		System.out.println("sav-3");
		return clientRepository.save(c);
	}

	/*@Override
	public Page<Client> getClients(int page) {
		return clientRepository.findAll(PageRequest.of(page, 7));
	}

	@Override
	public Page<Client> chercher(String mc, int page,int size) {
		return clientRepository.chercher("%"+mc+"%",PageRequest.of(page,size,Sort.by("nom")) );
	}*/

	@Override
	public Client upDateClient(Long id,Client c) {
		Client client=clientRepository.findById(id).get();
		if(id==client.getId()) {
		c.setId(id);
		}
		return clientRepository.save(c);
		
	}
	
	@Override
	public String genererPassword() {
		
		   List<String> letters = Arrays.asList(caractereSpeciaux.split(""));
           Collections.shuffle(letters);
		     
		     SecureRandom random = new SecureRandom();
		     String password="";
		    
		     password+=letterLower.charAt(random.nextInt(letterLower.length()));
		     password+=letterUpper.charAt(random.nextInt(letterUpper.length()));
		     password+=number.charAt(random.nextInt(number.length()));
             password+=caractereSpeciaux.charAt(random.nextInt(caractereSpeciaux.length()));
		     for(int i=0;i<4;i++) {
		    	 password+=passworwdCombinaison.charAt(random.nextInt(passworwdCombinaison.length()));
		     }
		
		return password;
	}

	@Override
	public Client getClientById(Long id) {
		return clientRepository.findById(id).get();
		
	}

	@Override
	public boolean deleteClient(Long id) {
		clientRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Client> getClients() {
		
		return clientRepository.findAll();
	}

	@Override
	public List<Client> chercher(String mc) {
		
		return clientRepository.chercher("%"+mc+"%");
	}
	
	

	

}

