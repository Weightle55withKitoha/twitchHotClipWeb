package com.wwithk.thotc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonParseException;
import com.wwithk.thotc.dto.response.TableInfoResponseDto;
import com.wwithk.thotc.dto.response.api.GetStreamsDto;
import com.wwithk.thotc.dto.response.api.GetUsersDto;
import com.wwithk.thotc.service.RankingTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankingTableController {
    @Autowired
    RankingTableService rankingTableService;

    @GetMapping("/test")
    public String test() throws JsonProcessingException {
        GetStreamsDto.StreamsData streamsData=rankingTableService.getStreamerInfo();
        for(int i=0;i<streamsData.getData().size();i++){
            GetUsersDto.UserFollowsData userFollowsData= rankingTableService
                    .getFollowingCount(streamsData.getData().get(i).getUserId());

            Integer currentViewerAverage=0;

            TableInfoResponseDto tableInfoResponseDto=TableInfoResponseDto.builder()
                    .viewerCount(streamsData.getData().get(i).getViewerCount())
                    .followerCount(userFollowsData.getTotal())
                    .viewerAverage(currentViewerAverage)
                    .broadcastTime(123)
                    .broadcastEndTime(123)
                    .build();
        }

        return "test";
    }
}
