package com.cydeo.repository;

import com.cydeo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    //Write a derived query to get all cart by specific discount type
    List<Cart> findByDiscount_DiscountType(String discountType);
    //Write a JPQL query to get all cart by customer

    @Query("select c from Cart c where c.id=?1")
    List<Cart> findByCustomerId(Long id);
}
