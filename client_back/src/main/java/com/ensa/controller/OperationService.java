package com.ensa.controller;

import com.ensa.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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

	@RequestMapping(value="/operation/virement",method= RequestMethod.POST)
	 public boolean virement(@RequestBody Operation operation) {
		restTemplate.postForObject(url+"/operation/virement", operation, Operation.class);
		return true;
	}

	@RequestMapping(value="/operation/recharge/{codeRecharge}",method= RequestMethod.POST)
	 public boolean recharge(@RequestBody Operation operation, @PathVariable Long codeRecharge) {
		System.out.println("Recharge : "+operation.toString());
		restTemplate.postForObject(url+"/operation/recharge/"+codeRecharge, operation, Operation.class);
		return true;
	}

	@RequestMapping(value="/operation/listOperation/{id}",method= RequestMethod.GET)
	public List<Operation> getList(@PathVariable Long id, HttpServletRequest req){
		ResponseEntity<List<Operation>> response = restTemplate.exchange(
				url+"/operation/listOperation/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<List<Operation>>() {}
		);
		List<Operation> list = response.getBody();
	return  list;
	}



}
