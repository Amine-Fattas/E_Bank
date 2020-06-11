package com.admin.controllers;


import com.admin.Repository.ActivityRepository;
import com.admin.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WelcomeController {


    @Autowired
    public ActivityRepository activityRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        List<Activity> list=activityRepository.findFirst20ByOrderByIdDesc();
        model.addAttribute("activities",list);
        return "home";
    }


    @Controller
    public class LogoutController {

        @RequestMapping(value="/logout",method = RequestMethod.GET)
        public String logout(HttpServletRequest request){
            HttpSession httpSession = request.getSession();
            ((HttpSession) httpSession).invalidate();
            return "redirect:/";
        }

    }




}
