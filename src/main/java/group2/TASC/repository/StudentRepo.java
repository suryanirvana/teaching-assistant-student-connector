package group2.TASC.repository;

import group2.TASC.model.Student;
import group2.TASC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
}
