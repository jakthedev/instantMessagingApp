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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class ChannelController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChannelService channelService;

    @GetMapping("/welcome/channel/{userid}")
    public String pickChannel(ModelMap model){

        Set<Channel> channels = channelService.findAllChannels();

        model.put("channels", channels);
        if (channels.size() == 1) {
            model.put("channels", channels.iterator().next());
        }
        return "channel";
    }

    @PostMapping("/welcome/channel/{userid}")
    public String pickChannel(ModelMap model, @PathVariable Long userid){

        User thisUser = userService.getUser(userid);
        // I need to register the channel to the User,
        // doing this in the javascript file, and not here.
        // thisUser.setChannelUserIsIn();

        model.put("user", thisUser);

        return "redirect:/welcome/channel/{userid}";
    }

    @GetMapping("/welcome/channelRegistration")
    public String createChannel(ModelMap model){

        Channel channel = new Channel();
        model.put("channel", channel);
        model.put("channelId", channel.getChannelId());

        Set<Channel> channels = channelService.findAllChannels();

        model.put("channels", channels);
        if (channels.size() == 1) {
            model.put("channels", channels.iterator().next());
        }

        return "channelRegistration";
    }

    @PostMapping("/welcome/channelRegistration")
    public String createChannel(ModelMap model, Channel channel){
        channelService.saveChannel(channel);
        //model.addAttribute("userid", userid);
        return "redirect:/welcome/channel/{userid}";
    }

}
