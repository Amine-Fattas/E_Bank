package com.ensa.e_banking.interfacesImpl;

import com.ensa.e_banking.dao.RechargeRepository;
import com.ensa.e_banking.entities.Recharge;
import com.ensa.e_banking.interfacesMetier.RechargeMetier;

public class RechargeMetierImpl implements RechargeMetier{

	RechargeRepository rechargeRepository;
	
	@Override
	public Recharge getRecharge(Long codeRecharge) {
		return rechargeRepository.findById(codeRecharge).get();
	}
	

}
