package group2.TASC.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {
    private static User student = new Student("Joe", "averagejoe", "password");
    String name = "Joe";
    String username = "averagejoe";
    String password = "password";

    @Test
    void nameTest() {
        student.setName(name);
        assertEquals(student.getName(), name);
    }

    @Test
    void usernameTest() {
        student.setUserName(username);
        assertEquals(student.getUserName(), username);
    }

    @Test
    void passwordLengthTest() {
        student.setPassWord(password);
        assertTrue(student.getPassWord().length() >= 8);
    }

    @Test
    void passwordTest() {
        student.setPassWord(password);
        assertEquals(student.getPassWord(), password);
    }


}
