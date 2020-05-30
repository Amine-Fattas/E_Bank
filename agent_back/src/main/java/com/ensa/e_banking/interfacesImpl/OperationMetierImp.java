package com.ensa.e_banking.interfacesImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.e_banking.dao.AgentRepository;
import com.ensa.e_banking.dao.CompteRepository;
import com.ensa.e_banking.dao.OperationRepository;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.entities.Operation;

import com.ensa.e_banking.interfacesMetier.OperationMetier;
@Service
public class OperationMetierImp implements OperationMetier{

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private AgentRepository agentRepository;
	
	
	 @Override
		@Transactional
		public boolean retirer(Operation operation) {
		 
			Compte compte=compteRepository.findById(operation.getCompteSource().getNumCompte()).orElse(null);
			if(compte == null || compte.isEtat() == false) throw new RuntimeException("Compte n'existe pas");
			
			if(compte.getSolde() < operation.getMontant())  throw new RuntimeException("Solde insuffisant");
			
			compte.setSolde(compte.getSolde()-operation.getMontant());
			operationRepository.save(operation);
		    
			
			return true;		
		}
	 

		@Override
		@Transactional
		public boolean verser(Operation operation) {
			Compte compte=compteRepository.findById(operation.getCompteDestination().getNumCompte()).get();
			if(compte==null || compte.isEtat() == false)  throw new RuntimeException("Compte n'existe pas");
			
			compte.setSolde(compte.getSolde()+operation.getMontant());
			operationRepository.save(operation);
		    
			
			return true;
		}
		


		@Override
		public boolean virement(Operation operation) {
			Compte compteSource =compteRepository.findById(operation.getCompteSource().getNumCompte()).orElse(null);
			if(compteSource == null || compteSource.isEtat() == false) throw new RuntimeException("Compte n'existe pas ou désactivé");
			
			Compte compteDestination = compteRepository.findById(operation.getCompteDestination().getNumCompte()).get();
			if(compteDestination ==null || compteDestination.isEtat() == false)  throw new RuntimeException("Compte n'existe pas ou désactivé");
			
			if(compteSource.getSolde() < operation.getMontant())  throw new RuntimeException("Solde insuffisant");
			
			compteSource.setSolde(compteSource.getSolde()-operation.getMontant());
		    compteDestination.setSolde(compteDestination.getSolde()+operation.getMontant());
			operationRepository.save(operation);
		    
		    
		    return true;
		}
		



	@Override
	public double fraisVirement(double montant) {
		double taux=1/100;
		return taux*montant;
	}


	@Override
	public List<Operation> getOperationById(Long id) {
		return operationRepository.findOperation(id);
	}


	@Override
	public List<Operation> getOperations() {
		return operationRepository.findAll();
	}


	

}
