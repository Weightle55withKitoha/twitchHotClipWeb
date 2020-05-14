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
public class ClipboardInfoDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String broadcasterId;
    private String broadcasterName;
    private String createdAt;
    private String creatorId;
    private String creatorName;
    private String embedUrl;
    private String gameId;
    private String qId;
    private String language;
    private String pagination;
    private String thumbnailUrl;
    private String title;
    private String url;
    private String videoId;
    private int viewCount;

    @Builder
    public ClipboardInfoDao(String broadcasterId,String broadcasterName,String createdAt,String creatorId,String creatorName,
                            String embedUrl, String gameId, String qId, String language, String pagination, String thumbnailUrl,
                            String title, String url, String videoId, int viewCount){
        this.broadcasterId=broadcasterId;
        this.broadcasterName=broadcasterName;
        this.createdAt = createdAt;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.embedUrl = embedUrl;
        this.gameId = gameId;
        this.qId = qId;
        this.language = language;
        this.pagination = pagination;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.url = url;
        this.videoId = videoId;
        this.viewCount = viewCount;
    }

    public void update(String broadcasterId,String broadcasterName,String createdAt,String creatorId,String creatorName,
                            String embedUrl, String gameId, String qId, String language, String pagination, String thumbnailUrl,
                            String title, String url, String videoId, int viewCount){
        this.broadcasterId=broadcasterId;
        this.broadcasterName=broadcasterName;
        this.createdAt = createdAt;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.embedUrl = embedUrl;
        this.gameId = gameId;
        this.qId = qId;
        this.language = language;
        this.pagination = pagination;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.url = url;
        this.videoId = videoId;
        this.viewCount = viewCount;
    }
}
