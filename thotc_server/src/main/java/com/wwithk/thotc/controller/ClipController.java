package com.wwithk.thotc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wwithk.thotc.dto.response.api.GetClipBoardDto;
import com.wwithk.thotc.repository.ClipBoardRepository;
import com.wwithk.thotc.service.ClipBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClipController {

    @Autowired
    ClipBoardService clipBoardService;

    private final ClipBoardRepository clipBoardRepository;

    @GetMapping("/getclips/{streamerName}")
    public GetClipBoardDto.ClipBoardDatas getClipBoardInfo(@PathVariable("streamerName") String streamerName) throws JsonProcessingException {
        log.info("streamer Name : " + streamerName);
        return clipBoardService.getClipInfo(streamerName);
    }
}
