package com.cydeo.repository;

import com.cydeo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    //Write a native query to find the total sum of all payments made
    @Query(value = "select sum(paid_price) from payment ", nativeQuery = true)
    BigDecimal totalSumPaidPrice();
    //write a native query to find the average amount paid for all payments

    @Query(value = "select avg(paid_price) from payment", nativeQuery = true)
    BigDecimal averagePaidAmount();
}
