package com.ensa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ensa.dao.ClientRepository;
import com.ensa.entities.Client;

@SpringBootApplication
public class ClientAppApplication implements CommandLineRunner{
	
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder=new  BCryptPasswordEncoder();
	
	@Autowired
	ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Client client1=new Client("cliente","cliente","CC34561","bank2020@gmail.com",bCryptPasswordEncoder.encode("bank123"),"femme",new Date(),"06512388");
		clientRepository.save(client1);*/
		
	}

}