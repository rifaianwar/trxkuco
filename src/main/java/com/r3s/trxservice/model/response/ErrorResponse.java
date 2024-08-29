package com.r3s.trxservice.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class ErrorResponse {
    private Instant timestamp;
    private int status;
    private String message;
    private Object error;

    public ErrorResponse(Instant timestamp, int httpStatus, String message, Object error) {
        this.timestamp = timestamp;
        this.status = httpStatus;
        this.message = message;
        this.error = error;
    }
}
