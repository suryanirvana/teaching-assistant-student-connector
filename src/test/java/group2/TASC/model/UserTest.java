package group2.TASC.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {UserDetailsService.class, User.class})
@WebMvcTest(controllers = User.class)
public class UserTest {

    User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId((long) 1);
        user.setName("Test");
        user.setStudent_id("1");
        user.setEmail("test@test.com");
        user.setUsername("test");
        user.setPassword("test");
        user.setRoles("USER");
    }

    @Test
    public void whenGetRoleIsExecutedItWillReturnListOfRoles() {
        List<String> roles = user.getRoleList();
        assertEquals("USER", roles.get(0));
    }

    @Test
    public void whenTheresNoCourseAssignedAndExecuteGetCourseCodeItWillReturnEmptyArrayList() {
        List<String> courses = user.getCourseList();
        assertEquals(0, courses.size());
    }

    @Test
    public void whenTheresCourseAssignedAndExecuteGetCourseCodeItWillReturnListOfCourses() {
        user.setCourseCode("CS01");

        List<String> courses = user.getCourseList();
        assertEquals("CS01", courses.get(0));
    }
}
