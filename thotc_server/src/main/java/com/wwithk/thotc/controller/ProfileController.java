package com.wwithk.thotc.controller;

import com.wwithk.thotc.dao.TableInfoDao;
import com.wwithk.thotc.dto.response.TableInfoResponseDto;
import com.wwithk.thotc.repository.TableInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProfileController {

    private final TableInfoRepository tableInfoRepository;

    @GetMapping("/profile/{name}")
    public TableInfoResponseDto getProfileInfo(@PathVariable("name") String name){
        Optional<TableInfoDao> tableInfoDao=tableInfoRepository.findBystreamerName(name);

        return tableInfoDao.get().toDto();
    }

}
