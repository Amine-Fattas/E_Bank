package com.admin.controllers;


import com.admin.models.Agent;
import com.admin.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Controller
public class ClientController {
    @Autowired
    RestTemplate restTemplate;

    private String url = "http://localhost:8082";

        @RequestMapping(value="/clients")
        public String list(Model model,String mc) {

            List<Client> list = null;
            if(mc != null && mc !="") {
                ResponseEntity<List<Client>> response = restTemplate.exchange(
                        url + "/client/recherche/" + mc, HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {
                        }
                );
                list = response.getBody();
            }
            else{
                ResponseEntity<List<Client>> response = restTemplate.exchange(
                        url + "/client/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {
                        }
                );
                list = response.getBody();
            }

            model.addAttribute("listeClients",list);
            return "Client/clients";
        }

}

