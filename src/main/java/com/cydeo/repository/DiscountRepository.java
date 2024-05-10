package com.cydeo.repository;

import com.cydeo.entity.Discount;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    //Write a derived query to get all discounts greater than discount amount
    List<Discount>findByDiscountGreaterThan(BigDecimal discount);
    //Write a derived query to get all discounts by specific discount type
    List<Discount>findByDiscountType(DiscountType discountType);
    //Write a JPQL query to get all discounts with the discount amount between given range
    @Query("select d from Discount d where d.discount between ?1 and ?2")
    List<Discount> getAllDiscountBetweenGivenRange(BigDecimal bigDecimal1, BigDecimal bigDecimal2);
}
