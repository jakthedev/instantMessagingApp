package com.jaklabs.instantmessagingchat.service;

import com.jaklabs.instantmessagingchat.dto.Channel;
import com.jaklabs.instantmessagingchat.dto.User;
import com.jaklabs.instantmessagingchat.repository.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepo channelRepo;

    public Channel findChannel(Long channelId) {
        return channelRepo.findByChannelId(channelId);
    }

    public Set<Channel> findAllChannels() {
        return channelRepo.findAllChannels();
    }

    public Channel saveChannel(Channel channel) {
        return channelRepo.save(channel);
    }
}
