package group2.TASC.repository;

import group2.TASC.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
    List<Course> findAllByOrderByCourseCodeAsc();
    Course findByCourseCode(long id);
}
