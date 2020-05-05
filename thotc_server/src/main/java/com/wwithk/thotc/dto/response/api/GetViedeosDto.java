package com.wwithk.thotc.dto.response.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class GetViedeosDto {

    @Getter
    public static class ViedeosData{
        @JsonProperty("data")
        private List<ViedeosInfo> viedeosInfoList;
    }

    @Getter
    public static class ViedeosInfo{
        private String duration;
        @JsonProperty("created_at")
        private String createAt;
    }
}
