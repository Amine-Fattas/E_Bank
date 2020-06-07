package com.ensa.e_banking;

import com.ensa.e_banking.dao.AgentRepository;
import com.ensa.e_banking.entities.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@ComponentScan({ "com.ensa.e_banking.service","com.ensa.e_banking.interfacesImpl","com.ensa.e_banking.entities",
	"com.ensa.e_banking.interfacesMetier","com.ensa.e_banking.dao","com.ensa.e_banking.security",
	"com.ensa.e_banking.config"
	})
//@EnableEurekaClient
public class EBankingAppApplication implements CommandLineRunner {
	@Autowired
	AgentRepository agentRepository;

//	@Autowired
//	ClientRepository clientRepository;

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


	
	
	public static void main(String[] args) {
	
			SpringApplication.run(EBankingAppApplication.class, args);
			 
		}
	@Autowired
   BCryptPasswordEncoder bCryptPasswordEncoder=new  BCryptPasswordEncoder();

	@Override
	public void run(String... args) throws Exception {
		//Role de l'app agent client


	//Agent agent1=new Agent((long) 1,"ikram","makhloufi","EC5681","ikram",bCryptPasswordEncoder.encode("ikram123"),1);
//agentRepository.save(agent1);
	//Agent agent2=new Agent((long) 2,"nouam","makhloufi","EC5641","noua",bCryptPasswordEncoder.encode("noua123"),1);
	//agentRepository.save(agent2);

	/*Client client1=new Client("cliente","cliente","ED5641","client2020@gmail.com",bCryptPasswordEncoder.encode("client123"),"femme",new Date(),"06512388");
	clientRepository.save(client1);*/
		
	}
	
	

	}

