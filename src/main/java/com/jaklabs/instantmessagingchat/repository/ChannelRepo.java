package com.jaklabs.instantmessagingchat.repository;

import com.jaklabs.instantmessagingchat.dto.Channel;
import com.jaklabs.instantmessagingchat.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {

    Channel findByChannelId(Long channelId);

    @Query("select c from Channel c")
    Set<Channel> findAllChannels();
}
