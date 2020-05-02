package com.wwithk.thotc.dto.response.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class GetUsersDto {

    @Getter
    public static class UserFollowsData{
        private Integer total;
    }

    @Getter
    public static class UserInfo{
        @JsonProperty("id")
        private String userId;
        @JsonProperty("profile_image_url")
        private String profileImgUrl;
        @JsonProperty("view_count")
        private Integer viewCount;
    }

}
