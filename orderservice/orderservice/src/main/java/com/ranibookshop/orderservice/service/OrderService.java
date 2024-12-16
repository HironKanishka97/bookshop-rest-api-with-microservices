package com.ranibookshop.orderservice.service;

import com.ranibookshop.orderservice.dto.*;
import com.ranibookshop.orderservice.entity.Order;
import com.ranibookshop.orderservice.repository.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private BookAPIClient bookAPIClient;
    @Autowired
    private CustomerAPIClient customerAPIClient;

    public List<OrderResponseDto> getAllOrders() {
        try {
            List<Order> orders = orderRepo.findAll();
            List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

            if (!orders.isEmpty()) {
                for (Order order : orders) {
                    List<BookDto> books = new ArrayList<>();
                    CustomerDto customer = customerAPIClient.getCustomerById(order.getCustomerId()).getBody().getData();

                    if (order != null) {
                        for (String bookIsbn : order.getBooks()) {
                            ResponseEntity<ResponseDto<BookDto>> res = bookAPIClient.getBookByIsbn(bookIsbn);
                            if (res.getBody().getCode() == 200) {
                                BookDto bookDto = res.getBody().getData();
                                System.out.println(bookDto);
                                books.add(bookDto);
                            }
                        }
                        OrderResponseDto ord = new OrderResponseDto(
                                order.getId() ,order.getCode() ,order.getDescription(),customer,books
                        );
                       orderResponseDtos.add(ord);
                    }
                }
                return orderResponseDtos;
            } else {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public OrderResponseDto getOrderById(int id) {
        try {
            Order order = orderRepo.findById(id).orElse(null);

            List<BookDto> books = new ArrayList<>();

            if (order != null) {
                CustomerDto customer = customerAPIClient.getCustomerById(order.getCustomerId()).getBody().getData();

                for (String bookIsbn : order.getBooks()) {
                    ResponseEntity<ResponseDto<BookDto>> res = bookAPIClient.getBookByIsbn(bookIsbn);
                    if (res.getBody().getCode() == 200) {
                        BookDto bookDto = res.getBody().getData();
                        System.out.println(bookDto);
                        books.add(bookDto);
                    }
                }
                OrderResponseDto ord = new OrderResponseDto(
                        order.getId() ,order.getCode() ,order.getDescription(),customer,books
                );
                return ord;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
