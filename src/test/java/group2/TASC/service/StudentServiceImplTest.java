package group2.TASC.service;

import group2.TASC.model.Student;
import group2.TASC.model.User;
import group2.TASC.repository.StudentRepo;
import group2.TASC.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private StudentService studentService;

    private static Long id = (long)47698329;
    private static String name = "Alice";
    private static String username= "alice";
    private static String email = "alice@h.mail";
    private static String studentId = "48ur834";
    private static String password = "airputihsegar";
    private static String courseCode ="CS0001";

    private User user = new User();

//    @BeforeEach
//    void setUp() {
//        user.setCourseCode(courseCode);
//        user.setEmail(email);
//        user.setId(id);
//        user.setName(name);
//        user.setPassword(password);
//        user.setRoles(role);
//        user.setStudent_id(studentId);
//        user.setUsername(username);
//        userRepo.save(user);
//    }

//    @Test
//    void whenAddStudentByUsernameSaveStudentToRepo() throws Exception {
//        user.setCourseCode(courseCode);
//        user.setEmail(email);
//        user.setId(id);
//        user.setName(name);
//        user.setPassword(password);
////        user.setRoles(role);
//        user.setStudent_id(studentId);
//        user.setUsername(username);
//        userRepo.save(user);
//        studentService.addStudent("sarah");
//        assertEquals("STUDENT", userRepo.findByUsername("sarah").getRoleList().get(1));
//        assertEquals("sarah", studentRepo.findByUsername("sarah").getUsername());
//    }
}
