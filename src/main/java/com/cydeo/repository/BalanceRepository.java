package com.cydeo.repository;

import com.cydeo.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

    //Write a native query to get top 5 max balance
    @Query(value = "select * from balance where amount is not null order by amount desc limit(5)" , nativeQuery = true)
    List<Balance> findTop5MaxBalance();

    //Write a derived query to get all balances greater than or equal to specific balance amount
    List<Balance> findByAmountGreaterThanEqual(BigDecimal amount);

    //Write a native query to get all balances less than specific balance amount
    @Query(value = "select * from balance where amount < ?1", nativeQuery = true)
    List<Balance> findByAmountLessThan(BigDecimal amount);
}
