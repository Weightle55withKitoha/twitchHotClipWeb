package com.wwithk.thotc.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TimeCalculatorService {

    public Integer StringToInteger(String duration){
        Map<Character,Integer> timers=new HashMap<>();
        timers.put('h',3600);
        timers.put('m',60);
        timers.put('s',1);
        Integer totalValue=0;
        Integer sum=0;

        for(int i=0;i<duration.length();i++){
            char curValue=duration.charAt(i);

            if(timers.containsKey(curValue)){
                sum*=timers.get(curValue);
                totalValue+=sum;
                sum=0;
            }
            else{
                Integer number=duration.charAt(i)-'0';
                sum=(sum*10)+number;
            }

        }

        return totalValue;
    }

    public String InteagerToString(Integer value){
        Integer hour=value/3600;
        Integer minutes=(value%3600)/60;
        Integer seconds=((value%3600)%60);

        return "주 "+Integer.toString(hour)+"시간 "+Integer.toString(minutes)+"분 "+Integer.toString(seconds)+"초";
    }


}
