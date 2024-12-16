package com.ranibookshop.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private int id;
    private java.lang.String code;
    private java.lang.String description;
    private int customerId;
    private List<String> books =new ArrayList<>();


}
