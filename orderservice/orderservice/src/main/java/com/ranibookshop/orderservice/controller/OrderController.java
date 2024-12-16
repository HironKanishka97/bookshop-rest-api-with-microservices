package com.ranibookshop.orderservice.controller;

import com.ranibookshop.orderservice.dto.OrderDto;
import com.ranibookshop.orderservice.dto.OrderResponseDto;
import com.ranibookshop.orderservice.dto.ResponseDto;
import com.ranibookshop.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("api/v1/order/"))
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("getAllOrders")
    public ResponseEntity<ResponseDto> getAllOrders() {
        List<OrderResponseDto> allOrders = orderService.getAllOrders();
        if(!allOrders.isEmpty()){
            return new ResponseEntity<ResponseDto>(
            new ResponseDto(200, "all orders fetched successfully", allOrders), HttpStatus.OK
            );
        }else{
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(204, "Order List Empty", allOrders), HttpStatus.NO_CONTENT
            );
        }
    }

    @GetMapping("getOrderById/{id}")
    public ResponseEntity<ResponseDto> getOrderById(@PathVariable int id) {
        OrderResponseDto order =  orderService.getOrderById(id);
        if(order != null){
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(200,"fetched Success" ,order), HttpStatus.OK
            );
        }else{
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(500,"server error"), HttpStatus.NOT_FOUND
            );
        }

    }


}
