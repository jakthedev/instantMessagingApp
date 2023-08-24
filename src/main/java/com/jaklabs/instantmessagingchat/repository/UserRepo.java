package com.jaklabs.instantmessagingchat.repository;

import com.jaklabs.instantmessagingchat.dto.Channel;
import com.jaklabs.instantmessagingchat.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUserid(Long userid);


}
