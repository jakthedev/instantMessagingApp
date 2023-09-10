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

    @GetMapping("/welcome/messagingChat/{userid}" +
            "")
    public String startMessaging(ModelMap model, @PathVariable Long userid) {

        User user = userService.getUser(userid);
        Channel channel = channelService.findChannel(channelId);
        //Channel channelO = new Channel();

        Long num = channel.getChannelId();
        user.setChannelUserIsIn(num);
        model.addAttribute("user", user);

        return "messagingChat";
    }
}
