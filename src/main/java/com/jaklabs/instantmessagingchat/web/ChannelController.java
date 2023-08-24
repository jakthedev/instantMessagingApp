package com.jaklabs.instantmessagingchat.web;

import com.jaklabs.instantmessagingchat.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChannelController {



    @GetMapping("/channel")
    public String loginUser(ModelMap model){

        model.put("user", new User());

        return "welcome";
    }


}
