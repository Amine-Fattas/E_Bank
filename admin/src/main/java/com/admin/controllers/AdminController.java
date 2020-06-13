package com.admin.controllers;

import com.admin.Repository.AdminRepository;
import com.admin.models.Admin;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import com.sun.xml.bind.util.AttributesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {


    @Autowired
    public AdminRepository adminRepository;


    @RequestMapping("/profile")
    public String currentAdmin(Model model) {
        System.out.println("currentadmin");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        Admin admin=new Admin();
        if (!auth.getPrincipal().equals("anonymousUser")) {
            System.out.println("je suis la");
            admin = adminRepository.findByUsername(auth.getName());
        }
        model.addAttribute("admin",admin);
        return "profile";
    }

}


