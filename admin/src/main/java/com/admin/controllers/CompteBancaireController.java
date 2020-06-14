package com.admin.controllers;



import com.admin.models.CompteBancaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;


@Controller
public class CompteBancaireController {


    private String url = "http://localhost:8081";
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/comptebancaireactive")
    public String list(Model model,String mc) {


        List<CompteBancaire> list = null;
        if(mc != null && mc !="") {
            ResponseEntity<List<CompteBancaire>> response = restTemplate.exchange(
                    url + "/agent/chercherA/" + mc, HttpMethod.GET, null, new ParameterizedTypeReference<List<CompteBancaire>>() {
                    }
            );
            list = response.getBody();
        }
        else{
            ResponseEntity<List<CompteBancaire>> response = restTemplate.exchange(
                    url + "/agent/listCompteActive", HttpMethod.GET, null, new ParameterizedTypeReference<List<CompteBancaire>>() {
                    }
            );
            list = response.getBody();
        }
       model.addAttribute("comptes",list);

        return "CompteBancaire/ComptesBancaires";
    }


    @RequestMapping(value="/comptebancairedesavtive")
    public String listD(Model model,String mc) {

        List<CompteBancaire> list = null;
        if(mc != null && mc !="") {
            ResponseEntity<List<CompteBancaire>> response = restTemplate.exchange(
                    url + "/agent/chercherD/" + mc, HttpMethod.GET, null, new ParameterizedTypeReference<List<CompteBancaire>>() {
                    }
            );
            list = response.getBody();
        }
        else{
            ResponseEntity<List<CompteBancaire>> response = restTemplate.exchange(
                    url + "/agent/listCompteDesactive", HttpMethod.GET, null, new ParameterizedTypeReference<List<CompteBancaire>>() {
                    }
            );
            list = response.getBody();
        }

        model.addAttribute("comptes",list);
        return "CompteBancaire/ComptesBancairesD";
    }









}
