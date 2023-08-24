package com.jaklabs.instantmessagingchat.repository;

import com.jaklabs.instantmessagingchat.dto.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {

    Channel findByChannelId(Long channelid);


}
