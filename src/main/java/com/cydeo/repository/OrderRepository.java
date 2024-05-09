package com.cydeo.repository;

import com.cydeo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //Write a derived query to get top 5 orders which are ordered by total price desc

    //Write a derived query to check is there any orders by customer email

    //Write a JPQL query to get all orders that have equal totalPrice and paidPrice

}
