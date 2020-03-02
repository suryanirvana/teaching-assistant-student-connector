package group2.TASC.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    private static User admin = new Admin("Surya", "suryanirvana", "LaLiLuLeLo");

    @Test
    void checkIfNameExist() {
        String temp = "Surya";
        admin.setName(temp);
        assertNotEquals(admin.getName(), "");
    }

    @Test
    void checkIfUsernameExist() {
        String temp = "suryanirvana";
        admin.setUserName(temp);
        assertNotEquals(admin.getUserName(), "");
    }

    @Test
    void checkIfPasswordMoreThan8Characters() {
        String temp = "LaLiLuLeLo";
        admin.setPassWord(temp);
        assertTrue(admin.getPassWord().length() >= 8);
    }

    @Test
    void checkIfNameEquals() {
        String temp = "Surya";
        admin.setName(temp);
        assertEquals(admin.getName(), temp);
    }

    @Test
    void checkIfUsernameEquals() {
        String temp = "suryanirvana";
        admin.setUserName(temp);
        assertEquals(admin.getUserName(), temp);
    }

    @Test
    void checkIfPasswordEquals() {
        String temp = "LaLiLuLeLo";
        admin.setPassWord(temp);
        assertEquals(admin.getPassWord(), temp);
    }
}
