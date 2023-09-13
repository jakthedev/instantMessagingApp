package com.jaklabs.instantmessagingchat.dto;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Channel {

    private Long channelId;
    private String name;
    private Long uId;
    private List<User> usersInChat = new ArrayList<>();

    private List<Message> messages = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

//    public List<Message> getMessages() {
//        return messages;
//    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "chatUsers_areIn",
            joinColumns = {@JoinColumn(table = "users",
                    name = "userid",
                    referencedColumnName = "uId")},
            inverseJoinColumns = {@JoinColumn(table = "chatUsers_areIn",
                    name= "channelId")})
    public List<User> getUsersInChat() {
        return usersInChat;
    }

    public void setUsersInChat(List<User> usersInChat) {
        this.usersInChat = usersInChat;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "channelUser_messages",
            joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name= "message_id"))
    public List<Message> getUserMessageInfo() {
        return messages;
    }

    public void setUserMessageInfo(List<Message> messages) {
        this.messages = messages;
    }
}
