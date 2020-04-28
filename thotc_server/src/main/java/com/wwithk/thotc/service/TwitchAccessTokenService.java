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

@Slf4j
@Service
public class TwitchAccessTokenService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.TwitchClientId}")
    private String cliendId;

    @Value("${spring.TwitchClientSecretId}")
    private String cliendSecretId;

    @Value("${spring.TwitchGetTokenHost}")
    private String twitchGetTokenHost;

    public String getAccessToken(){
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> request=new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchGetTokenHost)
                .path("/oauth2/token")
                .queryParam("client_id",cliendId)
                .queryParam("client_secret",cliendSecretId)
                .queryParam("grant_type","client_credentials")
                .build();

        ResponseEntity<String> responseEntity=restTemplate.exchange(uriComponents.toString(),
                HttpMethod.POST,request,String.class);

        return responseEntity.toString();
    }
}
