package com.admin;
/*
import com.admin.Repository.AdminRepository;
import com.admin.Repository.AgenceRepository;

import com.admin.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
//@EnableEurekaClient
public class DemoApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		//SpringApplication.run(Application.class, args);
		ApplicationContext ctx =SpringApplication.run(DemoApplication.class, args);
		/*AgentRepository agent=ctx.getBean(AgentRepository.class);
		AgenceRepository agence=ctx.getBean(AgenceRepository.class);
		AdminRepository adminRepository=ctx.getBean(AdminRepository.class);
		/*ClientRepository client=ctx.getBean(ClientRepository.class);
		//Agent a;
		//agent.save(a=new Agent());
    // Admin admin = new Admin((long) 101,"admin","admin","admin","admin",new BCryptPasswordEncoder().encode("admin"));
		//agent.save(new Agent(337755.44,44.4422));$(function() {
		//        $('.table #deleteButton').on('click',function (event) {
		//                event.preventDefault();
		//                console.log( "ready!" );
		//                var href=$(this).attr('href');
		//                console.log(href);
		//
		//                $('#confirmDeleteButton').attr('href',href);
		//              //  $('#deleteModal').modal();
		//
		//        });
		//});
		//agent.save(new Agent(335577.44,44.7844));

		//List<Agent> Agents = agent.findAll();
		//for(Agent A:Agents) {
			//System.out.println("1" +A.getNumContrat());
		//System.out.println("2" +A.getNumAgent());
		//}

	}

}*/


import com.admin.Repository.AdminRepository;
import com.admin.Repository.AgenceRepository;
//import com.admin.Repository.AgentRepository;
//import com.admin.Repository.ClientRepository;
import com.admin.models.Admin;
//import com.ensa.e_banking.entities.Agence;
//import com.ensa.e_banking.entities.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AdminRepository adminRepository;

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		ApplicationContext ctx =SpringApplication.run(DemoApplication.class, args);
		//AgentRepository agent=ctx.getBean(AgentRepository.class);
		AgenceRepository agence=ctx.getBean(AgenceRepository.class);
	//	ClientRepository client=ctx.getBean(ClientRepository.class);


	}


	@Override
	public void run(String... args) throws  Exception {

		//adminRepository.save(new Admin((long) 102,"Laftoumi","Fatima Ezzahra","EE456643","admin1@AFOIHebank.com",new BCryptPasswordEncoder().encode("admin")));

	//	adminRepository.save(new Admin((long)44,"hajar", bCryptPasswordEncoder.encode("hajar")));
	}
}


