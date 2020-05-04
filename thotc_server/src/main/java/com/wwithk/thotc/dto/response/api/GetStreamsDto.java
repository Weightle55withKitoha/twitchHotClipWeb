package com.wwithk.thotc.dto.response.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

public class GetStreamsDto {

    @Getter
    public static class StreamsData{
        @JsonProperty("data")
        private List<StreamsInfo> data;

    }

    @Getter
    public static class StreamsInfo{
        private String id;
        @JsonProperty("user_id")
        private String userId;
        @JsonProperty("user_name")
        private String userName;
        @JsonProperty("game_id")
        private String gameId;
        private String title;
        @JsonProperty("viewer_count")
        private Integer viewerCount;
        @JsonProperty("started_at")
        private String startTime;
    }
}
