package com.admin.controllers;

import com.admin.Repository.AgenceRepository;
import com.admin.models.Agence;
import com.admin.models.Agent;
import com.admin.models.Pager;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Controller
public class AgenceController{
   @Autowired
    private AgenceRepository agenceRepository;



    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 8;

    private String url = "http://localhost:8081";


    @RequestMapping(value="/get-agence")
    public String findAgence(Model model, String id)
    {
        Agence agence = agenceRepository.findByNomAgence(id);
        model.addAttribute("agence",agence);
        return "Agence/agence";
    }

    @RequestMapping(value="/liste")
    public String liste(Model model, @RequestParam("page") Optional<Integer> page)
    {
        int evalPageSize = INITIAL_PAGE_SIZE;

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Agence> Agences = agenceRepository.findAll(PageRequest.of(evalPage, evalPageSize));
        Pager pager = new Pager(Agences.getTotalPages(), Agences.getNumber(), BUTTONS_TO_SHOW);
        model.addAttribute("listeAgences",Agences);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pager", pager);

        return "Agence/Agences";
    }



    @RequestMapping(value="/addAgence" , method= RequestMethod.GET)
    public String addAgence(Model model, Agence agence){
        model.addAttribute("agence",new Agence());
        return "Agence/add-agence";
    }
    @RequestMapping(path = "/editAgence", method = RequestMethod.GET)
    public String editAgence(Model model,int numAgence) {
        Agence a= agenceRepository.findById(numAgence);
        model.addAttribute("agence",a);
        return "Agence/edit-agence";
    }

    @RequestMapping(value="/update-agence" , method=RequestMethod.POST)
    public String update(Model model, Integer id, Agence agence){
        Agence a=agenceRepository.findById(id).get();
        agence.setNumAgence(id);
        agenceRepository.save(agence);
        return "redirect:/liste";
    }

    @RequestMapping(value="/saveAgence" , method= RequestMethod.POST)
    public String saveAgence(Model model, Agence agence){
        Integer lastCodeGuichet;
        if(agenceRepository.lastcodeguichet()==null){
            lastCodeGuichet=26000;
        }
        else{lastCodeGuichet=agenceRepository.lastcodeguichet()+1;}
        agence.setNumAgence(lastCodeGuichet);
        agenceRepository.save(agence);
        return "redirect:/liste";
    }
   /* @RequestMapping(value="/deleteAgence" , method= RequestMethod.GET)
    @Cascade(CascadeType.DELETE)
    public String deleteAgence(Model model, Integer numAgence){
        Agence a=agenceRepository.findById(numAgence).get();
        List<Agent> agents= agentRepository.findAllByAgenceNumAgence(a.getNumAgence());
        for (int i = 0; i < agents.size(); i++) {
            agents.get(i).setAgence(null);
            agentRepository.save(agents.get(i));
        }

        agenceRepository.delete(a);
        return "redirect:/liste";

    }*/

    @RequestMapping(value="/deleteAgence" , method= RequestMethod.GET)
    @Cascade(CascadeType.DELETE)
    public String deleteAgence(Model model, Integer numAgence){
        Agence a=agenceRepository.findById(numAgence).get();
        Integer id = a.getNumAgence();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url+"/agent/deleteagence/"+id, String.class);

        agenceRepository.delete(a);
        return "redirect:/liste";

    }
}