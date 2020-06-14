package com.admin.controllers;

import com.admin.Repository.ActivityRepository;
import com.admin.Repository.AgenceRepository;
import com.admin.models.Activity;
import com.admin.models.Agence;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;



@Controller
public class AgenceController{
   @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private AdminRestController adminRestController;

    private String url = "http://localhost:8081";


    @RequestMapping(value="/get-agence")
    public String findAgence(Model model, String id)
    {
        Agence agence = agenceRepository.findByNomAgence(id);
        model.addAttribute("agence",agence);
        return "Agence/agence";
    }

    @RequestMapping(value="/liste")
    public String liste(Model model,String keyword)
    {

        if(keyword != null && keyword !=""){
            model.addAttribute("listeAgences",agenceRepository.findByKeyword(keyword));
        }
        else {
            List<Agence> Agences = agenceRepository.findAll();
            model.addAttribute("listeAgences", Agences);
        }

        return "Agence/Agences";
    }



    @RequestMapping(value="/addAgence" , method= RequestMethod.GET)
    public String addAgence(Model model, Agence agence){
        model.addAttribute("agence",new Agence());
        return "Agence/add-agence";
    }

    @RequestMapping(path = "/editAgence", method = RequestMethod.GET)
    public String editAgence(Model model,int numAgence) {
        Agence a= agenceRepository.findById(numAgence).get();
        model.addAttribute("agence",a);
        return "Agence/edit-agence";
    }

    @RequestMapping(value="/update-agence" , method=RequestMethod.POST)
    public String update(Model model, Integer id, Agence agence){
        Agence a=agenceRepository.findById(id).get();
        agence.setNumAgence(id);
        agenceRepository.save(agence);
        Activity activity = new Activity("Admin ID: "+adminRestController.currentAdmin().getId()
                + " a modifié l'agence "+ agence.getNumAgence());
        activity.setDate(new Date());
        activityRepository.save(activity);

        return "redirect:/liste";
    }

    @RequestMapping(value="/saveAgence" , method= RequestMethod.POST)
    public String saveAgence(Model model,@Valid Agence agence, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "Agence/add-agence";
        }
        Integer lastCodeGuichet;
        if(agenceRepository.lastcodeguichet()==null){
            lastCodeGuichet=26000;
        }
        else{lastCodeGuichet=agenceRepository.lastcodeguichet()+1;}
        agence.setNumAgence(lastCodeGuichet);
        agenceRepository.save(agence);
        Activity activity = new Activity("Admin ID: "+adminRestController.currentAdmin().getId()
        + " a ajouté l'agence "+ agence.getNumAgence() +" " + agence.getNomAgence());
        activity.setDate(new Date());
        activityRepository.save(activity);
        return "redirect:/liste";
    }


    @RequestMapping(value="/deleteAgence" , method= RequestMethod.GET)
    @Cascade(CascadeType.DELETE)
    public String deleteAgence(Model model, Integer numAgence){
        Agence a=agenceRepository.findById(numAgence).get();
        Integer id = a.getNumAgence();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url+"/agent/deleteagence/"+id, String.class);

        agenceRepository.delete(a);

        Activity activity = new Activity("Admin ID: "+adminRestController.currentAdmin().getId()
                + " a supprimé l'agence "+ a.getNumAgence() +" " + a.getNomAgence());
        activity.setDate(new Date());
        activityRepository.save(activity);
        return "redirect:/liste";

    }
}