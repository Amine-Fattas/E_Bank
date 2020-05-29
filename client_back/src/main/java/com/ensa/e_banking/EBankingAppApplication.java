package com.ensa.e_banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "com.ensa.e_banking.service","com.ensa.e_banking.interfacesImpl","com.ensa.e_banking.entities",
	"com.ensa.e_banking.interfacesMetier","com.ensa.e_banking.dao"
	}) 

public class EBankingAppApplication {
	public static void main(String[] args) {
		
			SpringApplication.run(EBankingAppApplication.class, args);
		}
	}

