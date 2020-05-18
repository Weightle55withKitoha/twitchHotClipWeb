package com.wwithk.thotc.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private int status;

    @Builder
    public ErrorResponse(ErrorCode errorCode){
        this.message=errorCode.getMessage();
        this.status=errorCode.getStatus();
    }

}
