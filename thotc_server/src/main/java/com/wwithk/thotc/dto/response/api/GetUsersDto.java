package com.wwithk.thotc.dto.response.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class GetUsersDto {

    @Getter
    public static class UserFollowsData{
        private Integer total;
    }

}
