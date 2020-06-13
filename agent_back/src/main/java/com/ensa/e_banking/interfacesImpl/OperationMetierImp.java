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

			Compte compte=compteRepository.findCompteByRib(operation.getCompteSource().getRib());
			if(compte == null || compte.isEtat() == false) throw new RuntimeException("Compte n'existe pas");
			
			if(compte.getSolde() < operation.getMontant())  throw new RuntimeException("Solde insuffisant");
			
			compte.setSolde(compte.getSolde()-operation.getMontant());
			operationRepository.save(operation);
		    
			
			return true;		
		}
	 

		@Override
		@Transactional
		public boolean verser(Operation operation) {
			Compte compteDestination = compteRepository.findCompteByRib(operation.getCompteDestination().getRib());
			if(compteDestination ==null || compteDestination.isEtat() == false)  throw new RuntimeException("Compte n'existe pas ou désactivé");
			operation.setCompteDestination(compteDestination);
			
			compteDestination.setSolde(compteDestination.getSolde()+operation.getMontant());
			operationRepository.save(operation);
		    
			
			return true;
		}
		

@Transactional
		@Override
		public boolean virement(Operation operation) {

			Compte compteSource=compteRepository.findCompteByRib(operation.getCompteSource().getRib());
			Compte compteDestination=compteRepository.findCompteByRib(operation.getCompteDestination().getRib());

			if(compteSource == null || compteDestination == null) throw new RuntimeException("Compte source ou destination n'existe pas");

			if(compteSource.isEtat() == false || compteDestination.isEtat()==false ) throw  new RuntimeException("Compte source ou destination désactivé");
			
			
			if(compteSource.getSolde() < operation.getMontant())  throw new RuntimeException("Solde insuffisant");

			//if(compteDestination ==null || compteDestination.isEtat() == false)  throw new RuntimeException("Compte n'existe pas ou désactivé");
			operation.setCompteDestination(compteDestination);
			operation.setCompteSource(compteSource);
			
			
			compteSource.setSolde(compteSource.getSolde()-operation.getMontant());
		    compteDestination.setSolde(compteDestination.getSolde()+operation.getMontant());
			operationRepository.save(operation);
		    
		    
		    return true;
		}

	@Override
	public List<Operation> getOperationByCompte(String mc, String rib) {
	 	System.out.println(mc);
		return operationRepository.chercherO("%"+mc+"%",rib);
	}

	@Override
		@Transactional
		public boolean recharge(Operation operation, Long codeRecharge) {
			
			Recharge recharge = rechargeRepository.findById(codeRecharge).orElse(null);
			if(recharge == null ) throw new RuntimeException("Code recharge Invalide"); 
			
			operation.setMontant(operation.getMontant()+recharge.getValeur());
			
			Compte compte=compteRepository.findCompteByRib(operation.getCompteDestination().getRib());
			//if(compte==null || compte.isEtat() == false)  throw new RuntimeException("Compte n'existe pas");
			
			compte.setSolde(compte.getSolde()+operation.getMontant());
			operationRepository.save(operation);
		    
			
			return true;
		}

	@Override
	public List<Operation> chercherOperation(String mc) {
		return operationRepository.chercherOperation("%"+mc+"%");
	}


	@Override
	public double fraisVirement(double montant) {
		double taux=1/100;
		return taux*montant;
	}


	@Override
	public List<Operation> getOperationByIdCompte(String rib) {
		return operationRepository.findOperationByIdCompte(rib);
	}


	@Override
	public List<Operation> getOperations() {
		return operationRepository.findAll();
	}


}
