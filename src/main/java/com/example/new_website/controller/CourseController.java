package com.example.new_website.controller;

import com.example.new_website.model.Course;
import com.example.new_website.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course existingCourse = courseService.getCourseById(id);
        if (existingCourse != null) {
            existingCourse.setTitle(course.getTitle());
            existingCourse.setDescription(course.getDescription());
            existingCourse.setImage_url(course.getImage_url());
            return courseService.saveCourse(existingCourse);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
