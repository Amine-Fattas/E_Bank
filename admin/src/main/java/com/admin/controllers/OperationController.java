package com.admin.controllers;

import com.admin.Repository.OperationRepository;
import com.admin.models.CompteBancaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    //@RequestMapping(value="/comptebancaire")
   /* public String list(Model model, int id) {
        CompteBancaire compte = operationRepository.findById(id).get();
        model.addAttribute("operations",compte.getOperations());
        return "CompteBancaire/ComptesBancaires";


    }*/

}
