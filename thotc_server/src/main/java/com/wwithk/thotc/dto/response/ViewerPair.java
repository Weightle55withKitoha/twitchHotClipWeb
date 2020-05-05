package com.wwithk.thotc.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
public class ViewerPair {
    Integer viewerTotal;
    Integer viewerNumber;

    @Builder
    public ViewerPair(Integer viewerTotal,Integer viewerNumber){
        this.viewerTotal=viewerTotal;
        this.viewerNumber=viewerNumber;
    }
}
