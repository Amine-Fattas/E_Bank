package com.admin.controllers;

import com.admin.Repository.AgenceRepository;
import com.admin.Repository.AgentRepository;
import com.admin.models.Agence;
import com.admin.models.Agent;
import com.admin.models.Pager;

import com.admin.models.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class AgentController {
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private AgenceRepository agenceRepository;
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 8;
    // private static final int[] PAGE_SIZES = { 5, 10, 20 };


    /*private String getUrlWithoutParameters(String url) throws URISyntaxException {
        URI uri = new URI(url);
        return new URI(uri.getScheme(),
                uri.getAuthority(),
                uri.getPath(),
                null, // Ignore the query part of the input url
                uri.getFragment()).toString();
    }*/

    @RequestMapping(value = "/")
    public String home()
    { return"home";
    }

    @RequestMapping(value = "/profile")
    public String profile()
    { return"profile";
    }


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

    }

    @RequestMapping(value="/add" , method= RequestMethod.GET)
    public String add(Model model, Agent agent){
        model.addAttribute("agent",new Agent());
        List<Agence> Agences = agenceRepository.findAll();
        model.addAttribute("listeAgences",Agences);
        return "Agent/add-agent";
    }
    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editAgent(Model model,Long id) {
        Agent a=  agentRepository.findById(id).get();
        model.addAttribute("agent",a);
        List<Agence> Agences = agenceRepository.findAll();
        model.addAttribute("listeAgence",Agences);
        return "Agent/edit-agent";
    }

    @RequestMapping(value="/update" , method=RequestMethod.POST)
    public String update(Model model, Long id, Agent agent){
        Agent a=agentRepository.findById(id).get();
        if(id==a.getSuffixContrat())
            agent.setSuffixContrat(id);
        agent.setNumContrat("AFOIH-"+Long.toString(agent.getSuffixContrat()));
        Agence agence=agenceRepository.findByNomAgence(agent.getAgence().getNomAgence());
        agent.setAgence(agence);
        agentRepository.save(agent);
        return "redirect:/index";
    }

    @RequestMapping(value="/save" , method= RequestMethod.POST)
    public String save(Model model,Agent agent){

        Long lastSuffix;
        if(agentRepository.last_suffix() == null){
            lastSuffix=10000000L;
        }
        else{lastSuffix=agentRepository.last_suffix()+1;}
        agent.setSuffixContrat(lastSuffix);
        agent.setNumContrat("AFOIH-"+Long.toString(agent.getSuffixContrat()));
        agent.setPassword(Password.pass());
        agent.setLogin(Long.toString(agent.getSuffixContrat())+"@AFOIHebank.com");
        // System.out.println(id);
        // System.out.println(agent.getAgence().getNomAgence());
        Agence agence=agenceRepository.findByNomAgence(agent.getAgence().getNomAgence());
        // System.out.println(agence);
        agent.setAgence(agence);
        //       agent.getAgence().setNumAgence(agence.getNumAgence());
        agentRepository.save(agent);
        return "redirect:/index";
    }
    @RequestMapping(value="/delete" , method= RequestMethod.GET)
    public String delete(Model model, Long id){
        Agent a=agentRepository.findById(id).get();
        agentRepository.delete(a);
        return "redirect:/index";

    }
}