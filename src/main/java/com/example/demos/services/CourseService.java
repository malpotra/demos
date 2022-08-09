package com.example.demos.services;
import com.example.demos.entities.Course;
import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(Long courseId);

    Course addCourse(Course course);

    public void removeCourse(Long courseId);

    public void updateCourse(Course course);
}
