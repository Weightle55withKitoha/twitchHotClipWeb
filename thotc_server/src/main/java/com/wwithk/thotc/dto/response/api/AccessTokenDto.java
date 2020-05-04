package com.wwithk.thotc.dto.response.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wwithk.thotc.dao.AccessTokenDao;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccessTokenDto {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Integer expireTime;
    @JsonProperty("token_type")
    private String tokenType;

    @Builder
    public AccessTokenDto(String accessToken,Integer expireTime,String tokenType){
        this.accessToken=accessToken;
        this.expireTime=expireTime;
        this.tokenType=tokenType;
    }

    public AccessTokenDao toEntity(){
        return AccessTokenDao.builder()
                .accessToken(accessToken)
                .expireTime(expireTime)
                .tokenType(tokenType)
                .build();
    }

}
