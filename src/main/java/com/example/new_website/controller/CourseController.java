package com.example.new_website.controller;

import com.example.new_website.model.Course;
import com.example.new_website.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String getAllCourses(@RequestParam(required = false, defaultValue = "id") String sort, Model model) {
        List<Course> courses = courseService.getAllCourses();

        // Sorting logic
        switch (sort) {
            case "title":
                courses = courses.stream().sorted(Comparator.comparing(Course::getTitle)).collect(Collectors.toList());
                break;
            case "price":
                courses = courses.stream().sorted(Comparator.comparing(Course::getDiscounted_price)).collect(Collectors.toList());
                break;
            case "id":
            default:
                courses = courses.stream().sorted(Comparator.comparing(Course::getId)).collect(Collectors.toList());
                break;
        }

        // Separate courses by type
        List<Course> courses1 = courses.stream().filter(course -> course.getCourse_type() == 1).collect(Collectors.toList());
        List<Course> courses2 = courses.stream().filter(course -> course.getCourse_type() == 2).collect(Collectors.toList());

        model.addAttribute("courses1", courses1);
        model.addAttribute("courses2", courses2);
        model.addAttribute("sort", sort);
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
