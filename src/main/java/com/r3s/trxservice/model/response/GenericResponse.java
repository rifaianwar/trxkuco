package com.r3s.trxservice.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericResponse<T> {
    private int statusCode;
    private String message;
    private T data;

    public GenericResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }


}
