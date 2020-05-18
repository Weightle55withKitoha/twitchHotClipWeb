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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RankingTableController {

    @Autowired
    RankingTableService rankingTableService;

    private final TableInfoRepository tableInfoRepository;

    @GetMapping("/streams")
    public List<TableInfoDao> test() throws JsonProcessingException, ParseException, InterruptedException {
        return tableInfoRepository.findAll();
    }
}
