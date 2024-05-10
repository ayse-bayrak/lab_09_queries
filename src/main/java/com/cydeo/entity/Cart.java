package com.cydeo.entity;

import com.cydeo.enums.CartState;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Cart extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CartState cartState;

    @ManyToOne
    private Discount discount;

    @ManyToOne
    private Customer customer;

    @Override
    public String toString() {
        return "Cart{" +
                "cartState=" + cartState +
                ", discount=" + discount +
                ", customer=" + customer +
                '}';
    }
}
