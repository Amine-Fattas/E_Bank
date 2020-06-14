package com.admin.controllers;

import com.admin.Repository.AdminRepository;
import com.admin.models.Admin;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {


    @Autowired
    public AdminRepository adminRepository;

    @Autowired
    public AdminRestController restController;


    @RequestMapping("/profile")
    public String currentAdmin(Model model) {
       Admin admin = restController.currentAdmin();
       model.addAttribute("admin",admin);
        return "profile";
    }

}


