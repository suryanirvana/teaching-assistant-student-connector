package group2.TASC.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeachingAssistantTest {
    private static User ta = new TeachingAssistant("Jane", "janey", "password");
    String name = "Jane";
    String username = "janey";
    String password = "password";

    @Test
    void nameTest() {
        ta.setName(name);
        assertEquals(ta.getName(), name);
    }

    @Test
    void usernameTest() {
        ta.setUserName(username);
        assertEquals(ta.getUserName(), username);
    }

    @Test
    void passwordLengthTest() {
        ta.setPassWord(password);
        assertTrue(ta.getPassWord().length() >= 8);
    }

    @Test
    void passwordTest() {
        ta.setPassWord(password);
        assertEquals(ta.getPassWord(), password);
    }


}
