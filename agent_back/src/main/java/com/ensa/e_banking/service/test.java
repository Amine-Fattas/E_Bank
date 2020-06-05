package com.ensa.e_banking.service;

import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Service
public class test {

    public Boolean check(HttpServletRequest req) {
//        System.out.println(req.getRequestURL());
//        System.out.println("Header :"+req.getHeader("Origin"));
//        if(req.getHeader("Origin").equals("http://localhost:4200") ||
//                req.getHeader("Origin").equals("http://localhost:8082") ||
//                req.getHeader("Origin").equals("http://localhost:4201") ||
//                req.getHeader("Origin").equals("http://localhost:2021")){
//            return true;
//        }
//        return false;
        return true;
    }


}