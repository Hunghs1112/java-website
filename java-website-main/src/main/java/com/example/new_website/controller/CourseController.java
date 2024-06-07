package com.example.new_website.controller;

import com.example.new_website.model.Course;
import com.example.new_website.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/courses/{id}")
    public String getCourseDetails(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        List<Course> allCourses = courseService.getAllCourses();
        List<Course> featuredCourses = allCourses.stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                    Collections.shuffle(collected);
                    return collected.stream().limit(5).collect(Collectors.toList());
                }));
        model.addAttribute("course", course);
        model.addAttribute("featuredCourses", featuredCourses);
        return "course_detail";
    }

    @GetMapping("/course/{id}")
    public String getHomeCourseDetails(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        List<Course> allCourses = courseService.getAllCourses();
        List<Course> featuredCourses = allCourses.stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                    Collections.shuffle(collected);
                    return collected.stream().limit(5).collect(Collectors.toList());
                }));
        model.addAttribute("course", course);
        model.addAttribute("featuredCourses", featuredCourses);
        return "course_detail";
    }
}
