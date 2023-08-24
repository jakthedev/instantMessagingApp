package com.jaklabs.instantmessagingchat.dto;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    private Long messageId;
    private String text;
    private LocalDateTime createdDate;
    private Long channelId;
    private User user;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
