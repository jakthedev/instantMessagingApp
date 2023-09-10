package com.jaklabs.instantmessagingchat.dto;

import jakarta.persistence.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

    private Long channelUserIsIn;

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

    public Long getChannelUserIsIn() {
        return channelUserIsIn;
    }

    public void setChannelUserIsIn(Long channelUserIsIn) {
        this.channelUserIsIn = channelUserIsIn;
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
