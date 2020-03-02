package group2.TASC.core;

public class Message {
    private User recipient;
    private String messageTitle;
    private String messageContent;


    public Message(User recipient, String messageTitle, String messageContent) {
        this.recipient = recipient;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
