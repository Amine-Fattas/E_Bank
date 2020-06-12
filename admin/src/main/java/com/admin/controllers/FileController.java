package com.admin.controllers;


import com.admin.Repository.ActivityRepository;
import com.admin.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class FileController {

//@Autowired
//HttpServletResponse servletResponse;

@Autowired
ActivityRepository activityRepository;

    @RequestMapping(value = "/downloadhistorique", method = RequestMethod.GET)
    public void write(HttpServletRequest request, HttpServletResponse servletResponse) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        List<Activity> list=activityRepository.findAll();
      //  FileWriter =new FileWriter("historique.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter("historique.txt"));
        for(Activity l : list){
            String strDate = dateFormat.format(l.getDate());
            String act=l.getAction();
            writer.write(strDate+ "    "+act);
            writer.write("\r\n");
        }
        writer.close();

       // File f = new File("historique.txt");
        File file = new File("historique.txt");

        //InputStream is = new FileInputStream(f);
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"" + file.getName() + "\"");
        servletResponse.setHeader(headerKey, headerValue);
        servletResponse.setContentLength((int) file.length());
        servletResponse.setContentType("text/plain");


       /* System.out.println(servletResponse);
        // obtains response's output stream
        OutputStream outStream = servletResponse.getOutputStream();
        System.out.println(outStream);
       // System.out.println(f.toPath());
        Files.copy(Paths.get("..\\..\\..\\..\\..\\historique.txt"), servletResponse.getOutputStream());
        // outStream.close();*/
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        OutputStream outputStream= servletResponse.getOutputStream();
        FileCopyUtils.copy(inputStream, outputStream);
        servletResponse.flushBuffer();
        outputStream.close();

    }


}
