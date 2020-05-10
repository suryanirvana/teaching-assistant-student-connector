package group2.TASC.core;

import group2.TASC.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private User recipient;
    private String messageTitle;
    private String messageContent;


    public Message(User recipient, String messageTitle, String messageContent) {
        this.recipient = recipient;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
    }
}
