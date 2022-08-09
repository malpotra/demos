package com.example.demos.services;

import com.example.demos.dao.CourseDao;
import com.example.demos.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CourseServiceImplementor implements CourseService {
//    List<Course> list;
    @Autowired
    private CourseDao courseDao;
    public CourseServiceImplementor() {
  //      this.list = new ArrayList<>();
  //      list.add(new Course(120,"Java","This is a Java Course."));
  //      list.add(new Course(125,"C++","This is a C++ Course."));

    }

    @Override
    public List<Course> getCourses() {

       // return list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(Long courseId) {
 /*       Course c = null;

        for (Course course:list){
            if (course.getId() == courseId){
                c = course;
                break;
            }
        }
*/
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        ///this.list.add(course);
        courseDao.save(course);
        return course;

    }
    @Override
    public void removeCourse(Long courseId){
        //Course c = getCourse(courseId);
        courseDao.delete(courseDao.getOne(courseId));
        //list.remove(c);
    }

    @Override
    public void updateCourse(Course course){

        /*int num = 0;
        for (Course c: list){
            if (c.getId() == course.getId()){
                break;
            }
            num++;
        }
        list.remove(num);
        list.add(course);*/
        courseDao.save(course);
    }
}
