package com.ranibookshop.customerservice.controller;

import com.ranibookshop.customerservice.dto.CustomerDto;
import com.ranibookshop.customerservice.dto.ResponseDto;
import com.ranibookshop.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(("api/v1/customers/"))
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("getAllCustomers")
    public ResponseEntity<ResponseDto> getAllCustomers() {
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
        if(!allCustomers.isEmpty()){
            return new ResponseEntity<ResponseDto>(
            new ResponseDto(200, "all customers fetched successfully", allCustomers), HttpStatus.OK
            );
        }else{
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(204, "Customer List Empty", allCustomers), HttpStatus.NO_CONTENT
            );
        }
    }

    @GetMapping("getCustomerById/{id}")
    public ResponseEntity<ResponseDto> getCustomerById(@PathVariable int id) {
        CustomerDto customer =  customerService.getCustomerById(id);
        if(customer != null){
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(200, "Customer fetched successfully", customer), HttpStatus.OK
            );
        }else{
            return new ResponseEntity<ResponseDto>(
                    new ResponseDto(404, "Customer Not Found"), HttpStatus.NOT_FOUND
            );
        }

    }


}
