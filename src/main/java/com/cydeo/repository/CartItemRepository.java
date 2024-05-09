package com.cydeo.repository;

import com.cydeo.entity.Cart;
import com.cydeo.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    //Write a derived query to get the count of all cart items
    long countBy(); // after By it means CarItem because we are in the CartItem Repository
    //Write a derived query to get cart items for specific cart state
    List<CartItem> findByCart_CartState (String cartState);
    //Write a native query to get cart items for specific cart state and product name
    @Query(value = "SELECT ci.quantity, ci.cart_id, ci.id, ci.product_id FROM cart_item ci left join product p on ci.product_id = p.id join cart c on ci.cart_id = c.id where c.cart_state=?1 and p.name =?2",nativeQuery = true)
    List<CartItem> getCartItemByCartStateAndProductName(String cartState, String productName);
    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = "SELECT ci.quantity, ci.cart_id, ci.product_id, ci.id FROM cart_item ci join cart c on ci.cart_id = c.id where c.discount_id is null ",nativeQuery = true)
    List<CartItem> getCartByCartStateDiscountIsNull();
}
