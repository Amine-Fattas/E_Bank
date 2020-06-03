package com.ensa.e_banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ensa.e_banking.dao.AgentRepository;
import com.ensa.e_banking.entities.Agence;
import com.ensa.e_banking.entities.Agent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@ComponentScan({ "com.ensa.e_banking.service","com.ensa.e_banking.interfacesImpl","com.ensa.e_banking.entities",
	"com.ensa.e_banking.interfacesMetier","com.ensa.e_banking.dao","com.ensa.e_banking.security",
	"com.ensa.e_banking.config"
	})
@EnableEurekaClient
public class EBankingAppApplication implements CommandLineRunner {
	@Autowired
	AgentRepository agentRepository;
	
	
	
	public static void main(String[] args) {
	
			SpringApplication.run(EBankingAppApplication.class, args);
			 
		}
	@Autowired
   BCryptPasswordEncoder bCryptPasswordEncoder=new  BCryptPasswordEncoder();

	@Override
	public void run(String... args) throws Exception {
	Agent agent1=new Agent((long) 1,"ikram","makhloufi","EC5681","ikram",bCryptPasswordEncoder.encode("ikram123"),new Agence(1));
	agentRepository.save(agent1);
	Agent agent2=new Agent((long) 2,"nouam","makhloufi","EC5641","noua",bCryptPasswordEncoder.encode("noua123"),new Agence(1));
	agentRepository.save(agent2);
		
	}
	
	

	}

