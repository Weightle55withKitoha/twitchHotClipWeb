package com.wwithk.thotc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwithk.thotc.dao.AccessTokenDao;
import com.wwithk.thotc.dao.TableInfoDao;
import com.wwithk.thotc.dto.response.api.GetClipBoardDto;
import com.wwithk.thotc.dto.response.api.GetStreamsDto;
import com.wwithk.thotc.repository.ClipBoardRepository;
import com.wwithk.thotc.repository.TableInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClipBoardService {

    @Autowired
    RestTemplate restTemplate;

    private final ClipBoardRepository clipBoardRepository;
    private final TableInfoRepository tableInfoRepository;

    @Value("${spring.TwitchClientId}")
    private String clientId;

    @Value("${spring.TwitchClientSecretId}")
    private String clientSecretId;

    @Value("${spring.TwitchHost}")
    private String twitchHost;

    @Autowired
    TwitchAccessTokenService twitchAccessTokenService;

    public GetClipBoardDto.ClipBoardDatas getClipInfo(String streamerName) throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Client-ID",clientId);
        AccessTokenDao accessTokenDao = twitchAccessTokenService.getAccessToken();
        httpHeaders.add("Authorization","Bearer "+accessTokenDao.getAccessToken());
        HttpEntity<String> request= new HttpEntity<String>(httpHeaders);

        Optional<TableInfoDao> tableInfoDao = tableInfoRepository.findBystreamerName(streamerName);
        //예외처리 해야함 if null
        String broadcasterId = tableInfoDao.get().getBroadcasterId();

        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchHost)
                .path("/helix/clips")
                .queryParam("broadcaster_id",broadcasterId)
                .queryParam("first",10)
                .queryParam("language","ko")
                .build();

        ResponseEntity<String> responseEntity=restTemplate.exchange(uriComponents.toString(),HttpMethod.GET,request,String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        GetClipBoardDto.ClipBoardDatas clipBoardDatas=objectMapper.readValue(responseEntity.getBody(), GetClipBoardDto.ClipBoardDatas.class);

        return clipBoardDatas;
    }

}
