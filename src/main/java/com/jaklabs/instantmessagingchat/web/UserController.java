package com.jaklabs.instantmessagingchat.web;

import com.jaklabs.instantmessagingchat.dto.User;
import com.jaklabs.instantmessagingchat.service.ChannelService;
import com.jaklabs.instantmessagingchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChannelService channelService;

    @GetMapping("/welcome")
    public String loginUser(ModelMap model){

        User user = new User();
        model.put("user", user);
        model.put("userid", user.getUserid());

        Set<User> users = userService.findAllUsers();

        model.put("users", users);
        if (users.size() == 1) {
            model.put("users", users.iterator().next());
        }

        return "welcome";
    }

    @PostMapping("/welcome")
    public String postCreateUser(ModelMap model, User user) {
        System.out.println(user);
        userService.saveUser(user);
        //model.addAttribute("userid", userid);
        return "redirect:/welcome/{userid}";

    }

    @GetMapping("/welcome/{userid}")
    public String PickChannel(ModelMap model, @PathVariable Long userid){

        User thisUser = userService.getUser(userid);
        model.put("user", thisUser);

//        Set<User> users = userService.findAllUsers();
//
//        model.put("userr", users);
//        if (users.size() == 1) {
//            model.put("userr", users.iterator().next());
//        }

        return "channel";
    }
//
//    @PostMapping ("/welcome/{userid}/channel")
//    public String createChannel(ModelMap model, @PathVariable Long userid){
//
//        User thisUser = userService.getUser(userid);
//        model.put("user", thisUser);
//
//        return "channel";
//    }
}
