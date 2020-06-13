package com.ensa.controller;

import com.ensa.e_banking.client.security.SecurityConstants;
import com.ensa.entities.Compte;
import com.ensa.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin("*")
public class OperationService {
	@Autowired
	RestTemplate restTemplate;

	private String url = "http://localhost:8081";
	HttpHeaders headers=new HttpHeaders();

	@RequestMapping(value="/operation/virement",method= RequestMethod.POST)
	@Transactional
	 public boolean virement(@RequestBody Operation operation,HttpServletRequest request) {
		Compte compteDestination = restTemplate.getForObject(url+"/compte/CC/rib/"+operation.getCompteDestination().getRib(), Compte.class);
		operation.setCompteDestination(compteDestination);
		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Operation> req = new HttpEntity<>(operation,headers);
		restTemplate.postForObject(url+"/operation/virement", req, boolean.class);
		return true;
	}

	@RequestMapping(value="/operation/recharge/{codeRecharge}",method= RequestMethod.POST)
	@Transactional
	 public boolean recharge(@RequestBody Operation operation, @PathVariable Long codeRecharge,HttpServletRequest request) {
		System.out.println("Recharge : "+operation.toString());
		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Operation> req = new HttpEntity<>(operation,headers);

		restTemplate.postForEntity(url+"/operation/recharge/"+codeRecharge, req, boolean.class);
		return true;
	}

	@RequestMapping(value="/operation/listOperation/{rib}",method= RequestMethod.GET)
	public List<Operation> getList(@PathVariable String rib, HttpServletRequest request){
		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Operation> entity = new HttpEntity<Operation>(headers);
		ResponseEntity<List<Operation>> response = restTemplate.exchange(
				url+"/operation/listOperation/"+rib, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Operation>>() {}
		);
		List<Operation> list = response.getBody();
	return  list;
	}

	/*@RequestMapping(value="/operation/chercheO",method=RequestMethod.GET)
	public List<Operation> rechercheOperation(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="rib",defaultValue="") String rib,HttpServletRequest request){
		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Operation> entity = new HttpEntity<Operation>(headers);

		ResponseEntity<List<Operation>> response = restTemplate.exchange(
				url+"/operation/chercheO?mc="+mc+"&rib="+rib, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Operation>>() {}
		);
		System.out.println(url+"/operation/chercheO?mc="+mc+"&rib="+rib);
		List<Operation> list = response.getBody();
		return  list;
	}
*/
	@RequestMapping(method=RequestMethod.GET, value="/operation/cherche/{mc}/{rib}")
	public List<Operation> chercheOperation (@PathVariable(name = "mc") String mc, @PathVariable(name = "rib") String rib,HttpServletRequest request){
		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Operation> entity = new HttpEntity<>(headers);

		ResponseEntity<List<Operation>> response = restTemplate.exchange(
				url+"/operation/chercheO/"+mc+"/"+rib, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Operation>>() {}
		);

		List<Operation> list = response.getBody();
		return  list;
	}



}
