package group2.TASC.service;

import group2.TASC.model.Course;
import group2.TASC.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAllByOrderByCourseCodeAsc();
    }

    @Override
    public void addCourse(Course schedule) {
        courseRepo.save(schedule);
    }

    @Override
    public void removeCourseById(long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public Course getCourseById(long id) {
        if (!courseRepo.existsById(id)) {
            throw new EntityNotFoundException();
        }
        return courseRepo.findByCourseCode(id);
    }

    @Override
    public void updateCourse(Course course) {
        if (!courseRepo.existsById(course.getCourseCode())) {
            throw new EntityNotFoundException();
        }
        courseRepo.save(course);
    }
}
