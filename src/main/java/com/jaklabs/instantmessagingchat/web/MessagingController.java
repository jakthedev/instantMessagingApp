package com.jaklabs.instantmessagingchat.web;

import com.jaklabs.instantmessagingchat.dto.Channel;
import com.jaklabs.instantmessagingchat.dto.User;
import com.jaklabs.instantmessagingchat.service.ChannelService;
import com.jaklabs.instantmessagingchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MessagingController {

    @Autowired
    private ChannelService channelService;

    @Autowired
    private UserService userService;

    @GetMapping("/welcome/${channelId}/${userid}/messagingChat")
    public String startMessaging(ModelMap model, @PathVariable Long channelId, @PathVariable Long userid) {
        Channel thisChannel = channelService.findChannel(channelId);
        User thisUser = userService.getUser(userid);


        return "messagingChat";
    }
}
