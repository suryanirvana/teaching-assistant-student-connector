package group2.TASC.service;

import group2.TASC.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    void addCourse(Course course);

    void removeCourseById(String id);

    Course getCourseById(String id);

    void updateCourse(Course course);

    void assignTA(String id, String taId);
}
