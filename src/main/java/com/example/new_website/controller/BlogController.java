package com.example.new_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }

    @GetMapping("/post1")
    public String post1Page() {
        return "post1";
    }

    @GetMapping("/post2")
    public String post2Page() {
        return "post2";
    }
}
