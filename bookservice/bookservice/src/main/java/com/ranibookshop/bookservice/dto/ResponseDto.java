package com.ranibookshop.bookservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {
    private int code;
    private String message;
    private Object data;

    public ResponseDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
