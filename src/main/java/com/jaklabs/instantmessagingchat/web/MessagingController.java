package com.jaklabs.instantmessagingchat.web;

import com.jaklabs.instantmessagingchat.dto.Channel;
import com.jaklabs.instantmessagingchat.dto.Message;
import com.jaklabs.instantmessagingchat.dto.User;
import com.jaklabs.instantmessagingchat.service.ChannelService;
import com.jaklabs.instantmessagingchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessagingController {

    @Autowired
    private ChannelService channelService;

    @Autowired
    private UserService userService;


    @GetMapping("/welcome/messagingChat/{userid}/{channelid}" +
            "")
    public String startMessaging(ModelMap model, @PathVariable Long userid) {

        User user = userService.getUser(userid);
        //Channel channel = channelService.findChannel(channelId);
        //Channel channelO = new Channel();

        //Long num = channel.getChannelId();
        //user.setChannelUserIsIn(num);
        model.addAttribute("user", user);

        return "messagingChat";
    }

    @PostMapping("/exists")
    @ResponseBody
    public Boolean postExists (@RequestBody Channel channel) {
        channel = channelService.findChannel(channel.getChannelId());
        if (channel.getUserMessageInfo() == null) {
            System.out.println("no messages exist");
            return channel.getUserMessageInfo() == null;
        }
        return (channel.getUserMessageInfo() != null);
    }
}
