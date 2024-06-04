package com.example.new_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }



    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }

    @GetMapping("/software")
    public String softwarePage() {
        return "software";
    }

    @GetMapping("/training")
    public String trainingPage() {
        return "training";
    }

    @GetMapping("/jobs")
    public String jobsPage() {
        return "jobs";
    }

    @GetMapping("/materials")
    public String materialsPage() {
        return "materials";
    }

    @GetMapping("/faq")
    public String faqPage() {
        return "faq";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
}
