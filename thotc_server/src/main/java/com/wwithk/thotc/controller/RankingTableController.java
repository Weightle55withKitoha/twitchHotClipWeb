package com.wwithk.thotc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonParseException;
import com.wwithk.thotc.dao.TableInfoDao;
import com.wwithk.thotc.dto.response.TableInfoResponseDto;
import com.wwithk.thotc.dto.response.api.GetStreamsDto;
import com.wwithk.thotc.dto.response.api.GetUsersDto;
import com.wwithk.thotc.repository.TableInfoRepository;
import com.wwithk.thotc.service.RankingTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> ecd1a91d6fb4cbcd60e02fd14ae1ac1ff27ae2ee
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
<<<<<<< HEAD
=======
@RequestMapping("/api")
>>>>>>> ecd1a91d6fb4cbcd60e02fd14ae1ac1ff27ae2ee
public class RankingTableController {

    @Autowired
    RankingTableService rankingTableService;

    private final TableInfoRepository tableInfoRepository;

    @GetMapping("/streams")
    public List<TableInfoDao> test() throws JsonProcessingException, ParseException, InterruptedException {
        return tableInfoRepository.findAll();
    }
}
