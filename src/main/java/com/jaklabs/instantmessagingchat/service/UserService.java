package com.jaklabs.instantmessagingchat.service;

import com.jaklabs.instantmessagingchat.dto.User;
import com.jaklabs.instantmessagingchat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userrepo;

    public User saveUser(User user) {
        return userrepo.save(user);
    }

    public User getUser(Long userid){
        return userrepo.findByUserid(userid);
    }

    public Set<User> findAllUsers() {
        return userrepo.findAllUsers();
    };


}
