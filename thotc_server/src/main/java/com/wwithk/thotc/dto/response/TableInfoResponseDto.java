package com.wwithk.thotc.dto.response;

import com.wwithk.thotc.dao.TableInfoDao;
import lombok.Builder;
import lombok.Data;

@Data
public class TableInfoResponseDto {
    private String streamerName;
    private String streamerImgUrl;
    private int viewerCount;
    private int followerCount;
    private int viewerAverage;
    private String broadcastTime;
    private String broadcastEndDay;
    private String broadcastEndTime;
    private int viewerTotal;
    private int viewerNumber;

    @Builder
    public TableInfoResponseDto(String streamerName,String streamerImgUrl,int viewerCount,int followerCount,int viewerAverage,String broadcastTime,
                                String broadcastEndDay,String broadcastEndTime
    ,int viewerTotal,int viewerNumber){
        this.streamerName=streamerName;
        this.streamerImgUrl=streamerImgUrl;
        this.viewerCount=viewerCount;
        this.followerCount=followerCount;
        this.viewerAverage=viewerAverage;
        this.broadcastTime=broadcastTime;
        this.broadcastEndDay=broadcastEndDay;
        this.broadcastEndTime=broadcastEndTime;
        this.viewerTotal=viewerTotal;
        this.viewerNumber=viewerNumber;
    }

    public TableInfoDao toEntity(){
        return TableInfoDao.builder()
                .streamerName(streamerName)
                .streamerImgUrl(streamerImgUrl)
                .viewerCount(viewerCount)
                .followerCount(followerCount)
                .viewerAverage(viewerAverage)
                .broadcastTime(broadcastTime)
                .broadcastEndDay(broadcastEndDay)
                .broadcastEndTime(broadcastEndTime)
                .viewerTotal(viewerTotal)
                .viewerNumber(viewerNumber)
                .build();
    }

}
