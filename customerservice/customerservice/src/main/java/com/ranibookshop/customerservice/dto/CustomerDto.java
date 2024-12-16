package com.ranibookshop.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String email;

}
