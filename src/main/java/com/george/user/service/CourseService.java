package com.george.user.service;

import com.george.user.model.Course;
import com.george.user.model.User;
import com.george.user.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.get();
    }

    public Course createCourse(Course course) {
        courseRepository.save(course);
        return course;
    }

    public Course updateCourse(Integer id, Course course) {
        Course myCourse = getCourse(id);
        myCourse.setName(course.getName());
        courseRepository.save(myCourse);
        return myCourse;
    }

    public Course deleteCourse(Integer id) {
        Course course = getCourse(id);
        courseRepository.deleteById(id);
        return course;
    }


    // end
}
