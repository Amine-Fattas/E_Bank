package com.admin.controllers;



import com.admin.models.Client;
import com.admin.models.CompteBancaire;
import com.admin.models.Operation;
import com.admin.models.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Controller
public class CompteBancaireController {



    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 1;

    private String url = "http://localhost:8081";
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/comptebancaireactive")
    public String list(Model model,@RequestParam("page") Optional<Integer> page) {

        int evalPageSize = INITIAL_PAGE_SIZE;

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;


        ResponseEntity<List<CompteBancaire>> response = restTemplate.exchange(
                url+"/agent/listCompteActive", HttpMethod.GET, null, new ParameterizedTypeReference<List<CompteBancaire>>() {}
        );
        List<CompteBancaire> list = response.getBody();
        Page<CompteBancaire> comptes = new PageImpl<>(list);
        Pager pager = new Pager(comptes.getTotalPages(), comptes.getNumber(), BUTTONS_TO_SHOW);
        model.addAttribute("comptes",comptes);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pager", pager);

      //  model.addAttribute("comptes",list);
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
