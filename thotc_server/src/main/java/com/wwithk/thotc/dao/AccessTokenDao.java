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
public class AccessTokenDao extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accessToken;
    private Integer expireTime;
    private String tokenType;

    @Builder
    public AccessTokenDao(String accessToken,Integer expireTime,String tokenType){
        this.accessToken=accessToken;
        this.expireTime=expireTime;
        this.tokenType=tokenType;
    }

}
