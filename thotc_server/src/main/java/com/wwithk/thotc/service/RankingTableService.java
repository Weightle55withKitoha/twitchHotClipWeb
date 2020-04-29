package com.wwithk.thotc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwithk.thotc.dto.response.api.GetStreamsDto;
import com.wwithk.thotc.dto.response.api.GetUsersDto;
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

import java.io.IOException;
import java.net.URI;

@Slf4j
@Service
public class RankingTableService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.TwitchClientId}")
    private String cliendId;

    @Value("${spring.TwitchClientSecretId}")
    private String cliendSecretId;

    @Value("${spring.TwitchHost}")
    private String twitchHost;

    public GetStreamsDto.StreamsData getStreamerInfo() throws JsonProcessingException { // 시청수, 스트리머 이름,
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Client-ID",cliendId);
        HttpEntity<String> request=new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchHost)
                .path("/helix/streams")
                .queryParam("first",100)
                .queryParam("language","ko")
                .build();

        ResponseEntity<String> responseEntity=restTemplate.exchange(uriComponents.toString(),
                HttpMethod.GET,request,String.class);

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        GetStreamsDto.StreamsData streamsData=objectMapper.readValue(responseEntity.getBody(),GetStreamsDto.StreamsData.class);

        return streamsData;
    }

    public GetUsersDto.UserFollowsData getFollowingCount(String userId) throws JsonProcessingException{
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Client-ID",cliendId);
        HttpEntity<String> request=new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchHost)
                .path("/helix/users/follows")
                .queryParam("to_id",userId)
                .build();

        ResponseEntity<String> responseEntity=restTemplate.exchange(uriComponents.toString(),
                HttpMethod.GET,request,String.class);

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
        GetUsersDto.UserFollowsData userFollowsData=objectMapper.readValue(responseEntity.getBody(),GetUsersDto.UserFollowsData.class);

        return userFollowsData;
    }
}
