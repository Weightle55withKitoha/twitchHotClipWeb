package com.wwithk.thotc.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class TableInfoDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String streamerName;
    private String streamerImgUrl;
    private int viewerCount;
    private int followerCount;
    private int viewerAverage;
    private String broadcastTime;
    private String broadcastEndTime;
    private int viewerTotal;
    private int viewerNumber;

    @Builder
    public TableInfoDao(String streamerName,String streamerImgUrl,int viewerCount
            ,int followerCount,int viewerAverage,String broadcastTime,String broadcastEndTime,int viewerTotal,int viewerNumber){
        this.streamerName=streamerName;
        this.streamerImgUrl=streamerImgUrl;
        this.viewerCount=viewerCount;
        this.followerCount=followerCount;
        this.viewerAverage=viewerAverage;
        this.broadcastTime=broadcastTime;
        this.broadcastEndTime=broadcastEndTime;
        this.viewerTotal=viewerTotal;
        this.viewerNumber=viewerNumber;
    }

    public void update(String streamerName,String streamerImgUrl,int viewerCount
            ,int followerCount,int viewerAverage,String broadcastTime,String broadcastEndTime,int viewerTotal,int viewerNumber){
        this.streamerName=streamerName;
        this.streamerImgUrl=streamerImgUrl;
        this.viewerCount=viewerCount;
        this.followerCount=followerCount;
        this.viewerAverage=viewerAverage;
        this.broadcastTime=broadcastTime;
        this.broadcastEndTime=broadcastEndTime;
        this.viewerTotal=viewerTotal;
        this.viewerNumber=viewerNumber;
    }

}
