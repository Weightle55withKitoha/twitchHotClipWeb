package com.wwithk.thotc.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
public class DaysPair {
    String day;
    String time;

    @Builder
    public DaysPair(String day,String time){
        this.day=day;
        this.time=time;
    }

}
