package com.ranibookshop.customerservice.service;

import com.ranibookshop.customerservice.dto.CustomerDto;
import com.ranibookshop.customerservice.entity.Customer;

import com.ranibookshop.customerservice.repository.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    public List<CustomerDto> getAllCustomers() {
        try {
            List<Customer> customers = customerRepo.findAll();
            List<CustomerDto> customerDtos = new ArrayList<>();
            for (Customer customer : customers) {
                CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getContact(), customer.getEmail());
                customerDtos.add(customerDto);
            }
            return customerDtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CustomerDto getCustomerById(int id) {
        try {
            Customer customer = customerRepo.findById(id).orElse(null);
            if (customer != null) {
                return new CustomerDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getContact(), customer.getEmail());
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
