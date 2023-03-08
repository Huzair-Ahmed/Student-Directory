package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.StudentsData;
import com.example.demo.servies.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    public MainController(StudentService service) {
        this.service = service;
    }

    StudentService service;


    @GetMapping(path = "/enterStudent" )
    public String enterStudent(Model model){
        model.addAttribute("viewstudent", new StudentsData());
        return "enterStudent";
    }

    @PostMapping(path = "/process-student")
    public String processStudent(@ModelAttribute StudentsData s1){
        service.enrollStudent(s1);
        return "redirect:/registeredStudent";
    }

    @GetMapping(path = "/registeredStudent" )
    public String registeredStudent(Model model){
        model.addAttribute("students",service.getStudents());
        return "registeredStudent";
    }
}
