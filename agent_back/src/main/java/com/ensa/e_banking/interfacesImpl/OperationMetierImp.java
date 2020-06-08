package com.ensa.e_banking.interfacesImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.e_banking.dao.AgentRepository;
import com.ensa.e_banking.dao.CompteRepository;
import com.ensa.e_banking.dao.OperationRepository;
import com.ensa.e_banking.dao.RechargeRepository;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.entities.Operation;
import com.ensa.e_banking.entities.Recharge;
import com.ensa.e_banking.interfacesMetier.OperationMetier;
@Service
public class OperationMetierImp implements OperationMetier{

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private RechargeRepository rechargeRepository;
	
	
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
		
		public boolean verser(Operation operation) {
			Compte compteDestination = compteRepository.findCompteByRib(operation.getCompteDestination().getRib());
			if(compteDestination ==null || compteDestination.isEtat() == false)  throw new RuntimeException("Compte n'existe pas ou désactivé");
			operation.setCompteDestination(compteDestination);
			
			compteDestination.setSolde(compteDestination.getSolde()+operation.getMontant());
			operationRepository.save(operation);
		    
			
			return true;
		}
		


		@Override
		public boolean virement(Operation operation) {
	 	System.out.println(operation.toString());
			Compte compteSource=compteRepository.findById(operation.getCompteSource().getNumCompte()).orElse(null);
			if(compteSource == null || compteSource.isEtat() == false) throw new RuntimeException("Compte n'existe pas");
			
			
			if(compteSource.getSolde() < operation.getMontant())  throw new RuntimeException("Solde insuffisant");
//			Compte compteDestination = compteRepository.findById(operation.getCompteDestination().getNumCompte()).get();
			Compte compteDestination = compteRepository.findCompteByRib(operation.getCompteDestination().getRib());
			if(compteDestination ==null || compteDestination.isEtat() == false)  throw new RuntimeException("Compte n'existe pas ou désactivé");
			operation.setCompteDestination(compteDestination);
			
			
			compteSource.setSolde(compteSource.getSolde()-operation.getMontant());
		    compteDestination.setSolde(compteDestination.getSolde()+operation.getMontant());
			operationRepository.save(operation);
		    
		    
		    return true;
		}
		
		@Override
		public boolean recharge(Operation operation, Long codeRecharge) {
			
			Recharge recharge = rechargeRepository.findById(codeRecharge).orElse(null);
			if(recharge == null ) throw new RuntimeException("Code recharge Invalide"); 
			
			operation.setMontant(operation.getMontant()+recharge.getValeur());
			
			Compte compte=compteRepository.findById(operation.getCompteDestination().getNumCompte()).get();
			if(compte==null || compte.isEtat() == false)  throw new RuntimeException("Compte n'existe pas");
			
			compte.setSolde(compte.getSolde()+operation.getMontant());
			operationRepository.save(operation);
		    
			
			return true;
		}



	@Override
	public double fraisVirement(double montant) {
		double taux=1/100;
		return taux*montant;
	}


	@Override
	public List<Operation> getOperationByIdClient(Long id) {
		return operationRepository.findOperationByIdClient(id);
	}


	@Override
	public List<Operation> getOperations() {
		return operationRepository.findAll();
	}


	

}
