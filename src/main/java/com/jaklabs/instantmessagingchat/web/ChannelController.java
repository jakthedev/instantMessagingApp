package com.jaklabs.instantmessagingchat.web;

import com.jaklabs.instantmessagingchat.dto.Channel;
import com.jaklabs.instantmessagingchat.dto.User;
import com.jaklabs.instantmessagingchat.service.ChannelService;
import com.jaklabs.instantmessagingchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
        Channel channel = new Channel();
        // I need to register the channel to the User,
        // doing this in the javascript file, and not here.
        // thisUser.setChannelUserIsIn();
        List<User> allUser = new ArrayList<>();
        allUser.add(thisUser);
        channel.setUsersInChat(allUser);

        model.put("user", thisUser);

        return "redirect:/welcome/channel/{userid}";
    }

//    @PostMapping("/welcome/channel/{userid}")
//    @ResponseBody
//    public Boolean postExists (@RequestBody Channel channel) {
//        channel = channelService.findChannel(channel.getChannelId());
//        if (channel.getUserMessageInfo() == null) {
//            System.out.println("no messages exist");
//            return channel.getUserMessageInfo() == null;
//        }
//        return (channel.getUserMessageInfo() != null);
//    }

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
