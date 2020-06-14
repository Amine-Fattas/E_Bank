package com.admin.controllers;

import com.admin.Repository.ActivityRepository;
import com.admin.Repository.AgenceRepository;
import com.admin.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@Controller
public class AgentController {

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private AdminRestController adminRestController;

    @Autowired
    private ActivityRepository activityRepository;


    private String url = "http://localhost:8081";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();


    @RequestMapping(value = "/index")
    public String list(Model model,String keyword) {


        List<Agent> list = null;
if(keyword != null && keyword !="") {
    ResponseEntity<List<Agent>> response = restTemplate.exchange(
            url + "/agent/list/" + keyword, HttpMethod.GET, null, new ParameterizedTypeReference<List<Agent>>() {
            }
    );
   list = response.getBody();
}
else{
    ResponseEntity<List<Agent>> response = restTemplate.exchange(
            url + "/agent/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Agent>>() {
            }
    );
    list = response.getBody();
}
            for (Agent ag : list) {
                if(ag.getNumAgence().equals(0)){
                    ag.setAgence(new Agence());
                }
                else {
                    ag.setAgence(agenceRepository.findById(ag.getNumAgence()).get());
                }
            }

        model.addAttribute("listAgents", list);
        return "Agent/Agents";
    }



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @Valid Agent agent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Agence> Agences = agenceRepository.findAll();
            model.addAttribute("listeAgences", Agences);
            return "Agent/add-agent";
        }
        String pass=Password.pass();
        agent.setPassword(bCryptPasswordEncoder.encode(pass));
        Agence agence = agenceRepository.findByNomAgence(agent.getAgence().getNomAgence());
        agent.setAgence(agence);
        agent.setNumAgence(agence.getNumAgence());
        Agent ag= restTemplate.postForObject(url + "/agent/add", agent, Agent.class);
        Activity activity = new Activity("Admin ID: "+adminRestController.currentAdmin().getId()
                + " a ajouté l'agent ID "+ ag.getId());
        model.addAttribute("pass", pass);
        model.addAttribute("agentcree", ag.getUsername());
        activity.setDate(new Date());
        activityRepository.save(activity);

        return "Agent/agent-cree";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model, Agent agent) {
        model.addAttribute("agent", new Agent());
        List<Agence> Agences = agenceRepository.findAll();
        model.addAttribute("listeAgences", Agences);
        return "Agent/add-agent";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable("id") Long id, Agent agent) {

        System.out.println("admin" + agent.getNumAgence());
        Agence agence = agenceRepository.findByNomAgence(agent.getAgence().getNomAgence());
        agent.setAgence(agence);
        agent.setNumAgence(agence.getNumAgence());
        restTemplate.postForObject(url + "/agent/update/"+id, agent, Agent.class);

        Activity activity = new Activity("Admin ID: "+adminRestController.currentAdmin().getId()
                + " a modifié l'agent ID "+ id);
        activity.setDate(new Date());
        activityRepository.save(activity);
        return "redirect:/index";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editAgent(Model model, Long id) {

        ResponseEntity<List<Agent>> response = restTemplate.exchange(
                url + "/agent/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Agent>>() {
                }
        );
        List<Agent> list = response.getBody();
        Agent agent = new Agent();
        for (Agent ag : list) {
            if (id.equals(ag.getId())) {
                agent.setId(id);
                agent.setNom(ag.getNom());
                agent.setPrenom(ag.getPrenom());
                agent.setCin(ag.getCin());
                agent.setUsername(ag.getUsername());
                agent.setPassword(ag.getPassword());
                agent.setNumContrat(ag.getNumContrat());
                agent.setNumAgence(ag.getNumAgence());
                agent.setAgence(agenceRepository.findById(ag.getNumAgence()).get());
                break;
            }
        }

        List<Agence> Agences = agenceRepository.findAll();
        model.addAttribute("listeAgence", Agences);
        model.addAttribute("agent", agent);
        return "Agent/edit-agent";
    }


    @RequestMapping(value = "/findAgentsByAgence")
    public String findAgentsByAgence(Model model, Integer id) {

        ResponseEntity<List<Agent>> response = restTemplate.exchange(
                url + "/agent/agentsbyagence/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<List<Agent>>() {
                }
        );
        List<Agent> agents = response.getBody();
        for (Agent ag : agents) {
            ag.setAgence(agenceRepository.findById(ag.getNumAgence()).get());
        }

        model.addAttribute("listeAgents", agents);

        return "Agent/agents-agence";

    }


    @RequestMapping(value="/delete" , method= RequestMethod.GET)
    public String delete(Model model, Long id){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url+"/agent/deleteagent/"+id, String.class);
        Activity activity = new Activity("Admin ID: "+adminRestController.currentAdmin().getId()
                + " a supprimé l'agent ID "+ id);
        activity.setDate(new Date());
        activityRepository.save(activity);

        return "redirect:/index";

    }


}
