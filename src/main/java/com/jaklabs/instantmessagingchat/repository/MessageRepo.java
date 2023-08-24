package com.jaklabs.instantmessagingchat.repository;

import com.jaklabs.instantmessagingchat.dto.Channel;
import com.jaklabs.instantmessagingchat.dto.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
}
