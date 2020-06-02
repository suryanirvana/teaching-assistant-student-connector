package group2.TASC.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {Course.class})
@WebMvcTest(controllers = Course.class)
public class CourseTest {

    Course course;

    @BeforeEach
    public void setUp() {
        course = new Course();
        course.setCourseCode("CS01");
        course.setCourseName("Advanced Programming");
    }

    @Test
    public void whenGetTAListIsExecutedButNoTAAssignedYetItReturnsEmptyArrayList() {
        course.setTaId("");
        course.setTaName("");
        List<String> taList = course.getTAList();
        assertEquals(0, taList.size());
    }

    @Test
    public void whenGetTAListIsExecutedAndIsTAAssignedItReturnsEmptyArrayList() {
        course.setTaId("1");
        course.setTaName("Test");
        List<String> taList = course.getTAList();
        assertEquals("1", taList.get(0));
    }
}
