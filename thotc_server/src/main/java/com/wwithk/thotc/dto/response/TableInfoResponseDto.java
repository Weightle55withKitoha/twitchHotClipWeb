package com.wwithk.thotc.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
public class TableInfoResponseDto {
    private int viewerCount;
    private int followerCount;
    private int viewerAverage;
    private int broadcastTime;
    private int broadcastEndTime;

    @Builder
    public TableInfoResponseDto(int viewerCount,int followerCount,int viewerAverage,int broadcastTime,int broadcastEndTime){
        this.viewerCount=viewerCount;
        this.followerCount=followerCount;
        this.viewerAverage=viewerAverage;
        this.broadcastTime=broadcastTime;
        this.broadcastEndTime=broadcastEndTime;
    }

}
