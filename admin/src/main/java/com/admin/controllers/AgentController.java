package com.admin.controllers;

import com.admin.Repository.AgenceRepository;
import com.admin.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Controller
public class AgentController {

    @Autowired
    private AgenceRepository agenceRepository;
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 8;
    private String url = "http://localhost:8081";
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/index")
    public String list(Model model) {
        ResponseEntity<List<Agent>> response = restTemplate.exchange(
                url+"/agent/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Agent>>() {}
        );
        List<Agent> list = response.getBody();
        model.addAttribute("listAgents",list);
        return "Agent/Agents";
    }

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/profile")
    public String profile() {
        return "profile";
    }


    @RequestMapping(value="/save" , method= RequestMethod.POST)
    public String save(Model model,Agent agent){
        agent.setPassword(Password.pass());
      //  Agence agence=agenceRepository.findByNomAgence(agent.getAgence().getNomAgence());

       //agent.setAgence(agence);
        //       agent.getAgence().setNumAgence(agence.getNumAgence());
        restTemplate.postForObject(url+"/agent/add", agent, Agent.class);
       return "redirect:/index";
    }
    @RequestMapping(value="/add" , method= RequestMethod.GET)
    public String add(Model model, Agent agent){
        model.addAttribute("agent",new Agent());
        List<Agence> Agences = agenceRepository.findAll();
        model.addAttribute("listeAgences",Agences);
        return "Agent/add-agent";
    }

    @RequestMapping(value="/update" , method=RequestMethod.PUT)
    public String update(Model model, Long id, Agent agent){
       // restTemplate.postForObject(url+"/agent/update/"+id, agent, Agent.class);
            restTemplate.put(url+"/agent/update/"+id, agent);
            return  "redirect:/index";
        }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editAgent(Model model,Long id) {

      Agent agent=restTemplate.getForObject(url+"/agent/"+id,Agent.class);
        List<Agence> Agences = agenceRepository.findAll();
        model.addAttribute("listeAgence",Agences);
        model.addAttribute("agent",agent);
        return "Agent/edit-agent";
    }

    }


/*
    @RequestMapping(value="/findAgentsByAgence")
    public String findAgentsByAgence(Model model,Integer id,@RequestParam("page") Optional<Integer> page)
    {

        int evalPageSize = INITIAL_PAGE_SIZE;
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Pageable pag = PageRequest.of(evalPage, evalPageSize);
        Page<Agent> agents = agentRepository.findAllByAgenceNumAgence(id,pag);
        List<Agent> agent =agentRepository.findAllByAgenceNumAgence(id);
        Pager pager = new Pager(agents.getTotalPages(), agents.getNumber(), BUTTONS_TO_SHOW);
        model.addAttribute("listeAgents",agents);
        if(!agent.isEmpty())model.addAttribute("agent",agent.get(0));
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pager", pager);
        return "Agent/agents-agence";

    }


    @RequestMapping(value="/get-agent")
    public String findAgent(Model model, Long num)
    {
        Agent agent = agentRepository.findById(num).get();
        model.addAttribute("a",agent);
        return "Agent/agent";
    }



    @RequestMapping(value="/index")
    public String index(Model model, @RequestParam("page") Optional<Integer> page) {
        //int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPageSize = INITIAL_PAGE_SIZE;

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Agent> agents = agentRepository.findAll(PageRequest.of(evalPage, evalPageSize));
        Pager pager = new Pager(agents.getTotalPages(), agents.getNumber(), BUTTONS_TO_SHOW);

        model.addAttribute("listeAgents", agents);
        model.addAttribute("selectedPageSize", evalPageSize);
        //  model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", pager);
        // List<Agent> Agents = agentRepository.findAll();
        // model.addAttribute("listeAgents",agentRepository.findAll(PageRequest.of(page,4)));
        //model.addAttribute("data",agentRepository.findAll(PageRequest.of(page,4)));
        return "Agent/Agents";

    }*/



    /*
    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editAgent(Model model,Long id) {
        Agent a=  agentRepository.findById(id).get();
        model.addAttribute("agent",a);
        List<Agence> Agences = agenceRepository.findAll();
        model.addAttribute("listeAgence",Agences);
        return "Agent/edit-agent";
    }




    @RequestMapping(value="/delete" , method= RequestMethod.GET)
    public String delete(Model model, Long id){
        Agent a=agentRepository.findById(id).get();
        agentRepository.delete(a);
        return "redirect:/index";

    }
}*/