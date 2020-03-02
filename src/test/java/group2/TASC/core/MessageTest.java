package group2.TASC.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MessageTest {

    private static Student recipient = new Student("newStudent", "studentUserName", "password");
    private Message message = new Message(recipient, "Title", "testMessage");

    @Test
    void checkIfRecipientNameExist() {
        assertNotEquals(recipient.getName(), "");
    }

    @Test
    void checkIfRecipientUserNameExist() {
        assertNotEquals(recipient.getUserName(), "");
    }

    @Test
    void checkIfRecipientNameEquals() {
        String temp = "newStudent";
        recipient.setName(temp);
        assertEquals(recipient.getName(), temp);
    }

    @Test
    void checkIfMessageTitleExist() {
        assertNotEquals(message.getMessageTitle(), "");
    }

    @Test
    void checkIfMessageTitleEquals() {
        String temp = "Title";
        message.setMessageTitle(temp);
        assertEquals(message.getMessageTitle(), temp);
    }

    @Test
    void checkIfMessageContentExist() {
        assertNotEquals(message.getMessageContent(), "");
    }

    @Test
    void checkIfMessageContentEquals() {
        String temp = "testMessage";
        message.setMessageContent(temp);
        assertEquals(message.getMessageContent(), temp);
    }
}
