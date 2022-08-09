package com.example.demos.controller;
import java.util.List;
import com.example.demos.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demos.services.CourseService;

@RestController
public class MyController {

    @Autowired
    private CourseService service;
    @GetMapping("/home")
    public String home(){
        return "This is the home page";
    }

    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.service.getCourses();
    }

    //get a  single course by its course ID
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.service.getCourse(Long.parseLong(courseId));
    }

    // add a new course to the existing courses
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.service.addCourse(course);
    }

    //delete a course with its course ID
    @DeleteMapping("/courses/{courseId}")
    public String removeCourse(@PathVariable String courseId){
        this.service.removeCourse(Long.parseLong(courseId));
        return "Course Removed.";
    }

    //update a course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        this.service.updateCourse(course);
        return course;
    }
}
