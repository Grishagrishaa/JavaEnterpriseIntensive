package org.example.JavaEnterpriseIntensive.telegraph.core.dto;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime sendTime;
    private User sender;
    private User recipient;
    private String text;

    public Message(User sender, User recipient, String text) {
        this.sendTime = LocalDateTime.now();
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "SEND TIME=" + sendTime + '\n' +
                "SENDER=" + sender + '\n' +
                "TEXT='" + text + '\'' +
                '}';
    }
}
