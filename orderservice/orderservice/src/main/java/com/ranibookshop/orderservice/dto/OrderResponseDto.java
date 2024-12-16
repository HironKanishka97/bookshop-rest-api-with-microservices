package com.ranibookshop.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponseDto {
    private int id;
    private String code;
    private String description;
    private CustomerDto customer;
    private List<BookDto> books =new ArrayList<>();

}
