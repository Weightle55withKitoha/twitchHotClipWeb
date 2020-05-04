package com.wwithk.thotc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonParseException;
import com.wwithk.thotc.dto.response.TableInfoResponseDto;
import com.wwithk.thotc.dto.response.api.GetStreamsDto;
import com.wwithk.thotc.dto.response.api.GetUsersDto;
import com.wwithk.thotc.repository.TableInfoRepository;
import com.wwithk.thotc.service.RankingTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RankingTableController {

    @Autowired
    RankingTableService rankingTableService;

    private final TableInfoRepository tableInfoRepository;

    @GetMapping("/streams")
    public List<TableInfoResponseDto> test() throws JsonProcessingException {
        List<TableInfoResponseDto> tableInfoResponseDtos=new ArrayList<TableInfoResponseDto>();

        GetStreamsDto.StreamsData streamsData=rankingTableService.getStreamerInfo();
        for(int i=0;i<streamsData.getData().size();i++){
            GetUsersDto.UserFollowsData userFollowsData= rankingTableService
                    .getFollowingCount(streamsData.getData().get(i).getUserId());

            GetUsersDto.UserInfo userInfo=rankingTableService.getUserInfo(streamsData.getData().get(i).getUserId());

            Integer currentViewerAverage=0;


            TableInfoResponseDto tableInfoResponseDto=TableInfoResponseDto.builder()
                    .streamerName(streamsData.getData().get(i).getUserName())
                    .streamerImgUrl(userInfo.getProfileImgUrl())
                    .viewerCount(streamsData.getData().get(i).getViewerCount())
                    .followerCount(userFollowsData.getTotal())
                    .viewerAverage(currentViewerAverage)
                    .broadcastTime(streamsData.getData().get(i).getStartTime())
                    .broadcastEndTime(123)
                    .build();

            log.info(tableInfoResponseDto.getStreamerName());

            tableInfoResponseDtos.add(tableInfoResponseDto);

            tableInfoRepository.save(tableInfoResponseDto.toEntity());

        }

        return tableInfoResponseDtos;
    }
}
