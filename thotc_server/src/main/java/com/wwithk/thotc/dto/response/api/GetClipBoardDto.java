package com.wwithk.thotc.dto.response.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class GetClipBoardDto {

    @Getter
    public static class ClipBoardDatas{
        @JsonProperty("data")
        private List<ClipInfo> data;
    }

    @Getter
    public static class ClipInfo{

        @JsonProperty("broadcaster_id")
        private String broadcasterId;

        @JsonProperty("broadcaster_name")
        private String broadcasterName;

        @JsonProperty("created_id")
        private String createdId;

        @JsonProperty("embed_url")
        private String embedUrl;

        @JsonProperty("game_id")
        private String gameId;

        @JsonProperty("id")
        private String qId;

        private String language;
        private String pagination;

        @JsonProperty("thumbnail_url")
        private String thumbnailUrl;

        private String title;
        private String url;

        @JsonProperty("video_id")
        private String videoId;

        @JsonProperty("view_count")
        private int viewCount;

    }
}
