package com.ensa.e_banking.interfacesMetier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensa.e_banking.entities.Client;


public interface ClientMetier {
	
	public Client saveClient(Client c);
	//public Page<Client> getClients(int page);
	//public Page<Client> chercher(String mc,int page,int size);
	public List<Client> getClients();
	public List<Client> chercher(String mc);
    public Client upDateClient(Long id,Client c);
    public String genererPassword();
    public Client getClientById(Long id);
    public boolean deleteClient(Long id);
	
   
	

}
