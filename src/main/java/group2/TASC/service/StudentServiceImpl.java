package group2.TASC.service;

import group2.TASC.model.Student;
import group2.TASC.model.User;
import group2.TASC.repository.StudentRepo;
import group2.TASC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @Override
    public Student addStudent(String username) {
        User user = userService.findByUsername(username);
        user.setRoles(user.getRoles() + ",STUDENT");
        userRepo.save(user);

        Student student = new Student();
        student.setStudent_id(user.getStudent_id());
        student.setUsername(username);
        return studentRepo.save(student);
    }
}
