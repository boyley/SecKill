package com.danlu.user.controller;

import com.danlu.user.entity.ReceiverAddress;
import com.danlu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lenovo on 2017/6/13.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "{id}/receiver")
    public List<ReceiverAddress> receiverAddress(@PathVariable int id) {
        return userService.findAllReceiverAddress(id);
    }
}
