package com.wwithk.thotc.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    Http_Client_Error(400,"Http Client Error"),
    NULL_POINTER_EXCEPTION(400,"NULL POINTER EXCEPTION"),
    INTERNAL_SERVER_ERROR(400,"INTERNAL Server Error");

    private final String message;
    private int status;

    ErrorCode(final int status, final String message) {
        this.status = status;
        this.message = message;
    }

}
