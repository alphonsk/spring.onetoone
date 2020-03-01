package com.george.user.controller;

import com.george.user.model.Course;
import com.george.user.model.User;
import com.george.user.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){

        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Integer id){
        return courseService.getCourse(id);
    }

    @PostMapping("/course")
    public Course createCourse(@RequestBody Course course){
        courseService.createCourse(course);
        return course;
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.PUT)
    public Course updateCourse(@PathVariable final Integer id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public Course deleteCourse(@PathVariable Integer id){
        return courseService.deleteCourse(id);
    }

}
