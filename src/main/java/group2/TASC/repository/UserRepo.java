package group2.TASC.repository;

import group2.TASC.model.Course;
import group2.TASC.model.Student;
import group2.TASC.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAllByOrderByUserIdAsc();
    User findByUserId(long userId);
    User findByUsername(String username);
}
