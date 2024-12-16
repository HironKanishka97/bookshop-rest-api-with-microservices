package com.ranibookshop.orderservice.service;

import com.ranibookshop.orderservice.dto.CustomerDto;
import com.ranibookshop.orderservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CUSTOMER-SERVICE")
public interface CustomerAPIClient {

    @GetMapping("/api/v1/customers/getCustomerById/{id}")
    ResponseEntity<ResponseDto<CustomerDto>> getCustomerById(@PathVariable int id);

}
