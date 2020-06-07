package com.admin.controllers;



import com.admin.models.Client;
import com.admin.models.CompteBancaire;
import com.admin.models.Operation;
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
public class CompteBancaireController {



    private String url = "http://localhost:8081";
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/comptebancaireactive")
    public String list(Model model) {
        ResponseEntity<List<CompteBancaire>> response = restTemplate.exchange(
                url+"/agent/listCompteActive", HttpMethod.GET, null, new ParameterizedTypeReference<List<CompteBancaire>>() {}
        );
        List<CompteBancaire> list = response.getBody();
        model.addAttribute("comptes",list);
        return "CompteBancaire/ComptesBancaires";
    }


    @RequestMapping(value="/comptebancairedesavtive")
    public String listD(Model model) {
        ResponseEntity<List<CompteBancaire>> response = restTemplate.exchange(
                url+"/agent/listCompteDesactive", HttpMethod.GET, null, new ParameterizedTypeReference<List<CompteBancaire>>() {}
        );
        List<CompteBancaire> listD = response.getBody();
        model.addAttribute("comptes",listD);
        return "CompteBancaire/ComptesBancairesD";
    }









}
