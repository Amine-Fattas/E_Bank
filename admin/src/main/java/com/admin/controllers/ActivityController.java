package com.admin.controllers;


import com.admin.Repository.ActivityRepository;
import com.admin.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ActivityController {


    @Autowired
    ActivityRepository activityRepository;

    @RequestMapping(value="/desactiverCompte", method = RequestMethod.POST)
    public Activity desac(@RequestBody String s) {
     Activity activity=new Activity(s,new Date());
        return activityRepository.save(activity);
    }

    @RequestMapping(value="/supprimerClient", method = RequestMethod.POST)
    public Activity supprimer(@RequestBody String s) {
        Activity activity=new Activity(s,new Date());
        return activityRepository.save(activity);
    }


}
