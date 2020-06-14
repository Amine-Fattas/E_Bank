package com.admin.controllers;

import com.admin.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class OperationController {
    private String url = "http://localhost:8081";

    @Autowired
    RestTemplate restTemplate;





    @RequestMapping(value="/operations")
    public String listOperation(Model model,String mc) {

        List<Operation> list = null;
        if(mc != null && mc !="") {
            ResponseEntity<List<Operation>> response = restTemplate.exchange(
                    url + "/operation/recherche/" + mc, HttpMethod.GET, null, new ParameterizedTypeReference<List<Operation>>() {
                    }
            );
            list = response.getBody();
        }
        else{
            ResponseEntity<List<Operation>> response = restTemplate.exchange(
                    url + "/operation/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Operation>>() {
                    }
            );
            list = response.getBody();
        }


        model.addAttribute("operations",list);
        return "Operation/operations";


    }

}
