package group2.TASC.service;

import group2.TASC.model.Course;
import group2.TASC.model.User;
import group2.TASC.repository.CourseRepo;
import group2.TASC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void removeCourseById(String id) {
        Course course = courseRepo.findByCourseCode(id);
        courseRepo.delete(course);
    }

    @Override
    public Course getCourseById(String id) {
        if (courseRepo.findByCourseCode(id) == null) {
            throw new EntityNotFoundException(id);
        }
        return courseRepo.findByCourseCode(id);
    }

    @Override
    public void updateCourse(Course course) {
        if (courseRepo.findByCourseCode(course.getCourseCode()) == null) {
            throw new EntityNotFoundException();
        }
        courseRepo.save(course);
    }

    @Override
    public void assignTA(String id, String taId) {
        User TA = null;
        for (User user : userService.findAllUsers()) {
            if (user.getStudent_id().equals(taId)) {
                TA = user;
            }
        }
        Course course = getCourseById(id);

        if(course.getTaId() == null) {
            course.setTaId(taId);
            course.setTaName(TA.getName());
        } else if (!course.getTAList().contains(taId)){
            course.setTaId(course.getTaId() + ", " + taId);
            course.setTaName(course.getTaName() + ", " + TA.getName());
        }

        if(TA.getCourseCode() == null) {
            TA.setCourseCode(id);
        } else if (!TA.getCourseList().contains(id)){
            TA.setCourseCode(TA.getCourseCode() + ", " + id);
        }

        courseRepo.save(course);
        userRepo.save(TA);
    }
}
