package group2.TASC.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MessageTest {
    @Test
    void testIfCanCreateNewMessageObject() {
        Student recipient = new Student("newStudent", "studentUserName", "password");
        Message message = new Message(recipient, "Title", "testMessage");
    }
}
