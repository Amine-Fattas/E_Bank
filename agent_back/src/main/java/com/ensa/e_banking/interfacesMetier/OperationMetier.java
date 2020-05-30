package com.ensa.e_banking.interfacesMetier;

import java.util.List;
import com.ensa.e_banking.entities.Operation;

public interface OperationMetier {
	   
       public boolean verser(Operation operation);
       public boolean retirer(Operation operation);
       //public getReleverBancainre
       public boolean virement(Operation operation);
       public double fraisVirement(double montant);
       public List<Operation> getOperationById(Long id);
       public List<Operation> getOperations();

}
