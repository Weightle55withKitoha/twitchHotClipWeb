package com.wwithk.thotc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wwithk.thotc.dao.AccessTokenDao;
import com.wwithk.thotc.dao.TableInfoDao;
import com.wwithk.thotc.repository.AccessTokenRepository;
import com.wwithk.thotc.repository.TableInfoRepository;
import com.wwithk.thotc.service.RankingTableService;
import com.wwithk.thotc.service.TwitchAccessTokenService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class helloController {

    @Autowired
    TwitchAccessTokenService twitchAccessTokenService;

    @Autowired
    RankingTableService rankingTableService;

    private final AccessTokenRepository accessTokenRepository;

    private final TableInfoRepository tableInfoRepository;

    @GetMapping("/ks/{name}")
    public String hello2(@PathVariable("name") String name){
        Optional<TableInfoDao> tableInfoDao =tableInfoRepository.findBystreamerName(name);
        log.info(tableInfoDao.get().getStreamerName());
        return "success";
    }

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
