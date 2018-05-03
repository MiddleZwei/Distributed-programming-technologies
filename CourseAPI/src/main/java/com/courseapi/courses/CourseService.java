package com.courseapi.courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
        .forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id){
        return courseRepository.findById(id);
    }


    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course); // save() can do both. if doesn't exist it'll create one
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
