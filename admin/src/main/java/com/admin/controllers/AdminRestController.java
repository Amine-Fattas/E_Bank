
package com.admin.controllers;

import com.admin.Repository.AdminRepository;
import com.admin.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {

    @Autowired
    public AdminRepository adminRepository;


    @RequestMapping("/currentAdmin")
    public Admin currentAdmin() {
        System.out.println("currentadmin");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        Admin admin=new Admin();
        if (!auth.getPrincipal().equals("anonymousUser")) {
            System.out.println("je suis la");
            admin = adminRepository.findByUsername(auth.getName());
        }
        return admin;
    }


}
