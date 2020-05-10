package group2.TASC.repository;

import group2.TASC.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAllByOrderByStudentIdAsc();
    User findByStudentId(long id);
    User findByUsername(String username);
}

