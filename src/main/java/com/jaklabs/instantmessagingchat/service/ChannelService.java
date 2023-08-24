package com.jaklabs.instantmessagingchat.service;

import com.jaklabs.instantmessagingchat.dto.Channel;
import com.jaklabs.instantmessagingchat.repository.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepo channelRepo;

    public Channel findChannel(Long channelid) {
        return 
    }
}
