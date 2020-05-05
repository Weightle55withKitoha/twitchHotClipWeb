package com.wwithk.thotc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwithk.thotc.dao.AccessTokenDao;
import com.wwithk.thotc.dao.TableInfoDao;
import com.wwithk.thotc.dto.response.TableInfoResponseDto;
import com.wwithk.thotc.dto.response.ViewerPair;
import com.wwithk.thotc.dto.response.api.GetStreamsDto;
import com.wwithk.thotc.dto.response.api.GetUsersDto;
import com.wwithk.thotc.dto.response.api.GetViedeosDto;
import com.wwithk.thotc.repository.AccessTokenRepository;
import com.wwithk.thotc.repository.TableInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class RankingTableService {

    @Autowired
    RestTemplate restTemplate;

    private final TableInfoRepository tableInfoRepository;

    @Value("${spring.TwitchClientId}")
    private String cliendId;

    @Value("${spring.TwitchClientSecretId}")
    private String cliendSecretId;

    @Value("${spring.TwitchHost}")
    private String twitchHost;

    @Autowired
    TwitchAccessTokenService twitchAccessTokenService;

    @Autowired
    TimeCalculatorService timeCalculatorService;

    public GetStreamsDto.StreamsData getStreamerInfo() throws JsonProcessingException { // 시청수, 스트리머 이름,
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Client-ID",cliendId);
        AccessTokenDao accessTokenDao=twitchAccessTokenService.getAccessToken();
        httpHeaders.add("Authorization: Bearer",accessTokenDao.getAccessToken());
        HttpEntity<String> request=new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchHost)
                .path("/helix/streams")
                .queryParam("first",10)
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
        AccessTokenDao accessTokenDao=twitchAccessTokenService.getAccessToken();
        httpHeaders.add("Authorization: Bearer",accessTokenDao.getAccessToken());
        HttpEntity<String> request=new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchHost)
                .path("/helix/users/follows")
                .queryParam("to_id",userId)
                .build();

        ResponseEntity<String> responseEntity=restTemplate.exchange(uriComponents.toString(),
                HttpMethod.GET,request,String.class);

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        GetUsersDto.UserFollowsData userFollowsData=objectMapper.readValue(responseEntity.getBody(),GetUsersDto.UserFollowsData.class);
        return userFollowsData;
    }

    public GetUsersDto.UserInfo getUserInfo(String userId) throws JsonProcessingException{
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Client-ID",cliendId);
        AccessTokenDao accessTokenDao=twitchAccessTokenService.getAccessToken();
        httpHeaders.add("Authorization: Bearer",accessTokenDao.getAccessToken());
        HttpEntity<String> request=new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchHost)
                .path("/helix/users")
                .queryParam("id",userId)
                .build();

        ResponseEntity<String> responseEntity=restTemplate.exchange(uriComponents.toString(),
                HttpMethod.GET,request,String.class);

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        GetUsersDto.UserInfoDatas userInfoDatas=objectMapper.readValue(responseEntity.getBody(),GetUsersDto.UserInfoDatas.class);
        return userInfoDatas.getUserInfos().get(0);
    }

    private ViewerPair getCurrentViewerAverage(String name, Integer curValue){
        Optional<TableInfoDao> tableInfoDao=tableInfoRepository.findBystreamerName(name);
        if(!tableInfoDao.isPresent()){
            return ViewerPair.builder()
                    .viewerTotal(curValue)
                    .viewerNumber(1)
                    .build();
        }
        else{
            return ViewerPair.builder()
                    .viewerTotal(tableInfoDao.get().getViewerTotal()+curValue)
                    .viewerNumber(tableInfoDao.get().getViewerNumber()+1)
                    .build();
        }
    }

    public String getTotalBroadCastTime(String userId) throws JsonProcessingException, ParseException {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Client-ID",cliendId);
        AccessTokenDao accessTokenDao=twitchAccessTokenService.getAccessToken();
        httpHeaders.add("Authorization: Bearer",accessTokenDao.getAccessToken());
        HttpEntity<String> request=new HttpEntity<String>(httpHeaders);
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host(twitchHost)
                .path("/helix/videos")
                .queryParam("user_id",userId)
                .queryParam("period","week")
                .build();

        ResponseEntity<String> responseEntity=restTemplate.exchange(uriComponents.toString(),
                HttpMethod.GET,request,String.class);

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        GetViedeosDto.ViedeosData viedeosDatas=objectMapper.readValue(responseEntity.getBody(),GetViedeosDto.ViedeosData.class);

        Integer totalTime=0;

        for(int i=0;i<viedeosDatas.getViedeosInfoList().size();i++){
            GetViedeosDto.ViedeosInfo curViedeo=viedeosDatas.getViedeosInfoList().get(i);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
            Date date=simpleDateFormat.parse(curViedeo.getCreateAt());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -7);
            Date limitDay=calendar.getTime();

            if(date.compareTo(limitDay)<0) break;

            totalTime+=timeCalculatorService.StringToInteger(curViedeo.getDuration());
        }

        return timeCalculatorService.InteagerToString(totalTime);
    }

    @Scheduled(fixedDelay = 10000)
    public void rankingTableScheduler() throws JsonProcessingException, ParseException, InterruptedException {

        GetStreamsDto.StreamsData streamsData=getStreamerInfo();
        for(int i=0;i<streamsData.getData().size();i++){
            String curUserName=streamsData.getData().get(i).getUserName();
            GetUsersDto.UserFollowsData userFollowsData= getFollowingCount(streamsData.getData().get(i).getUserId());

            GetUsersDto.UserInfo userInfo=getUserInfo(streamsData.getData().get(i).getUserId());

            ViewerPair currentViewerTotal=getCurrentViewerAverage(curUserName,
                    streamsData.getData().get(i).getViewerCount());

            Integer currentViewerAverage=currentViewerTotal.getViewerTotal()/currentViewerTotal.getViewerNumber();
            log.info(currentViewerAverage.toString() + " " +currentViewerTotal.getViewerTotal()
            + " "+currentViewerTotal.getViewerNumber());

            TableInfoResponseDto tableInfoResponseDto=TableInfoResponseDto.builder()
                    .streamerName(curUserName)
                    .streamerImgUrl(userInfo.getProfileImgUrl())
                    .viewerCount(streamsData.getData().get(i).getViewerCount())
                    .followerCount(userFollowsData.getTotal())
                    .viewerAverage(currentViewerAverage)
                    .broadcastTime(getTotalBroadCastTime(streamsData.getData().get(i).getUserId()))
                    .broadcastEndTime(streamsData.getData().get(i).getStartTime())
                    .viewerTotal(currentViewerTotal.getViewerTotal())
                    .viewerNumber(currentViewerTotal.getViewerNumber())
                    .build();

            log.info(tableInfoResponseDto.getStreamerName());

            Optional<TableInfoDao> tableInfoDao=tableInfoRepository.findBystreamerName(curUserName);

            if(!tableInfoDao.isPresent()){
                tableInfoRepository.save(tableInfoResponseDto.toEntity());
            }
            else{
                tableInfoDao.get().update(curUserName,
                        userInfo.getProfileImgUrl(),
                        streamsData.getData().get(i).getViewerCount(),
                        userFollowsData.getTotal(),
                        currentViewerAverage,
                        getTotalBroadCastTime(streamsData.getData().get(i).getUserId()),
                        streamsData.getData().get(i).getStartTime(),
                        currentViewerTotal.getViewerTotal(),
                        currentViewerTotal.getViewerNumber());

                tableInfoRepository.save(tableInfoDao.get());
            }

            Thread.sleep(10000);

        }

    }
}
