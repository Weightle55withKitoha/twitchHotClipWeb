package com.wwithk.thotc.controller;

import com.wwithk.thotc.service.RankingTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankingTableController {
    @Autowired
    RankingTableService rankingTableService;

    @GetMapping("/test")
    public String test(){
        return rankingTableService.getStreamerInfo();
    }
}
