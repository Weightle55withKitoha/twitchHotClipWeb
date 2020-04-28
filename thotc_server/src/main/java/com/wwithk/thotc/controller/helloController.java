package com.wwithk.thotc.controller;

import com.wwithk.thotc.service.TwitchAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @Autowired
    TwitchAccessTokenService twitchAccessTokenService;

    @GetMapping("/token")
    public String hello(){
        return twitchAccessTokenService.getAccessToken();
    }
}
