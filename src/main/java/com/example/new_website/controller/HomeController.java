package com.example.new_website.controller;

import com.example.new_website.model.Book;
import com.example.new_website.service.BookService;
import com.example.new_website.model.Course;
import com.example.new_website.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String homePage(Model model) {
        // Fetch all courses
        List<Course> courses = courseService.getAllCourses();

        // Filter courses with course_type == 1 for section-2
        List<Course> structuralCourses = courses.stream()
                .filter(course -> course.getCourse_type() == 1)
                .collect(Collectors.toList());

        // Filter courses with course_type == 2 for section-3
        List<Course> automationCourses = courses.stream()
                .filter(course -> course.getCourse_type() == 2)
                .collect(Collectors.toList());

        // Fetch all books for section-4
        List<Book> books = bookService.getAllBooks();

        // Add filtered courses and books to the model
        model.addAttribute("structuralCourses", structuralCourses);
        model.addAttribute("automationCourses", automationCourses);
        model.addAttribute("books", books);

        return "index";
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

    @GetMapping("/faq")
    public String faqPage() {
        return "faq";
    }

    @GetMapping("/advice")
    public String registerPage() {
        return "advice";
    }
}
