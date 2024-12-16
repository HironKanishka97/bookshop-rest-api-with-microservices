package com.ranibookshop.orderservice.repository;

import com.ranibookshop.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
