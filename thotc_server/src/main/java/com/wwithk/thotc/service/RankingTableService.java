package com.wwithk.thotc.service;

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

    public String getStreamerInfo(){ // 시청수, 스트리머 이름,
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Client-ID",cliendId);
        HttpEntity<String> request=new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchHost)
                .path("/helix/streams")
                .queryParam("first",100)
                .queryParam("language","ko")
                .build();

        log.info(uriComponents.toString());

        ResponseEntity<String> responseEntity=restTemplate.exchange(uriComponents.toString(),
                HttpMethod.GET,request,String.class);

        return responseEntity.toString();
    }
}
