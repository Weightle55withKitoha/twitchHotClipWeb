package com.wwithk.thotc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwithk.thotc.dao.AccessTokenDao;
import com.wwithk.thotc.dto.response.api.AccessTokenDto;
import com.wwithk.thotc.repository.AccessTokenRepository;
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

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class TwitchAccessTokenService {

    @Autowired
    RestTemplate restTemplate;

    private final AccessTokenRepository accessTokenRepository;

    @Value("${spring.TwitchClientId}")
    private String cliendId;

    @Value("${spring.TwitchClientSecretId}")
    private String cliendSecretId;

    @Value("${spring.TwitchGetTokenHost}")
    private String twitchGetTokenHost;

    public String createAccessToken() throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchGetTokenHost)
                .path("/oauth2/token")
                .queryParam("client_id", cliendId)
                .queryParam("client_secret", cliendSecretId)
                .queryParam("grant_type", "client_credentials")
                .build();

        ResponseEntity<String> responseEntity = restTemplate.exchange(uriComponents.toString(),
                HttpMethod.POST, request, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        AccessTokenDto accessTokenDto = objectMapper.readValue(responseEntity.getBody(), AccessTokenDto.class);
        accessTokenRepository.save(accessTokenDto.toEntity());

        return responseEntity.toString();
    }

    public AccessTokenDao getAccessToken() throws JsonProcessingException {
        AccessTokenDao accessTokenDao=accessTokenRepository.findFirstElement();
        if(accessTokenDao==null){
            createAccessToken();
            accessTokenDao=accessTokenRepository.findFirstElement();
        }
        return accessTokenDao;
    }

/*
    public LocalDateTime getAccessTokenExpireTime(){

    }
*/

}
