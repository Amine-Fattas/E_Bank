package com.admin.controllers;


import com.admin.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ActivityController {


    @Autowired
    ActivityRepository activityRepository;




}
