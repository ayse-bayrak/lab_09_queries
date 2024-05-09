package com.cydeo.repository;

import com.cydeo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    //Write a native query to find the total sum of all payments made

    //write a native query to find the average amount paid for all payments
}
