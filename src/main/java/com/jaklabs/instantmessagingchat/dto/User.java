package com.jaklabs.instantmessagingchat.dto;

import jakarta.persistence.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "users")
public class User {

    private Long userid;
    private String username;

    private List<Message> messages = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "channel_user_Isin",
            joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name= "channel_id"))
    public List<Channel> channelUserIsIn(Long userid, Long channelId) throws SQLException {

        Connection connection = DriverManager.getConnection("jjdbc:mysql://localhost:3306/instantMessageChatDB", "root", "Alexander$$00");

        Statement statement = connection.createStatement();

//        LocalDateTime localDateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
//        String timestamp = localDateTime.format(formatter);
//        System.out.println(timestamp);



        String sql = "UPDATE channel_user_Isin SET channel_id = ? WHERE user_id = ?";
//        String name = "John Doe";
//        int id = 1;
        PreparedStatement myStmt;
        myStmt = statement.prepareStatement(select * from students where age> ? and name = ?);

        statement.setInt(1, channelId);
        statement.setInt(2, id);

        int rowsAffected = statement.executeUpdate(sql);

        return accounts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Column(length = 100, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_messages",
            joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name= "message_id"))
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getUserid(), user.getUserid()) && Objects.equals(getUsername(), user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getUsername());
    }


}
