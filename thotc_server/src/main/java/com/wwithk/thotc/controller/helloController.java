package com.wwithk.thotc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wwithk.thotc.dao.AccessTokenDao;
import com.wwithk.thotc.repository.AccessTokenRepository;
import com.wwithk.thotc.service.TwitchAccessTokenService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class helloController {

    @Autowired
    TwitchAccessTokenService twitchAccessTokenService;

    private final AccessTokenRepository accessTokenRepository;

    @GetMapping("/token")
    public String hello() throws JsonProcessingException {
        return twitchAccessTokenService.createAccessToken();
    }

    @GetMapping("/token/check")
    public String chk(){
        AccessTokenDao accessTokenDaoList=accessTokenRepository.findFirstElement();
        LocalDateTime modifiedDate=accessTokenDaoList.getModifiedDate();
        Integer expireTime=accessTokenDaoList.getExpireTime();
        modifiedDate=modifiedDate.plusSeconds(expireTime);

        return modifiedDate.toString();
    }
}
