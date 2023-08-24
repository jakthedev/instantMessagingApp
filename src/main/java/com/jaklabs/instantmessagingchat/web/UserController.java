package com.jaklabs.instantmessagingchat.web;

import com.jaklabs.instantmessagingchat.dto.User;
import com.jaklabs.instantmessagingchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/welcome")
    public String loginUser(ModelMap model){

        model.put("user", new User());

        return "welcome";
    }

    @PostMapping("/welcome")
    public String postCreateUser(User user) {
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/welcome/{userid}/channel";

    }

    @GetMapping("/welcome/{userid}/channel")
    public String PickChannel(ModelMap model, @PathVariable Long userid){

        User thisUser = userService.getUser(userid);
        model.put("user", thisUser);

        return "channel";
    }

    @PostMapping ("/welcome/{userid}/channel")
    public String PickChannel(ModelMap model, @PathVariable Long userid){

        User thisUser = userService.getUser(userid);
        model.put("user", thisUser);

        return "channel";
    }
}
