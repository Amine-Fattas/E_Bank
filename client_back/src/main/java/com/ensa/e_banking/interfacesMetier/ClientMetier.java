package com.ensa.e_banking.interfacesMetier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensa.e_banking.entities.Client;


public interface ClientMetier {
	
	public Client saveClient(Client c);
	public List<Client> getClients();
	public Page<Client> chercher(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size
			);
    public Client upDateClient(Long id,Client c);
    public String genererPassword();
    public Client getClientById(Long id);
    public boolean deleteClient(Long id);
	

}
