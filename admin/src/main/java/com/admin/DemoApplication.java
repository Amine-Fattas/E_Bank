package com.admin;

import com.admin.Repository.AgenceRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
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
		/*AgentRepository agent=ctx.getBean(AgentRepository.class);*/
		AgenceRepository agence=ctx.getBean(AgenceRepository.class);
		/*ClientRepository client=ctx.getBean(ClientRepository.class);*/
		//Agent a;
		//agent.save(a=new Agent());

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

}
