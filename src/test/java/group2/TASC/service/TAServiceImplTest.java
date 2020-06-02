package group2.TASC.service;

import group2.TASC.model.User;
import group2.TASC.repository.TeachingAssistantRepo;
import group2.TASC.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TAServiceImplTest {

    @Autowired
    private TeachingAssistantService teachingAssistantService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TeachingAssistantRepo teachingAssistantRepo;


    private static Long id = (long)1000000000;
    private static String name = "Surya";
    private static String username= "suryaaaa";
    private static String email = "sur@ya.mail";
    private static String studentId = "98765";
    private static String password = "mcnuggets1234";
    private static String courseCode ="CC00";

    private User user = new User();

    @BeforeEach
    void setUp() {
        user.setCourseCode(courseCode);
        user.setEmail(email);
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setStudent_id(studentId);
        user.setUsername(username);
        userRepo.save(user);
    }

//    @Test
//    void whenAddTAByUsernameSaveTAToRepo() throws Exception {
//        teachingAssistantService.addTA(username);
//        assertEquals("TA", userRepo.findByUsername(username).getRoleList().get(1));
//        assertEquals(username, teachingAssistantRepo.findByUsername(username).getUsername());
//    }
}
