package com.admin.controllers;

import com.admin.Repository.ClientRepository;
import com.admin.Repository.CompteBancaireRepository;
import com.admin.Repository.OperationRepository;
import com.admin.models.Client;
import com.admin.models.CompteBancaire;
import com.admin.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class CompteBancaireController {



        @Autowired
        private CompteBancaireRepository compteRepository;
        @Autowired
        private OperationRepository operationRepository;

        @RequestMapping(value="/comptebancaire")
        public String list(Model model,int id) {
            CompteBancaire compte = compteRepository.findById(id).get();
            compte.setOperations(operationRepository.findByCompte_rib(id));
            model.addAttribute("compte",compte);
            model.addAttribute("operations",compte.getOperations());
            return "CompteBancaire/ComptesBancaires";
        }







}
